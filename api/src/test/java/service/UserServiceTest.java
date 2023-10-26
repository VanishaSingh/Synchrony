package service;

import com.Synchrony.entity.User;
import com.Synchrony.repository.UserRepository;
import com.Synchrony.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterUser() {
        // Create a User object for testing
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");

        // Define the behavior of the userRepository when saving the user
        when(userRepository.save(user)).thenReturn(user);

        // Call the service method
        //User registeredUser = userService.registerUser(user);

        // Assert that the registered user is returned as expected
        //assertEquals(user.getUsername(), registeredUser.getUsername());
    }
}

