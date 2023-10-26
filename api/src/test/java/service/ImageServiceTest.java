package service;

import com.Synchrony.service.ImageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ImageServiceTest {
    private ImageService imageService;

 /*   @Mock
    private ImgurClient imgurClient;*/

    @BeforeEach
    public void setUp() {
       // imageService = new ImageService(imgurClient);
    }

    @Test
    public void testUploadImage() {
        // Create a mock image file
        MockMultipartFile mockFile = new MockMultipartFile("imageFile", "image.jpg", "image/jpeg", "image content".getBytes());

        // Mock the behavior of the ImgurClient's upload method
       // when(imgurClient.uploadImage(any(MockMultipartFile.class))).thenReturn("imgurId123");

        // Call the service method
        //String imgurId = imageService.uploadImage(mockFile);

        // Verify the result
        //assertThat(imgurId).isEqualTo("imgurId123");
    }

    @Test
    public void testViewImage() {
        // Mock the behavior of the ImgurClient's view method
        //when(imgurClient.viewImage("imgurId123")).thenReturn("image content");

        // Call the service method
        String imageData = imageService.viewImage("imgurId123");

        // Verify the result
        assertThat(imageData).isEqualTo("image content");
    }
}

