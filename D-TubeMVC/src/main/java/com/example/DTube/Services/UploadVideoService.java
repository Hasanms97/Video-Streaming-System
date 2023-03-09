package com.example.DTube.Services;

import com.example.DTube.Entities.video;
import org.springframework.web.multipart.MultipartFile;

public interface UploadVideoService {
    void saveVideo(MultipartFile videoFile, video video);
    void deleteVideo(int id);
}
