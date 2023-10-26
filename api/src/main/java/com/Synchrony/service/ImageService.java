package com.Synchrony.service;

import com.Synchrony.exception.ImgurApiException;

public interface ImageService {
    public String uploadImage(byte[] imageData) throws ImgurApiException;
    public String viewImage(String imgurId) throws ImgurApiException;
    public void deleteImage(String imgurId) throws ImgurApiException;
}
