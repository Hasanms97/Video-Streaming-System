package com.example.VideoStreamREST.Controllers;

import com.example.VideoStreamREST.Models.video;
import com.example.VideoStreamREST.Services.VideoStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RESTAPI")
public class VideoStreamController {
    @Autowired
    VideoStreamService videoStreamService;

    @GetMapping("/videos")
    public List<video> getVideos() {
        return videoStreamService.getVideos();
    }

    @PostMapping("/getVideosByID")
    public List<video> getVideosByUserID(@RequestBody int id) {
        return videoStreamService.getVideosByUserID(id);
    }
}
