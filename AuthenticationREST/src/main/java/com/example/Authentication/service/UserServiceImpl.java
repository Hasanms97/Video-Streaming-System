package com.example.Authentication.service;

import com.example.Authentication.entity.user;
import com.example.Authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public user saveUser(user user) {
        return userRepository.save(user);
    }

    @Override
    public user checkUserCredentials(String username, String password) {
        user user = findUsersByUsername(username);
        if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public user createUserCredentials(user user, String confirmPassword) {
        if (findUsersByUsername(user.getUsername()) == null) {
            if (user.getPassword().equals(confirmPassword)) {
                userRepository.save(user);
                return user;
            }
        }
        return null;
    }

    public user findUsersByUsername(String username) {
        return userRepository.findUsersByUsername(username);
    }

}
