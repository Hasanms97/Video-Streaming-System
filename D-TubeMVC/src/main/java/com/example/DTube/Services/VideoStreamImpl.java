package com.example.DTube.Services;

import com.example.DTube.Entities.video;
import com.example.DTube.Repositories.VideoStreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoStreamImpl implements VideoStreamService {

    @Autowired
    VideoStreamRepository videoStreamRepository;

    @Override
    public List<video> getVideos() {
        return videoStreamRepository.getVideos();
    }

    @Override
    public List<video> getVideosById() {
        return videoStreamRepository.getVideosByUserID();
    }
}
