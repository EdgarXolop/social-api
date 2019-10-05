package com.voider.socialapi.repository;

import com.voider.socialapi.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {

    @Query("FROM User WHERE email = :email")
    Optional<User> findByEmail(String email);

    @Query("FROM User WHERE user_name = :user_name")
    Optional<User> findByUserName(String user_name);

    @Modifying
    @Query("UPDATE User u SET u.first_name = :first_name, u.last_name = :last_name WHERE u.id_user = :id_user")
    int updateUser(@Param("id_user") Long id_user, @Param("first_name") String first_name, @Param("last_name") String last_name);
}
