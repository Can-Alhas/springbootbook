package com.canalhas.project.springbootbook.repository;

import com.canalhas.project.springbootbook.model.Role;
import com.canalhas.project.springbootbook.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {


    Optional<User> findByEmail(String email);

    User findByRole(Role role);

    Optional<User> findByUsername(String username);
}
