package com.cashmm.cashflow.user.repository;

import com.cashmm.cashflow.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String   email);
    boolean existsByEmail(String email);
}
