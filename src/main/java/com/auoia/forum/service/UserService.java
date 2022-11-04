package com.auoia.forum.service;

import com.auoia.forum.model.User;
import com.auoia.forum.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String username, String password) {
        Optional<User> user = userRepository.findUserByUsername(username);

        if (user.isEmpty()) {
            User newUser = new User(username, password);
            userRepository.save(newUser);
        }
    }
}
