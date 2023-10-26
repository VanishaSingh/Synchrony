package com.Synchrony.service;

import com.Synchrony.exception.ImgurApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.Base64;


@Service
public class ImageServiceImpl implements ImageService {

    @Value("${imgur.clientId}")
    private String clientId;

    @Value("${imgur.apiEndpoint}")
    private String imgurApiEndpoint;


    // You may need to define additional constants or properties for Imgur API endpoints

    private final RestTemplate restTemplate;

    public ImageServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String uploadImage(byte[] imageData) throws ImgurApiException {
        // Implement image upload logic to Imgur using the provided data and API
        // Make an HTTP POST request to the Imgur API endpoint for image upload
        // Return the Imgur image ID or URL
        // Handle exceptions and errors appropriately
        // You may want to use the clientId for authorization

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "Client-ID " + clientId);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("image", Base64.getEncoder().encodeToString(imageData));

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                imgurApiEndpoint + "/upload", HttpMethod.POST, requestEntity, String.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            // Parse the response to extract the image ID or URL
            String response = responseEntity.getBody();
            // Implement logic to extract the image ID or URL from the response
            return response;
        } else {
            // Handle errors appropriately
            throw new ImgurApiException("Image upload failed: " + responseEntity.getStatusCode());
        }

        // return null;
    }

    public String viewImage(String imgurId) throws ImgurApiException {
        // Implement logic to view an image by its Imgur ID
        // Make an HTTP GET request to the Imgur API endpoint for viewing images
        // Return the image data or URL
        // Handle exceptions and errors appropriately
        // Construct the URL for viewing an image
        String url = imgurApiEndpoint + "/image/" + imgurId;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            // Parse the response to get image data or URL
            String imageData = responseEntity.getBody();
            // Implement logic to extract image data or URL from the response
            return imageData;
        } else {
            // Handle errors appropriately
            throw new ImgurApiException("Image retrieval failed: " + responseEntity.getStatusCode());
            //return null;
        }

    }

    @Override
    public void deleteImage(String imgurId) throws ImgurApiException {
        // Construct the URL for deleting an image
        String url = imgurApiEndpoint + "/image/" + imgurId;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Client-ID " + clientId);

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url, HttpMethod.DELETE, requestEntity, String.class);

        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            // Handle errors appropriately
            throw new ImgurApiException("Image deletion failed: " + responseEntity.getStatusCode());
        }
    }

    }


