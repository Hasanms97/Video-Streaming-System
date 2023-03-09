package com.example.DTube.Services;

import com.example.DTube.Entities.user;
import com.example.DTube.Repositories.AuthenticationRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    AuthenticationRepository authenticationRepository;
    @Autowired
    HttpSession session;

    @Override
    public user checkUserCredentials(user user) {
        return authenticationRepository.checkUserCredentials(user);
    }

    @Override
    public user createUserCredentials(user user, String confirmPassword) {
        return authenticationRepository.createUserCredentials(user,confirmPassword);
    }

    @Override
    public void removeSession() {
        session.removeAttribute("account");
    }
}
