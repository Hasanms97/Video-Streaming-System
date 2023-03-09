package com.example.FileStorage.Controllers;


import com.example.FileStorage.Services.FileStorageServiceImpl;
import com.google.cloud.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/storage")
public class FileStorageController {

    private final Storage storage;

    @Autowired
    public FileStorageController(Storage storage) {
        this.storage = storage;
    }

    @Autowired
    FileStorageServiceImpl fileStorageService;


    @PostMapping("/upload")
    public void uploadFile(@RequestPart("id") String id, @RequestPart("videoFile") MultipartFile videoFile) throws IOException {
        fileStorageService.saveVideo(id,videoFile);
    }

    @PostMapping("/delete")
    public void deleteVideo(@RequestBody String path) throws IOException {
        fileStorageService.deleteVideo(path);
    }


}
