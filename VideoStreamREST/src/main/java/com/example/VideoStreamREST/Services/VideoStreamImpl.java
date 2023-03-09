package com.example.VideoStreamREST.Services;

import com.example.VideoStreamREST.Models.video;
import com.example.VideoStreamREST.Repositories.VideoStreamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoStreamImpl implements VideoStreamService {

    final
    VideoStreamRepository videoStreamRepository;

    public VideoStreamImpl(VideoStreamRepository videoStreamRepository) {
        this.videoStreamRepository = videoStreamRepository;
    }

    @Override
    public video getVideo(int id) {
        return videoStreamRepository.getById(id);
    }

    @Override
    public video saveVideo(video video) {
        return videoStreamRepository.save(video);
    }

    @Override
    public void deleteVideo(int id) {
        videoStreamRepository.deleteById(id);
    }

    @Override
    public List<video> getVideos() {
        return videoStreamRepository.findAll();
    }

    @Override
    public List<video> getVideosByUserID(int id) {
        return videoStreamRepository.findVideosByUserID(id);
    }
}
