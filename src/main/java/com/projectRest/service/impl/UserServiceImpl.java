package com.projectRest.service.impl;

import com.projectRest.model.User;
import com.projectRest.repository.UserRepository;
import com.projectRest.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.ofNullable(userRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @Override
    public User createUser(User userToCreate) {
        if (userRepository.existsById(userToCreate.getId())){
            throw new IllegalArgumentException("This User ID already exists.");
        }else {
            return userRepository.save(userToCreate);
        }
    }
}
