package com.jack.api_user.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jack.api_user.infrastructure.entities.User;
import com.jack.api_user.infrastructure.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        Optional<User> userExist = userRepository.findById(user.getId());

        if (userExist.isPresent()) {
            return userRepository.save(user);
        }

        throw new IllegalArgumentException("User not found");
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
