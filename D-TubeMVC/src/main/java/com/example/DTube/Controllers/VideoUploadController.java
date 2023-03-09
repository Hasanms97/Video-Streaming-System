package com.example.DTube.Controllers;

import com.example.DTube.Entities.video;
import com.example.DTube.Services.UploadVideoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/video-upload")
public class VideoUploadController {

    @Autowired
    UploadVideoService uploadVideoService;
    @Autowired
    HttpSession session;

    @GetMapping("/upload")
    public String getUploadVideo(Model model)
    {
        model.addAttribute("video",new video());
        return "uploadVideo";
    }

    @PostMapping("/upload-video")
    public String uploadVideoHandler(@RequestParam MultipartFile multipartFile, @ModelAttribute video video)
    {
        uploadVideoService.saveVideo(multipartFile, video);
        return "redirect:/auth/home";
    }
    @PostMapping("/delete-video")
    public String uploadVideoHandler(@RequestParam(name = "newMessages") int id)
    {
        uploadVideoService.deleteVideo(id);
        return "redirect:/video-stream/my_videos";
    }
}
