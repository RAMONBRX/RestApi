package com.projectRest.service.impl;

import com.projectRest.exception.BusinessException;
import com.projectRest.model.User;
import com.projectRest.repository.UserRepository;
import com.projectRest.exception.NotFoundException;
import com.projectRest.service.UserService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static java.util.Optional.ofNullable;

@Service
public class UserServiceImpl implements UserService {

    private static final Long UNCHANGEABLE_USER_ID = 1L;
    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Transactional(readOnly= true)
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new BusinessException("User not found with id: " + id));    }

    @Transactional
    public User saveUser(User userToCreate) {
        ofNullable(userToCreate).orElseThrow(() -> new BusinessException("User to create must not be null."));

        this.validateChangeableId(userToCreate.getId(), "created");
        if (userRepository.existsById(userToCreate.getId())) {
            throw new BusinessException("This user already exists.");
        }
        return this.userRepository.save(userToCreate);
    }

    @Transactional
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new BusinessException("User not Found"));
        user.setName(userDetails.getName());
        user.setAge(userDetails.getAge());
        user.setSurName(userDetails.getSurName());
        user.setOccupation(userDetails.getOccupation());
        return userRepository.save(user);
    }

    @Transactional
    public User deleteUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new BusinessException("User not found with id: " + id));

        userRepository.deleteById(id);
        return user;
    }

    private void validateChangeableId(Long id, String operation) {
        if (UNCHANGEABLE_USER_ID.equals(id)) {
            throw new BusinessException("User with ID %d can not be %s.".formatted(UNCHANGEABLE_USER_ID, operation));
        }
    }


    }



