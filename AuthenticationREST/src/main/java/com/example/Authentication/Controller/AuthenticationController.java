package com.example.Authentication.Controller;

import com.example.Authentication.entity.user;
import com.example.Authentication.service.UserService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class AuthenticationController {
    @Autowired
    UserService services;

    @PostMapping("/sign-in-check")
    public user checkAccountCredentials(@RequestBody ObjectNode nodes)
    {
        return services.checkUserCredentials(nodes.get("username").asText(),nodes.get("password").asText());
    }

    @PostMapping("/create")
    public user createUserCredentials(@RequestPart("user") user user, @RequestPart("confirmPassword") String confirmPassword)
    {
        return services.createUserCredentials(user,confirmPassword);
    }
}
