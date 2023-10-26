package controller;

import com.Synchrony.model.UserRegistrationRequest;
import com.Synchrony.model.UserRegistrationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testUserRegistration() {
        // Create a request object for registration
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setUsername("testUser");
        request.setPassword("testPassword");

        // Send a POST request to the registration endpoint
        ResponseEntity<UserRegistrationResponse> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/users/register", request, UserRegistrationResponse.class);
        // Assertions to verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Registration successful", response.getBody().getMessage());
    }

    // Add more test methods for other controller endpoints
}

