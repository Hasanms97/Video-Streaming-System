package com.example.DTube.Services;

import com.example.DTube.Entities.user;
import com.example.DTube.Entities.video;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadVideoServiceImpl implements UploadVideoService {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    HttpSession session;

    @Override
    public void saveVideo(MultipartFile videoFile, video video) {
        user user = (com.example.DTube.Entities.user) session.getAttribute("account");
        String URL = ("http://uploadVideoREST:9091/RESTAPI/upload");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        video.setPath("");
        body.add("video", video);
        body.add("userId", user.getId());
        body.add("videoFile", videoFile.getResource());
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(body, headers);
        com.example.DTube.Entities.video v = restTemplate.postForObject(URL, request, com.example.DTube.Entities.video.class);
    }

    @Override
    public void deleteVideo(int id) {
        String URL = ("http://uploadVideoREST:9091/RESTAPI/delete/");
        Boolean ts = restTemplate.postForEntity(URL, id, Boolean.class).getBody();
    }
}
