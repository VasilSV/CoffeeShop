package com.example.coffeshop.repository;

import com.example.coffeshop.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUserName(String userName);

    Optional<User> findByUserNameAndPassword(String userName, String password);

}
