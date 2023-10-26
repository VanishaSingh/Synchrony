package com.Synchrony.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ImageUploadRequest {
    private MultipartFile imageFile;

    // Getter and setter
}

