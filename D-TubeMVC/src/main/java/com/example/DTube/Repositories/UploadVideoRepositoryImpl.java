package com.example.DTube.Repositories;

import com.example.DTube.Entities.video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class UploadVideoRepositoryImpl implements UploadVideoRepository{

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void saveVideo(video video, MultipartFile videoFile, int id) {

    }

    @Override
    public void deleteVideo(int id) {

    }
}
