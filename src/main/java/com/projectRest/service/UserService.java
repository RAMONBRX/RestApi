package com.projectRest.service;

import com.projectRest.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findById(int id);

    User createUser(User userToCreate);
}
