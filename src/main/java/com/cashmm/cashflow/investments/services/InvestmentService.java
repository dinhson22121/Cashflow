package com.cashmm.cashflow.investments.services;

import com.cashmm.cashflow.investments.Investment;
import com.cashmm.cashflow.investments.io.InvestmentRequest;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvestmentService {
    List<Investment> getAllInvestments();

    Investment getInvestmentById(Long investmentId) throws ChangeSetPersister.NotFoundException;

    Investment createInvestment(InvestmentRequest request);

    Investment updateInvestment(Long investmentId, InvestmentRequest request) throws ChangeSetPersister.NotFoundException;

    void deleteInvestment(Long investmentId) throws ChangeSetPersister.NotFoundException;
}
