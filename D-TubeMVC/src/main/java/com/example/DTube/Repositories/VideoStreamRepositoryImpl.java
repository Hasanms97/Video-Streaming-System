package com.example.DTube.Repositories;

import com.example.DTube.Entities.user;
import com.example.DTube.Entities.video;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class VideoStreamRepositoryImpl implements VideoStreamRepository {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    HttpSession session;

    @Override
    public List<video> getVideos() {

        List<video> result = restTemplate.exchange(
                "http://VideoStreamREST:9090/RESTAPI/videos",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<video>>() {
                }
        ).getBody();
        return result;
    }

    @Override
    public List<video> getVideosByUserID() {
        user user = (com.example.DTube.Entities.user) session.getAttribute("account");
        String url = ("http://VideoStreamREST:9090/RESTAPI/getVideosByID");
        return restTemplate.postForEntity(url, user.getId(), List.class).getBody();
    }
}
