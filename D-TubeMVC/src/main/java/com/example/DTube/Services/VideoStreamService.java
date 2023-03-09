package com.example.DTube.Services;

import com.example.DTube.Entities.video;

import java.util.List;

public interface VideoStreamService {
    List<video> getVideos();
    List<video> getVideosById();
}
