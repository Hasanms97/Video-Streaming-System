package com.example.uploadVideoREST.Services;


import com.example.uploadVideoREST.Models.video;
import org.springframework.web.multipart.MultipartFile;

public interface UploadVideoService {
    void uploadVideo(MultipartFile videoFile, video video, int user_id);

    void deleteVideo(int id);
}