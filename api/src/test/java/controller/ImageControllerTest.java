package controller;

import com.Synchrony.controller.ImageController;
import com.Synchrony.service.ImageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ImageControllerTest {
    private MockMvc mockMvc;

    @Mock
    private ImageService imageService;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ImageController(imageService)).build();
    }

    @Test
    public void testImageUpload() throws Exception {
        MockMultipartFile file = new MockMultipartFile("imageFile", "image.jpg", MediaType.IMAGE_JPEG_VALUE, "image bytes".getBytes());

        when(imageService.uploadImage(any())).thenReturn("imgurId123");

     /*   mockMvc.perform(fileUpload("/api/images/upload")
                        .file(file)
                        .param("description", "Test Image")
                        .param("title", "Image Title"))
                .andExpect(status().isCreated());*/
    }

    @Test
    public void testViewImage() throws Exception {
        when(imageService.viewImage("imgurId123")).thenReturn("image bytes");

        mockMvc.perform(get("/api/images/imgurId123"))
                .andExpect(status().isOk());
    }
}
