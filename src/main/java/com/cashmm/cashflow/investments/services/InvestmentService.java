package com.cashmm.cashflow.investments.services;

import com.cashmm.cashflow.investments.Investment;
import com.cashmm.cashflow.investments.io.InvestmentRequest;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface InvestmentService {
    List<Investment> getAllInvestments();

    Investment getInvestmentById(Long investmentId) throws ChangeSetPersister.NotFoundException;

    Investment createInvestment(InvestmentRequest request);

    Investment updateInvestment(Long investmentId, InvestmentRequest request) throws ChangeSetPersister.NotFoundException;

    void deleteInvestment(Long investmentId) throws ChangeSetPersister.NotFoundException;

    Investment patchInvestment(Long investmentId, Map<String, Object> request)throws ChangeSetPersister.NotFoundException;
}
