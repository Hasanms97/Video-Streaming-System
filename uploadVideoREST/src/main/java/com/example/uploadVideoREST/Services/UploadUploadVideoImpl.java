package com.example.uploadVideoREST.Services;


import com.example.uploadVideoREST.Models.video;
import com.example.uploadVideoREST.Repositories.UploadVideoStreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class UploadUploadVideoImpl implements UploadVideoService {

    @Autowired
    UploadVideoStreamRepository uploadVideoStreamRepository;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public void uploadVideo(MultipartFile videoFile, video video, int id) {
        String uuid = UUID.randomUUID().toString();
        String URL = ("http://FileStorageREST:9999/storage/upload");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("id", uuid + ".mp4");
        body.add("videoFile", videoFile.getResource());
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(body, headers);
        video.setUserId(id);
        video.setPath(uuid);
        uploadVideoStreamRepository.save(video);
        com.example.uploadVideoREST.Models.video v = restTemplate.postForObject(URL, request, com.example.uploadVideoREST.Models.video.class);
    }

    @Override
    public void deleteVideo(int id) {
        String URL = ("http://FileStorageREST:9999/storage/delete");
        String videoPath = uploadVideoStreamRepository.getById(id).getPath();
        uploadVideoStreamRepository.deleteById(id);
        Boolean ts = restTemplate.postForEntity(URL, videoPath, Boolean.class).getBody();
    }
}
