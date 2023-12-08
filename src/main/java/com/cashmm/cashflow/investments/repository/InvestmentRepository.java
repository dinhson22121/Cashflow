package com.cashmm.cashflow.investments.repository;

import com.cashmm.cashflow.investments.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface InvestmentRepository extends JpaRepository<Investment, Long> {
    Optional<Investment> findByid(Long userId);
}
