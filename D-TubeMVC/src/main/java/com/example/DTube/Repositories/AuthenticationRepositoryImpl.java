package com.example.DTube.Repositories;

import com.example.DTube.Entities.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AuthenticationRepositoryImpl implements AuthenticationRepository {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public user checkUserCredentials(user user) {
        Map<String, String> map = new HashMap<>();
        map.put("username", user.getUsername());
        map.put("password", user.getPassword());
        String url = ("http://AuthenticationREST:8080/sign-in-check");
        return restTemplate.postForEntity(url, map, com.example.DTube.Entities.user.class).getBody();
    }

    @Override
    public user createUserCredentials(user user, String confirmPassword) {
        String URL = ("http://AuthenticationREST:8080/create");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("user", user);
        body.add("confirmPassword", confirmPassword);
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(body, headers);
        return restTemplate.postForEntity(URL, request, com.example.DTube.Entities.user.class).getBody();
    }
}
