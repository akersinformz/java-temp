package com.nbc.template.test.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.nbc.template.TemplateApplication;

/**
 * Tests for the Template Controller Interface
 *
 * @author Bob Strubel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TemplateApplication.class)
@ActiveProfiles("test")
@WebIntegrationTest(randomPort = true)
public class TemplateControllerTests {

    /**
     * Test RestTemplate to simplify REST calls
     */
    private final RestTemplate template = new TestRestTemplate();

    /**
     * The random port number the test server is running on
     */
    @Value("${local.server.port}")
    private int port;

    /**
     * The base url for the rest interface
     *
     * @return {@code String} containing the base url of the test server
     */
    private String getBaseUrl() {
        return "http://localhost:" + port;
    }

}
