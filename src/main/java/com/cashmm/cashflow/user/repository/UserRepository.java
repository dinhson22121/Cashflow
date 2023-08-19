package com.cashmm.cashflow.user.repository;

import com.cashmm.cashflow.user.User;
import com.cashmm.cashflow.user.io.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String   email);
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User loadUserInfo(String   email);

    @Modifying
    @Query("Update User u SET u.password = :newPassword WHERE u.email = :email")
    void changePassword(@Param("password") String newPassword,@Param("email") String email);
}
