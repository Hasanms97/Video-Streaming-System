package com.example.Authentication.service;

import com.example.Authentication.entity.user;

public interface UserService {
    user saveUser(user user);
    user checkUserCredentials(String username, String password);
    user createUserCredentials(user user, String confirmPassword);
    
}
