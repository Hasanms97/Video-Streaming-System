package com.example.DTube.Repositories;

import com.example.DTube.Entities.user;

public interface AuthenticationRepository {
    user checkUserCredentials(user user);
    user createUserCredentials(user user, String confirmPassword);
}
