package com.example.VideoStreamREST.Services;

import com.example.VideoStreamREST.Models.video;

import java.util.List;

public interface VideoStreamService {
    video getVideo(int id);
    video saveVideo(video video);
    void deleteVideo(int id);
    List<video> getVideos();
    List<video> getVideosByUserID(int id);
}
