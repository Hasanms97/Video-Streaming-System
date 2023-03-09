package com.example.DTube.Controllers;

import com.example.DTube.Services.VideoStreamService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/video-stream")
public class VideoStreamController {

    @Autowired
    VideoStreamService videoStreamService;
    @Autowired
    HttpSession session;

    @GetMapping("/stream")
    public String getVideoStreams(Model model, HttpSession session)
    {
        model.addAttribute("videos",videoStreamService.getVideos());
        return "videoStream";
    }
    @GetMapping("/my_videos")
    public String getMyVideos(Model model)
    {
        model.addAttribute("videos",videoStreamService.getVideosById());
        return "myVideos";
    }

}
