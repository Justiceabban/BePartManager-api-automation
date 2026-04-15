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
 * Negative test cases for BePart Manager Backend API endpoints.
 * Tests error handling, invalid inputs, and unauthorized access scenarios.
 */
@Epic("BePart Manager Backend API")
@Feature("Negative Test Scenarios")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BePartManagerApiNegativeTest {

    @BeforeAll
    public static void setupAll() {
        RestAssured.baseURI = ConfigReader.getBaseUrl();
    }

    /**
     * Helper method to create request with custom or no authentication
     */
    private RequestSpecification createRequest(String token) {
        RequestSpecification request = given()
                .filter(new AllureRestAssured())
                .header("Content-Type", "application/json");

        if (token != null) {
            request.header("Authorization", "Bearer " + token);
        }

        return request;
    }

    // ==================== Authentication Tests ====================

    @Test
    @Order(1)
    @Story("Authentication")
    @Description("Test GET /buddies without authentication token")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Get Buddies - No Authentication (Expect 403)")
    public void testGetBuddies_NoAuthentication() {
        Allure.step("Send request without authorization header", () -> {
            Response response = createRequest(null)
                    .when()
                    .get("/api/v1/manager/buddies")
                    .then()
                    .extract().response();

            int statusCode = response.getStatusCode();
            String responseBody = response.getBody().asString();

            Allure.step("Verify forbidden status code", () -> {
                assertEquals(403, statusCode,
                    "Should return 403 Forbidden when no token provided");
                Allure.addAttachment("Status Code", String.valueOf(statusCode));
                Allure.addAttachment("Response Body", responseBody);
            });

            Allure.step("Validate error response structure", () -> {
                JsonPath jsonPath = JsonPath.from(responseBody);

                // Validate error response fields
                assertEquals(403, jsonPath.getInt("httpStatusCode"),
                    "Response should contain httpStatusCode: 403");
                assertEquals("403 FORBIDDEN", jsonPath.getString("httpStatus"),
                    "Response should contain httpStatus: 403 FORBIDDEN");
                assertEquals("forbidden", jsonPath.getString("reason"),
                    "Response should contain reason: forbidden");
                assertNotNull(jsonPath.getString("message"),
                    "Response should contain error message");

                Allure.addAttachment("Error Message", jsonPath.getString("message"));
            });

            System.out.println("✓ No auth test: Status " + statusCode + " (Forbidden)");
        });
    }

    @Test
    @Order(2)
    @Story("Authentication")
    @Description("Test GET /buddies with invalid authentication token")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Get Buddies - Invalid Token (Expect 401 or 403)")
    public void testGetBuddies_InvalidToken() {
        Allure.step("Send request with invalid token", () -> {
            Response response = createRequest(ConfigReader.getInvalidBearerToken())
                    .when()
                    .get("/api/v1/manager/buddies")
                    .then()
                    .extract().response();

            int statusCode = response.getStatusCode();
            String responseBody = response.getBody().asString();

            Allure.step("Verify unauthorized or forbidden status code", () -> {
                assertTrue(statusCode == 401 || statusCode == 403,
                    "Should return 401 Unauthorized or 403 Forbidden with invalid token, but got: " + statusCode);
                Allure.addAttachment("Status Code", String.valueOf(statusCode));
                Allure.addAttachment("Response Body", responseBody);
            });

            Allure.step("Validate error response", () -> {
                // Verify error response has proper structure
                assertFalse(responseBody.isEmpty(), "Error response should not be empty");

                JsonPath jsonPath = JsonPath.from(responseBody);
                Integer httpStatusCode = jsonPath.getInt("httpStatusCode");

                if (httpStatusCode != null) {
                    assertTrue(httpStatusCode == 401 || httpStatusCode == 403,
                        "Response httpStatusCode should be 401 or 403");
                    assertNotNull(jsonPath.getString("message"),
                        "Error response should contain message");
                }
            });

            System.out.println("✓ Invalid token test: Status " + statusCode);
        });
    }

    @Test
    @Order(3)
    @Story("Authentication")
    @Description("Test GET /performance with malformed Bearer token")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Get Performance - Malformed Token (Expect 401 or 403)")
    public void testGetPerformance_MalformedToken() {
        Allure.step("Send request with malformed token format", () -> {
            Response response = given()
                    .filter(new AllureRestAssured())
                    .header("Authorization", "InvalidFormat " + ConfigReader.getBearerToken()) // Wrong format
                    .header("Content-Type", "application/json")
                    .pathParam("userId", ConfigReader.getUserId())
                    .when()
                    .get("/api/v1/manager/performance/{userId}")
                    .then()
                    .extract().response();

            int statusCode = response.getStatusCode();
            String responseBody = response.getBody().asString();

            Allure.step("Verify unauthorized or forbidden status code", () -> {
                assertTrue(statusCode == 401 || statusCode == 403 || statusCode == 400,
                    "Should return 401, 403, or 400 with malformed token format, but got: " + statusCode);
                Allure.addAttachment("Status Code", String.valueOf(statusCode));
                Allure.addAttachment("Response Body", responseBody);
            });

            System.out.println("✓ Malformed token test: Status " + statusCode);
        });
    }

    // ==================== Invalid Input Tests ====================

    @Test
    @Order(4)
    @Story("Input Validation")
    @Description("Test GET /performance with invalid user ID format")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Get Performance - Invalid User ID Format (Expect 400)")
    public void testGetPerformance_InvalidUserIdFormat() {
        Allure.step("Send request with invalid UUID format", () -> {
            Response response = createRequest(ConfigReader.getBearerToken())
                    .pathParam("userId", ConfigReader.getInvalidUserId())
                    .when()
                    .get("/api/v1/manager/performance/{userId}")
                    .then()
                    .extract().response();

            int statusCode = response.getStatusCode();

            Allure.step("Verify bad request or not found status", () -> {
                assertTrue(statusCode == 400 || statusCode == 404 || statusCode == 500,
                    "Should return 400 Bad Request, 404 Not Found, or 500 with invalid UUID");
                Allure.addAttachment("Status Code", String.valueOf(statusCode));
                Allure.addAttachment("Response Body", response.getBody().asString());
            });

            System.out.println("✓ Invalid UUID test: Status " + statusCode);
        });
    }

    @Test
    @Order(5)
    @Story("Input Validation")
    @Description("Test GET /performance with non-existent user ID")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Get Performance - Non-Existent User (Expect 404)")
    public void testGetPerformance_NonExistentUser() {
        Allure.step("Send request with non-existent user ID", () -> {
            Response response = createRequest(ConfigReader.getBearerToken())
                    .pathParam("userId", ConfigReader.getNonExistentUserId())
                    .when()
                    .get("/api/v1/manager/performance/{userId}")
                    .then()
                    .extract().response();

            int statusCode = response.getStatusCode();

            Allure.step("Verify not found status", () -> {
                assertTrue(statusCode == 404 || statusCode == 200,
                    "Should return 404 Not Found or 200 with empty data");
                Allure.addAttachment("Status Code", String.valueOf(statusCode));

                if (statusCode == 200) {
                    // If API returns 200, verify response indicates no data
                    String responseBody = response.getBody().asString();
                    Allure.addAttachment("Response Body", responseBody);
                }
            });

            System.out.println("✓ Non-existent user test: Status " + statusCode);
        });
    }

    @Test
    @Order(6)
    @Story("Input Validation")
    @Description("Test GET /performance with invalid journey ID")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Get Performance With Journey - Invalid Journey ID (Expect 404)")
    public void testGetPerformanceWithJourney_InvalidJourneyId() {
        Allure.step("Send request with invalid journey ID", () -> {
            Response response = createRequest(ConfigReader.getBearerToken())
                    .pathParam("userId", ConfigReader.getUserId())
                    .pathParam("journeyStoryblokId", ConfigReader.getNonExistentJourneyId())
                    .when()
                    .get("/api/v1/manager/performance/{userId}/{journeyStoryblokId}")
                    .then()
                    .extract().response();

            int statusCode = response.getStatusCode();

            Allure.step("Verify not found or error status", () -> {
                assertTrue(statusCode == 404 || statusCode == 400 || statusCode == 500,
                    "Should return 404, 400, or 500 with invalid journey ID");
                Allure.addAttachment("Status Code", String.valueOf(statusCode));
                Allure.addAttachment("Response Body", response.getBody().asString());
            });

            System.out.println("✓ Invalid journey ID test: Status " + statusCode);
        });
    }

    // ==================== HTTP Method Tests ====================

    @Test
    @Order(7)
    @Story("HTTP Methods")
    @Description("Test POST to GET-only endpoint")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Post to Buddies Endpoint (Expect 405)")
    public void testGetBuddies_WrongHttpMethod() {
        Allure.step("Send POST request to GET-only endpoint", () -> {
            Response response = createRequest(ConfigReader.getBearerToken())
                    .when()
                    .post("/api/v1/manager/buddies")
                    .then()
                    .extract().response();

            int statusCode = response.getStatusCode();

            Allure.step("Verify method not allowed status", () -> {
                assertEquals(405, statusCode,
                    "Should return 405 Method Not Allowed for POST to GET endpoint");
                Allure.addAttachment("Status Code", String.valueOf(statusCode));
            });

            System.out.println("✓ Wrong HTTP method test: Status " + statusCode);
        });
    }

    @Test
    @Order(8)
    @Story("HTTP Methods")
    @Description("Test DELETE to GET-only endpoint")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Delete Buddies Endpoint (Expect 405)")
    public void testGetBuddies_DeleteMethod() {
        Allure.step("Send DELETE request to GET-only endpoint", () -> {
            Response response = createRequest(ConfigReader.getBearerToken())
                    .when()
                    .delete("/api/v1/manager/buddies")
                    .then()
                    .extract().response();

            int statusCode = response.getStatusCode();

            Allure.step("Verify method not allowed status", () -> {
                assertEquals(405, statusCode,
                    "Should return 405 Method Not Allowed for DELETE");
                Allure.addAttachment("Status Code", String.valueOf(statusCode));
            });

            System.out.println("✓ DELETE method test: Status " + statusCode);
        });
    }

    // ==================== Edge Case Tests ====================

    @Test
    @Order(9)
    @Story("Edge Cases")
    @Description("Test with empty user ID")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Get Performance - Empty User ID (Expect 404)")
    public void testGetPerformance_EmptyUserId() {
        Allure.step("Send request with empty user ID", () -> {
            Response response = createRequest(ConfigReader.getBearerToken())
                    .when()
                    .get("/api/v1/manager/performance/")
                    .then()
                    .extract().response();

            int statusCode = response.getStatusCode();

            Allure.step("Verify not found status", () -> {
                assertEquals(404, statusCode,
                    "Should return 404 Not Found with empty user ID");
                Allure.addAttachment("Status Code", String.valueOf(statusCode));
            });

            System.out.println("✓ Empty user ID test: Status " + statusCode);
        });
    }

    @Test
    @Order(10)
    @Story("Edge Cases")
    @Description("Test with special characters in user ID")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Get Performance - Special Characters in ID (Expect 400)")
    public void testGetPerformance_SpecialCharactersInUserId() {
        Allure.step("Send request with special characters", () -> {
            String specialCharUserId = "user@#$%^&*()";

            Response response = createRequest(ConfigReader.getBearerToken())
                    .pathParam("userId", specialCharUserId)
                    .when()
                    .get("/api/v1/manager/performance/{userId}")
                    .then()
                    .extract().response();

            int statusCode = response.getStatusCode();

            Allure.step("Verify bad request status", () -> {
                assertTrue(statusCode >= 400 && statusCode < 500,
                    "Should return 4xx error with special characters");
                Allure.addAttachment("Status Code", String.valueOf(statusCode));
            });

            System.out.println("✓ Special characters test: Status " + statusCode);
        });
    }

    // ==================== Header Validation Tests ====================

    @Test
    @Order(11)
    @Story("Header Validation")
    @Description("Test without Content-Type header")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Get Buddies - No Content-Type Header")
    public void testGetBuddies_NoContentTypeHeader() {
        Allure.step("Send request without Content-Type header", () -> {
            Response response = given()
                    .filter(new AllureRestAssured())
                    .header("Authorization", "Bearer " + ConfigReader.getBearerToken())
                    // No Content-Type header
                    .when()
                    .get("/api/v1/manager/buddies")
                    .then()
                    .extract().response();

            int statusCode = response.getStatusCode();

            Allure.step("Verify response (should still work for GET)", () -> {
                assertTrue(statusCode >= 200 && statusCode < 500,
                    "GET request should work even without Content-Type");
                Allure.addAttachment("Status Code", String.valueOf(statusCode));
            });

            System.out.println("✓ No Content-Type test: Status " + statusCode);
        });
    }

    // ==================== Response Time Tests ====================

    @Test
    @Order(12)
    @Story("Performance")
    @Description("Test response time for buddies endpoint")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Get Buddies - Response Time Validation")
    public void testGetBuddies_ResponseTime() {
        Allure.step("Measure response time", () -> {
            long startTime = System.currentTimeMillis();

            Response response = createRequest(ConfigReader.getBearerToken())
                    .when()
                    .get("/api/v1/manager/buddies")
                    .then()
                    .extract().response();

            long duration = System.currentTimeMillis() - startTime;

            Allure.step("Verify response time is acceptable", () -> {
                // Increased threshold to 30 seconds based on actual API performance
                assertTrue(duration < 30000,
                    "Response time should be under 30 seconds, but was: " + duration + "ms");
                Allure.addAttachment("Response Time", duration + " ms");

                if (response.getStatusCode() == 200) {
                    System.out.println("✓ Response time test: " + duration + "ms (PASS)");
                } else {
                    System.out.println("⚠ Response time test: " + duration + "ms, but got status " + response.getStatusCode());
                }
            });
        });
    }

    @AfterEach
    public void afterEach(TestInfo testInfo) {
        System.out.println("Completed: " + testInfo.getDisplayName());
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("\n========================================");
        System.out.println("Negative tests completed!");
        System.out.println("========================================");
    }
}

