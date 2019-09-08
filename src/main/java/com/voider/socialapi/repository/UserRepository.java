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
        extends JpaRepository<User, Integer> {

    @Query("FROM User WHERE email = :email")
    List<User> internalByEmail(String email, Pageable pageable);

    default User findByEmail(String email){
        return internalByEmail(
                email,
                PageRequest.of(0,1)
        ).get(0);
    }
}
