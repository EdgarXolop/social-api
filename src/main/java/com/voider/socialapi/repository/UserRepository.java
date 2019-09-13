package com.voider.socialapi.repository;

import com.voider.socialapi.model.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {

    @Query("FROM User WHERE email = :email")
    List<User> internalByEmail(String email, Pageable pageable);

    default User findByEmail(String email){
        return internalByEmail(
                email,
                PageRequest.of(0,1)
        ).get(0);
    }

    @Query("FROM User WHERE user_name = :user_name")
    List<User> internalByUserName(String user_name, Pageable pageable);

    default User findByUserName(String user_name){
        return internalByUserName(
                user_name,
                PageRequest.of(0,1)
        ).get(0);
    }
}
