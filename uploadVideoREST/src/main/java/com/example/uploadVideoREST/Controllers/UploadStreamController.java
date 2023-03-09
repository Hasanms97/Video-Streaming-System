package com.example.uploadVideoREST.Controllers;

import com.example.uploadVideoREST.Models.video;
import com.example.uploadVideoREST.Services.UploadVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/RESTAPI")
public class UploadStreamController {

    @Autowired
    UploadVideoService uploadVideoService;


    @PostMapping("/upload")
    public void uploadVideo(@RequestPart("video") video video, @RequestPart("userId") int userId, @RequestPart("videoFile") MultipartFile videoFile) {
        uploadVideoService.uploadVideo(videoFile, video, userId);
    }

    @PostMapping("/delete/")
    public void deleteVideo(@RequestBody int id) {
        uploadVideoService.deleteVideo(id);
    }


}
