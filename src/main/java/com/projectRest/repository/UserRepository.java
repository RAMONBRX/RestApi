package com.projectRest.repository;

import com.projectRest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean  existsById(int id);
}
