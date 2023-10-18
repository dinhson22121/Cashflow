package com.cashmm.cashflow.investments.repository;

import com.cashmm.cashflow.investments.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestmentRepository extends JpaRepository<Investment,Long> {
}
