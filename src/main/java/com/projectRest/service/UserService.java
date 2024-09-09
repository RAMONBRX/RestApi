package com.projectRest.service;

import com.projectRest.model.User;
import jakarta.persistence.Id;

import java.util.List;

public interface UserService{
    List<User> findAll();
    User getUserById(Long id);
    User saveUser(User user);
    User updateUser(Long id,User user);
    User deleteUser(Long id);

}
