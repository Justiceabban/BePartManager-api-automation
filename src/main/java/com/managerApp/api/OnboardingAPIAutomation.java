package com.managerApp.api;

import com.managerApp.utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

/**
 * Automated API tests for Onboarding Backend API endpoints.
 * This class tests five GET endpoints with Rest-Assured.
 */
public class OnboardingAPIAutomation {

    /**
     * Initialize the base URI for Rest-Assured
     */
    private static void setupBaseURI() {
        RestAssured.baseURI = ConfigReader.getBaseUrl();
    }

    /**
     * Create a request specification with Bearer token authentication
     * @return RequestSpecification with Authorization header
     */
    private static RequestSpecification getAuthenticatedRequest() {
        return given()
                .header("Authorization", "Bearer " + ConfigReader.getBearerToken())
                .header("Content-Type", "application/json")
                .log().all();
    }

    /**
     * Test 1: GET /api/v1/manager/buddies
     * No path parameters required
     */
    public static void testGetBuddies() {
        System.out.println("\n========================================");
        System.out.println("TEST 1: GET /api/v1/manager/buddies");
        System.out.println("========================================");

        Response response = getAuthenticatedRequest()
                .when()
                .get("/api/v1/manager/buddies")
                .then()
                .log().all()
                .extract().response();

        System.out.println("\nStatus Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
    }

    /**
     * Test 2: GET /api/v1/manager/performance/{userId}/{journeyStoryblokId}
     * Both path parameters required
     */
    public static void testGetPerformanceWithJourney() {
        System.out.println("\n========================================");
        System.out.println("TEST 2: GET /api/v1/manager/performance/{userId}/{journeyStoryblokId}");
        System.out.println("========================================");

        Response response = getAuthenticatedRequest()
                .pathParam("userId", ConfigReader.getUserId())
                .pathParam("journeyStoryblokId", ConfigReader.getJourneyStoryblokId())
                .when()
                .get("/api/v1/manager/performance/{userId}/{journeyStoryblokId}")
                .then()
                .log().all()
                .extract().response();

        System.out.println("\nStatus Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
    }

    /**
     * Test 3: GET /api/v1/manager/performance/{userId}
     * Only userId as path parameter
     */
    public static void testGetPerformance() {
        System.out.println("\n========================================");
        System.out.println("TEST 3: GET /api/v1/manager/performance/{userId}");
        System.out.println("========================================");

        Response response = getAuthenticatedRequest()
                .pathParam("userId", ConfigReader.getUserId())
                .when()
                .get("/api/v1/manager/performance/{userId}")
                .then()
                .log().all()
                .extract().response();

        System.out.println("\nStatus Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
    }

    /**
     * Test 4: GET /api/v1/manager/feedback/{userId}/{journeyStoryblokId}
     * Both path parameters required
     */
    public static void testGetFeedback() {
        System.out.println("\n========================================");
        System.out.println("TEST 4: GET /api/v1/manager/feedback/{userId}/{journeyStoryblokId}");
        System.out.println("========================================");

        Response response = getAuthenticatedRequest()
                .pathParam("userId", ConfigReader.getUserId())
                .pathParam("journeyStoryblokId", ConfigReader.getJourneyStoryblokId())
                .when()
                .get("/api/v1/manager/feedback/{userId}/{journeyStoryblokId}")
                .then()
                .log().all()
                .extract().response();

        System.out.println("\nStatus Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
    }

    /**
     * Test 5: GET /api/v1/manager/checklist/{userId}/{journeyStoryblokId}
     * Both path parameters required
     */
    public static void testGetChecklist() {
        System.out.println("\n========================================");
        System.out.println("TEST 5: GET /api/v1/manager/checklist/{userId}/{journeyStoryblokId}");
        System.out.println("========================================");

        Response response = getAuthenticatedRequest()
                .pathParam("userId", ConfigReader.getUserId())
                .pathParam("journeyStoryblokId", ConfigReader.getJourneyStoryblokId())
                .when()
                .get("/api/v1/manager/checklist/{userId}/{journeyStoryblokId}")
                .then()
                .log().all()
                .extract().response();

        System.out.println("\nStatus Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
    }

    /**
     * Main method to execute all API tests in sequence
     */
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║   ONBOARDING BACKEND API AUTOMATION TEST SUITE       ║");
        System.out.println("║   Using Rest-Assured Library                          ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println("\nBase URL: " + ConfigReader.getBaseUrl());
        System.out.println("User ID: " + ConfigReader.getUserId());
        System.out.println("Journey Storyblok ID: " + ConfigReader.getJourneyStoryblokId());

        // Setup base URI
        setupBaseURI();

        try {
            // Execute all tests in sequence
            testGetBuddies();

            Thread.sleep(1000); // Small delay between requests
            testGetPerformanceWithJourney();

            Thread.sleep(1000);
            testGetPerformance();

            Thread.sleep(1000);
            testGetFeedback();

            Thread.sleep(1000);
            testGetChecklist();

            System.out.println("\n╔════════════════════════════════════════════════════════╗");
            System.out.println("║   ALL TESTS COMPLETED SUCCESSFULLY                    ║");
            System.out.println("╚════════════════════════════════════════════════════════╝");

        } catch (Exception e) {
            System.err.println("\n❌ Error occurred during test execution: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

