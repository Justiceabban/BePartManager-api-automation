package com.managerApp.api;

import com.managerApp.utils.ConfigReader;
import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Automated API tests for BePart Manager Backend API endpoints with Allure reporting.
 * This class tests five GET endpoints with Rest-Assured and JUnit 5.
 */
@Epic("BePart Manager Backend API")
@Feature("Manager API Endpoints")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BePartManagerApiTest {

    @BeforeAll
    @Step("Setup test environment")
    public static void setupAll() {
        RestAssured.baseURI = ConfigReader.getBaseUrl();
        Allure.parameter("Base URL", ConfigReader.getBaseUrl());
        Allure.parameter("User ID", ConfigReader.getUserId());
        Allure.parameter("Journey Storyblok ID", ConfigReader.getJourneyStoryblokId());
    }

    /**
     * Create a request specification with Bearer token authentication and Allure filter
     * @return RequestSpecification with Authorization header and Allure reporting
     */
    @Step("Creating authenticated request")
    private RequestSpecification getAuthenticatedRequest() {
        return given()
                .filter(new AllureRestAssured())
                .header("Authorization", "Bearer " + ConfigReader.getBearerToken())
                .header("Content-Type", "application/json");
    }

    /**
     * Test 1: GET /api/v1/manager/buddies
     * No path parameters required
     */
    @Test
    @Order(1)
    @Story("Buddies Management")
    @Description("Test to retrieve the list of buddies from the manager endpoint")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Get Buddies List")
    public void testGetBuddies() {
        Allure.step("Send GET request to /api/v1/manager/buddies", () -> {
            Response response = getAuthenticatedRequest()
                    .when()
                    .get("/api/v1/manager/buddies")
                    .then()
                    .extract().response();

            int statusCode = response.getStatusCode();
            String responseBody = response.getBody().asString();

            Allure.step("Verify response status code", () -> {
                Allure.addAttachment("Status Code", String.valueOf(statusCode));
                assertTrue(statusCode >= 200 && statusCode < 300,
                    "Expected successful status code, but got: " + statusCode);
            });

            Allure.step("Parse and validate JSON response structure", () -> {
                JsonPath jsonPath = JsonPath.from(responseBody);

                // Validate response has content array
                assertNotNull(jsonPath.getList("content"), "Response should contain 'content' array");
                assertFalse(jsonPath.getList("content").isEmpty(), "Content array should not be empty");

                Allure.addAttachment("Content Count", String.valueOf(jsonPath.getList("content").size()));
            });

            Allure.step("Validate pagination information", () -> {
                JsonPath jsonPath = JsonPath.from(responseBody);

                // Validate pageable object
                assertNotNull(jsonPath.getInt("pageable.pageNumber"), "pageNumber should exist");
                assertNotNull(jsonPath.getInt("pageable.pageSize"), "pageSize should exist");
                assertTrue(jsonPath.getInt("totalElements") > 0, "totalElements should be greater than 0");
                assertTrue(jsonPath.getInt("totalPages") > 0, "totalPages should be greater than 0");

                Allure.addAttachment("Total Elements", String.valueOf(jsonPath.getInt("totalElements")));
                Allure.addAttachment("Total Pages", String.valueOf(jsonPath.getInt("totalPages")));
            });

            Allure.step("Validate individual user data structure", () -> {
                JsonPath jsonPath = JsonPath.from(responseBody);

                // Get first user from content
                String userId = jsonPath.getString("content[0].id");
                String userName = jsonPath.getString("content[0].username");
                String firstName = jsonPath.getString("content[0].firstName");
                String email = jsonPath.getString("content[0].email");
                String status = jsonPath.getString("content[0].status");

                // Validate required fields exist and are not null
                assertNotNull(userId, "User ID should not be null");
                assertNotNull(userName, "Username should not be null");
                assertNotNull(firstName, "First name should not be null");
                assertNotNull(email, "Email should not be null");
                assertNotNull(status, "Status should not be null");

                // Validate status is one of expected values
                assertTrue(status.equals("ACTIVE") || status.equals("INACTIVE"),
                    "Status should be ACTIVE or INACTIVE");

                Allure.addAttachment("First User ID", userId);
                Allure.addAttachment("First User Email", email);
            });

            Allure.step("Validate assigned journeys data", () -> {
                JsonPath jsonPath = JsonPath.from(responseBody);

                // Validate assigned journeys exist
                java.util.List<Object> journeys = jsonPath.getList("content[0].assignedJourneys");
                assertNotNull(journeys, "Assigned journeys should exist");
                assertFalse(journeys.isEmpty(), "User should have at least one journey");

                // Validate journey structure
                String journeyId = jsonPath.getString("content[0].assignedJourneys[0].journeyId");
                String journeyTitle = jsonPath.getString("content[0].assignedJourneys[0].title");
                Double progress = jsonPath.getDouble("content[0].assignedJourneys[0].progress");

                assertNotNull(journeyId, "Journey ID should not be null");
                assertNotNull(journeyTitle, "Journey title should not be null");
                assertNotNull(progress, "Journey progress should not be null");
                assertTrue(progress >= 0 && progress <= 100, "Progress should be between 0 and 100");

                Allure.addAttachment("Journey Title", journeyTitle);
                Allure.addAttachment("Journey Progress", String.valueOf(progress) + "%");
            });

            Allure.step("Capture response body", () -> {
                Allure.addAttachment("Response Body", "application/json", responseBody);
            });

            System.out.println("Status Code: " + statusCode);
            System.out.println("Response Body: " + responseBody);
        });
    }

    /**
     * Test 2: GET /api/v1/manager/performance/{userId}/{journeyStoryblokId}
     * Both path parameters required
     */
    @Test
    @Order(2)
    @Story("Performance Management")
    @Description("Test to retrieve performance data with both userId and journeyStoryblokId")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Get Performance with Journey")
    public void testGetPerformanceWithJourney() {
        Allure.parameter("userId", ConfigReader.getUserId());
        Allure.parameter("journeyStoryblokId", ConfigReader.getJourneyStoryblokId());

        Allure.step("Send GET request to /api/v1/manager/performance/{userId}/{journeyStoryblokId}", () -> {
            Response response = getAuthenticatedRequest()
                    .pathParam("userId", ConfigReader.getUserId())
                    .pathParam("journeyStoryblokId", ConfigReader.getJourneyStoryblokId())
                    .queryParam("lang", "en_gb")
                    .when()
                    .get("/api/v1/manager/performance/{userId}/{journeyStoryblokId}")
                    .then()
                    .extract().response();

            int statusCode = response.getStatusCode();
            String responseBody = response.getBody().asString();
            
            System.out.println("Performance with Journey Response:");
            System.out.println("Status Code: " + statusCode);
            System.out.println("Response Body: " + responseBody);

            Allure.step("Verify response status code", () -> {
                Allure.addAttachment("Status Code", String.valueOf(statusCode));
                assertTrue(statusCode >= 200 && statusCode < 300,
                    "Expected successful status code, but got: " + statusCode);
            });

            Allure.step("Validate journey basic information", () -> {
                JsonPath jsonPath = JsonPath.from(responseBody);

                String journeyId = jsonPath.getString("id");
                String journeyTitle = jsonPath.getString("title");
                String defaultLanguage = jsonPath.getString("defaultLanguage");

                assertNotNull(journeyId, "Journey ID should not be null");
                assertNotNull(journeyTitle, "Journey title should not be null");
                assertNotNull(defaultLanguage, "Default language should not be null");

                Allure.addAttachment("Journey ID", journeyId);
                Allure.addAttachment("Journey Title", journeyTitle);
                Allure.addAttachment("Default Language", defaultLanguage);
            });

            Allure.step("Validate stages progress data", () -> {
                JsonPath jsonPath = JsonPath.from(responseBody);

                java.util.List<Object> stagesProgress = jsonPath.getList("stagesProgress");
                assertNotNull(stagesProgress, "Stages progress should exist");
                assertFalse(stagesProgress.isEmpty(), "Stages progress should not be empty");

                // Validate each stage has required fields
                for (int i = 0; i < stagesProgress.size(); i++) {
                    String stageId = jsonPath.getString("stagesProgress[" + i + "].id");
                    String stageTitle = jsonPath.getString("stagesProgress[" + i + "].title");
                    Double stageProgress = jsonPath.getDouble("stagesProgress[" + i + "].progress");

                    assertNotNull(stageId, "Stage ID should not be null");
                    assertNotNull(stageTitle, "Stage title should not be null");
                    assertNotNull(stageProgress, "Stage progress should not be null");
                    assertTrue(stageProgress >= 0 && stageProgress <= 100,
                        "Stage progress should be between 0 and 100");
                }

                Allure.addAttachment("Number of Stages", String.valueOf(stagesProgress.size()));
            });

            Allure.step("Validate chapters progress data (nested in stages)", () -> {
                JsonPath jsonPath = JsonPath.from(responseBody);

                // Chapters are nested inside each stage
                java.util.List<Object> stagesProgress = jsonPath.getList("stagesProgress");
                int totalChapters = 0;
                
                for (int stageIndex = 0; stageIndex < stagesProgress.size(); stageIndex++) {
                    java.util.List<Object> chaptersInStage = jsonPath.getList("stagesProgress[" + stageIndex + "].chaptersProgress");
                    
                    if (chaptersInStage != null && !chaptersInStage.isEmpty()) {
                        totalChapters += chaptersInStage.size();
                        
                        // Validate each chapter has required fields
                        for (int i = 0; i < chaptersInStage.size(); i++) {
                            String chapterId = jsonPath.getString("stagesProgress[" + stageIndex + "].chaptersProgress[" + i + "].id");
                            String chapterTitle = jsonPath.getString("stagesProgress[" + stageIndex + "].chaptersProgress[" + i + "].title");
                            Double chapterProgress = jsonPath.getDouble("stagesProgress[" + stageIndex + "].chaptersProgress[" + i + "].progress");

                            assertNotNull(chapterId, "Chapter ID should not be null");
                            assertNotNull(chapterTitle, "Chapter title should not be null");
                            assertNotNull(chapterProgress, "Chapter progress should not be null");
                            assertTrue(chapterProgress >= 0 && chapterProgress <= 100,
                                "Chapter progress should be between 0 and 100");
                        }
                    }
                }

                assertTrue(totalChapters > 0, "Should have at least one chapter across all stages");
                Allure.addAttachment("Total Number of Chapters", String.valueOf(totalChapters));
            });

            Allure.step("Capture response body", () -> {
                Allure.addAttachment("Response Body", "application/json", responseBody);
            });

            System.out.println("Status Code: " + statusCode);
            System.out.println("Response Body: " + responseBody);
        });
    }

    /**
     * Test 3: GET /api/v1/manager/buddies/{userId}
     * Only userId as path parameter
     */
    @Test
    @Order(3)
    @Story("Buddies Management")
    @Description("Test to retrieve detailed buddy information for a specific user")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Get Buddy by User ID")
    public void testGetBuddyByUserId() {
        Allure.parameter("userId", ConfigReader.getUserId());

        Allure.step("Send GET request to /api/v1/manager/buddies/{userId}", () -> {
            Response response = getAuthenticatedRequest()
                    .pathParam("userId", ConfigReader.getUserId())
                    .when()
                    .get("/api/v1/manager/buddies/{userId}")
                    .then()
                    .extract().response();

            int statusCode = response.getStatusCode();
            String responseBody = response.getBody().asString();
            
            System.out.println("Buddy by User ID Response:");
            System.out.println("Status Code: " + statusCode);
            System.out.println("Response Body: " + responseBody);

            Allure.step("Verify response status code", () -> {
                Allure.addAttachment("Status Code", String.valueOf(statusCode));
                assertTrue(statusCode >= 200 && statusCode < 300,
                    "Expected successful status code, but got: " + statusCode);
            });

            Allure.step("Validate user profile information", () -> {
                JsonPath jsonPath = JsonPath.from(responseBody);

                String userId = jsonPath.getString("id");
                String userName = jsonPath.getString("username");
                String firstName = jsonPath.getString("firstName");
                String lastName = jsonPath.getString("lastName");
                String email = jsonPath.getString("email");
                String status = jsonPath.getString("status");

                assertNotNull(userId, "User ID should not be null");
                assertNotNull(userName, "Username should not be null");
                assertNotNull(firstName, "First name should not be null");
                assertNotNull(email, "Email should not be null");
                assertNotNull(status, "Status should not be null");

                assertTrue(email.contains("@"), "Email should be valid");
                assertTrue(status.equals("ACTIVE") || status.equals("INACTIVE"),
                    "Status should be ACTIVE or INACTIVE");

                Allure.addAttachment("User ID", userId);
                Allure.addAttachment("User Email", email);
                Allure.addAttachment("User Status", status);
            });

            Allure.step("Validate assigned journeys data", () -> {
                JsonPath jsonPath = JsonPath.from(responseBody);

                java.util.List<Object> journeys = jsonPath.getList("assignedJourneys");
                assertNotNull(journeys, "Assigned journeys should exist");
                assertFalse(journeys.isEmpty(), "User should have at least one assigned journey");

                // Validate each journey
                for (int i = 0; i < journeys.size(); i++) {
                    String journeyId = jsonPath.getString("assignedJourneys[" + i + "].journeyId");
                    String journeyTitle = jsonPath.getString("assignedJourneys[" + i + "].title");
                    Double journeyProgress = jsonPath.getDouble("assignedJourneys[" + i + "].progress");

                    assertNotNull(journeyId, "Journey ID should not be null");
                    assertNotNull(journeyTitle, "Journey title should not be null");
                    assertNotNull(journeyProgress, "Journey progress should not be null");
                    assertTrue(journeyProgress >= 0 && journeyProgress <= 100,
                        "Journey progress should be between 0 and 100");
                }

                Allure.addAttachment("Number of Assigned Journeys", String.valueOf(journeys.size()));
            });

            Allure.step("Validate journey details", () -> {
                JsonPath jsonPath = JsonPath.from(responseBody);

                // Validate first journey's detailed information
                String firstJourneyId = jsonPath.getString("assignedJourneys[0].journeyId");
                String firstJourneyTitle = jsonPath.getString("assignedJourneys[0].title");
                Double firstJourneyProgress = jsonPath.getDouble("assignedJourneys[0].progress");

                assertNotNull(firstJourneyId, "First journey ID should not be null");
                assertNotNull(firstJourneyTitle, "First journey title should not be null");
                assertNotNull(firstJourneyProgress, "First journey progress should not be null");

                Allure.addAttachment("First Journey ID", firstJourneyId);
                Allure.addAttachment("First Journey Title", firstJourneyTitle);
                Allure.addAttachment("First Journey Progress", String.valueOf(firstJourneyProgress) + "%");
            });

            Allure.step("Capture response body", () -> {
                Allure.addAttachment("Response Body", "application/json", responseBody);
            });

            System.out.println("Status Code: " + statusCode);
            System.out.println("Response Body: " + responseBody);
        });
    }

    /**
     * Test 4: GET /api/v1/manager/feedback/{userId}/{journeyStoryblokId}
     * Both path parameters required
     */
    @Test
    @Order(4)
    @Story("Feedback Management")
    @Description("Test to retrieve feedback data for a user and journey")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Get Feedback Data")
    public void testGetFeedback() {
        Allure.parameter("userId", ConfigReader.getUserId());
        Allure.parameter("journeyStoryblokId", ConfigReader.getJourneyStoryblokId());

        Allure.step("Send GET request to /api/v1/manager/feedback/{userId}/{journeyStoryblokId}", () -> {
            Response response = getAuthenticatedRequest()
                    .pathParam("userId", ConfigReader.getUserId())
                    .pathParam("journeyStoryblokId", ConfigReader.getJourneyStoryblokId())
                    .when()
                    .get("/api/v1/manager/feedback/{userId}/{journeyStoryblokId}")
                    .then()
                    .extract().response();

            int statusCode = response.getStatusCode();
            String responseBody = response.getBody().asString();
            
            System.out.println("Feedback Response:");
            System.out.println("Status Code: " + statusCode);
            System.out.println("Response Body: " + responseBody);

            Allure.step("Verify response status code", () -> {
                Allure.addAttachment("Status Code", String.valueOf(statusCode));
                assertTrue(statusCode >= 200 && statusCode < 300,
                    "Expected successful status code, but got: " + statusCode);
            });

            Allure.step("Validate feedback response structure", () -> {
                JsonPath jsonPath = JsonPath.from(responseBody);
                
                String title = jsonPath.getString("title");
                assertNotNull(title, "Journey title should not be null");
                
                java.util.List<Object> feedbackList = jsonPath.getList("feedback");
                assertNotNull(feedbackList, "Feedback array should exist");
                
                Allure.addAttachment("Journey Title", title);
            });

            Allure.step("Validate individual feedback entries", () -> {
                JsonPath jsonPath = JsonPath.from(responseBody);

                java.util.List<Object> feedbackList = jsonPath.getList("feedback");
                int feedbackCount = feedbackList.size();
                
                if (feedbackCount > 0) {
                    for (int i = 0; i < feedbackCount; i++) {
                        String id = jsonPath.getString("feedback[" + i + "].id");
                        String title = jsonPath.getString("feedback[" + i + "].title");
                        Integer rating = jsonPath.getInt("feedback[" + i + "].rating");
                        String feedbackText = jsonPath.getString("feedback[" + i + "].feedbackText");
                        String createdAt = jsonPath.getString("feedback[" + i + "].createdAt");

                        assertNotNull(id, "Feedback ID should not be null");
                        assertNotNull(title, "Feedback title should not be null");
                        assertNotNull(rating, "Rating should not be null");
                        assertNotNull(createdAt, "Created date should not be null");

                        // Validate rating is between 1-5
                        assertTrue(rating >= 1 && rating <= 5,
                            "Rating should be between 1 and 5, but got: " + rating);

                        // Validate date format (DD/MM/YYYY)
                        assertTrue(createdAt.matches("\\d{2}/\\d{2}/\\d{4}"),
                            "Date should be in DD/MM/YYYY format");
                    }
                }

                Allure.addAttachment("Number of Feedback Entries", String.valueOf(feedbackCount));
            });

            Allure.step("Validate feedback content details", () -> {
                JsonPath jsonPath = JsonPath.from(responseBody);

                java.util.List<Object> feedbackList = jsonPath.getList("feedback");
                if (feedbackList != null && !feedbackList.isEmpty()) {
                    Integer rating = jsonPath.getInt("feedback[0].rating");
                    String feedbackText = jsonPath.getString("feedback[0].feedbackText");

                    assertNotNull(rating, "First feedback rating should not be null");
                    assertTrue(feedbackText == null || !feedbackText.trim().isEmpty(),
                        "Feedback text should be either null or non-empty");
                }
            });

            Allure.step("Capture response body", () -> {
                Allure.addAttachment("Response Body", "application/json", responseBody);
            });

            System.out.println("Status Code: " + statusCode);
            System.out.println("Response Body: " + responseBody);
        });
    }

    /**
     * Test 5: GET /api/v1/manager/checklist/{userId}/{journeyStoryblokId}
     * Both path parameters required
     */
    @Test
    @Order(5)
    @Story("Checklist Management")
    @Description("Test to retrieve checklist data for a user and journey")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Get Checklist Data")
    public void testGetChecklist() {
        Allure.parameter("userId", ConfigReader.getUserId());
        Allure.parameter("journeyStoryblokId", ConfigReader.getJourneyStoryblokId());

        Allure.step("Send GET request to /api/v1/manager/checklist/{userId}/{journeyStoryblokId}", () -> {
            Response response = getAuthenticatedRequest()
                    .pathParam("userId", ConfigReader.getUserId())
                    .pathParam("journeyStoryblokId", ConfigReader.getJourneyStoryblokId())
                    .queryParam("lang", "en_gb")
                    .when()
                    .get("/api/v1/manager/checklist/{userId}/{journeyStoryblokId}")
                    .then()
                    .extract().response();

            int statusCode = response.getStatusCode();
            String responseBody = response.getBody().asString();
            
            System.out.println("Checklist Response:");
            System.out.println("Status Code: " + statusCode);
            System.out.println("Response Body: " + responseBody);

            Allure.step("Verify response status code", () -> {
                Allure.addAttachment("Status Code", String.valueOf(statusCode));
                assertTrue(statusCode >= 200 && statusCode < 300,
                    "Expected successful status code, but got: " + statusCode);
            });

            Allure.step("Validate checklist response structure", () -> {
                JsonPath jsonPath = JsonPath.from(responseBody);
                
                String title = jsonPath.getString("title");
                assertNotNull(title, "Journey title should not be null");
                
                java.util.List<Object> checklistItems = jsonPath.getList("checklist");
                assertNotNull(checklistItems, "Checklist array should exist");
                
                Integer checklistCount = jsonPath.getInt("checklistCount");
                assertNotNull(checklistCount, "Checklist count should exist");
                
                Allure.addAttachment("Journey Title", title);
                Allure.addAttachment("Checklist Count", String.valueOf(checklistCount));
            });

            Allure.step("Validate individual checklist items", () -> {
                JsonPath jsonPath = JsonPath.from(responseBody);

                java.util.List<Object> checklistItems = jsonPath.getList("checklist");
                int itemCount = checklistItems.size();
                assertTrue(itemCount > 0, "Checklist should not be empty");

                for (int i = 0; i < itemCount; i++) {
                    String id = jsonPath.getString("checklist[" + i + "].id");
                    String lang = jsonPath.getString("checklist[" + i + "].lang");
                    Integer daysToComplete = jsonPath.getInt("checklist[" + i + "].daysToComplete");
                    Object description = jsonPath.get("checklist[" + i + "].description");
                    String status = jsonPath.getString("checklist[" + i + "].status");

                    assertNotNull(id, "Checklist item ID should not be null");
                    assertNotNull(lang, "Language should not be null");
                    assertNotNull(daysToComplete, "Days to complete should not be null");
                    assertNotNull(description, "Description should not be null");
                    assertNotNull(status, "Status should not be null");

                    // Validate days to complete is non-negative
                    assertTrue(daysToComplete >= 0,
                        "Days to complete should be non-negative");
                }

                Allure.addAttachment("Number of Checklist Items", String.valueOf(itemCount));
            });

            Allure.step("Validate checklist description structure", () -> {
                JsonPath jsonPath = JsonPath.from(responseBody);

                // Validate description JSON structure for first item
                String descType = jsonPath.getString("checklist[0].description.type");
                Object content = jsonPath.get("checklist[0].description.content");

                assertNotNull(descType, "Description type should not be null");
                assertEquals("doc", descType, "Description type should be 'doc'");
                assertNotNull(content, "Description content should not be null");
            });

            Allure.step("Validate checklist item content details", () -> {
                JsonPath jsonPath = JsonPath.from(responseBody);

                // Validate that text content exists in description
                java.util.List<Object> contentArray = jsonPath.getList("checklist[0].description.content");
                assertFalse(contentArray.isEmpty(), "Description content array should not be empty");

                // Check for paragraph structure
                String contentType = jsonPath.getString("checklist[0].description.content[0].type");
                assertEquals("paragraph", contentType, "Content should contain paragraphs");
            });

            Allure.step("Capture response body", () -> {
                Allure.addAttachment("Response Body", "application/json", responseBody);
            });

            System.out.println("Status Code: " + statusCode);
            System.out.println("Response Body: " + responseBody);
        });
    }

    @AfterEach
    public void afterEach(TestInfo testInfo) {
        System.out.println("\n✓ Test completed: " + testInfo.getDisplayName());
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("\n========================================");
        System.out.println("All tests completed!");
        System.out.println("========================================");
    }
}

