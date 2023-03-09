package com.example.DTube.Repositories;

import com.example.DTube.Entities.video;
import org.springframework.web.multipart.MultipartFile;

public interface UploadVideoRepository {
    void saveVideo(video video, MultipartFile videoFile, int id);
    void deleteVideo(int id);
}