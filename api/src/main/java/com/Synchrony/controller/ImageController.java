package com.Synchrony.controller;

import com.Synchrony.exception.ImgurApiException;
import com.Synchrony.service.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
@Api(tags = "Image API")
public class ImageController {
    private final ImageService imageService;

    @Autowired
    public ImageController( ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    @ApiOperation("Upload an image to Imgur")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException, ImgurApiException {
        // Implement logic to upload the image to Imgur and return the Imgur image ID or URL
        // You may need to convert the MultipartFile to a byte array before passing it to the service
        return imageService.uploadImage(file.getBytes());
    }

    @GetMapping("/view/{imgurId}")
    @ApiOperation("View an image by Imgur ID")
    public String viewImage(@PathVariable String imgurId) throws ImgurApiException {
        // Implement logic to view an image by its Imgur ID
        return imageService.viewImage(imgurId);
    }

    @DeleteMapping("/delete/{imgurId}")
    @ApiOperation("Delete an image by Imgur ID")
    public void deleteImage(@PathVariable String imgurId) throws ImgurApiException {
        // Implement logic to delete an image by its Imgur ID
        imageService.deleteImage(imgurId);
    }
}
