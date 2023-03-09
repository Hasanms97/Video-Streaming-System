package com.example.DTube.Services;

import com.example.DTube.Entities.user;

public interface AuthenticationService {
    user checkUserCredentials(user user);
    user createUserCredentials(user user, String confirmPassword);
    void removeSession();
}
