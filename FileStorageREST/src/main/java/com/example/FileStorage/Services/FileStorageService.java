package com.example.FileStorage.Services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileStorageService {
    void saveVideo(String id, MultipartFile videoFile) throws IOException;
    void deleteVideo(String path);
}
