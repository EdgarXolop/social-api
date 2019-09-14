package com.voider.socialapi.repository;

import com.voider.socialapi.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {

    @Query("FROM User WHERE email = :email")
    Optional<User> findByEmail(String email);

    @Query("FROM User WHERE user_name = :user_name")
    Optional<User> findByUserName(String user_name);

}
