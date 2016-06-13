package com.nbc.template;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.JsonParserFactory;

/**
 * PDF Renderer Spring Boot application
 */
@SpringBootApplication
public class TemplateApplication {
    /**
     * The default application name to be used for logging if the actual name cannot be determined from System properties
     */
    private static final String DEFAULT_APPLICATION_NAME = "template";

    /**
     * Main method, used to run the application.
     *
     * @param args command line arguments to customize execution of the application
     */
    public static void main(String[] args) {
        System.setProperty("app_log_name", getApplicationName());

        SpringApplication.run(TemplateApplication.class, args);
    }

    /**
     * Determine the application name based on the environment variables set by PCF is available
     *
     * @return the application name
     */
    private static String getApplicationName() {
        String vcap = System.getenv("VCAP_APPLICATION");
        if (vcap == null) {
            return DEFAULT_APPLICATION_NAME;
        }

        Map<String, Object> vcapMap = JsonParserFactory.getJsonParser().parseMap(vcap);

        return (String) vcapMap.getOrDefault("application_name", DEFAULT_APPLICATION_NAME);
    }
}
