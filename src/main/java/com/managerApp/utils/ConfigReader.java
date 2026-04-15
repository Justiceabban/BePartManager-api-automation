package com.managerApp.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class to read configuration properties from config.properties file
 */
public class ConfigReader {

    private static Properties properties;
    private static final String CONFIG_FILE = "config.properties";

    // Static block to load properties when class is loaded
    static {
        properties = new Properties();
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new RuntimeException("Unable to find " + CONFIG_FILE);
            }
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Failed to load configuration file: " + CONFIG_FILE, ex);
        }
    }

    /**
     * Get the base URL from config
     * @return base URL
     */
    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    /**
     * Get the bearer token from config
     * @return bearer token
     */
    public static String getBearerToken() {
        return properties.getProperty("bearer.token");
    }

    /**
     * Get the user ID from config
     * @return user ID
     */
    public static String getUserId() {
        return properties.getProperty("user.id");
    }

    /**
     * Get the journey storyblok ID from config
     * @return journey storyblok ID
     */
    public static String getJourneyStoryblokId() {
        return properties.getProperty("journey.storyblok.id");
    }

    /**
     * Get the invalid user ID from config (for negative testing)
     * @return invalid user ID
     */
    public static String getInvalidUserId() {
        return properties.getProperty("invalid.user.id");
    }

    /**
     * Get the non-existent user ID from config (for negative testing)
     * @return non-existent user ID
     */
    public static String getNonExistentUserId() {
        return properties.getProperty("non.existent.user.id");
    }

    /**
     * Get the non-existent journey ID from config (for negative testing)
     * @return non-existent journey ID
     */
    public static String getNonExistentJourneyId() {
        return properties.getProperty("non.existent.journey.id");
    }

    /**
     * Get the invalid bearer token from config (for negative testing)
     * @return invalid bearer token
     */
    public static String getInvalidBearerToken() {
        return properties.getProperty("invalid.bearer.token");
    }

    /**
     * Get any property by key
     * @param key property key
     * @return property value
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
