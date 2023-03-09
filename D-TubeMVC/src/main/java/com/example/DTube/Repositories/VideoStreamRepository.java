package com.example.DTube.Repositories;

import com.example.DTube.Entities.video;

import java.util.List;

public interface VideoStreamRepository {
    List<video> getVideos();
    List<video> getVideosByUserID();

}
