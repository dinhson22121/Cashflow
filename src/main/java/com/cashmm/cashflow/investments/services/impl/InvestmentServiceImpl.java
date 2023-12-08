package com.cashmm.cashflow.investments.services.impl;

import com.cashmm.cashflow.investments.Investment;
import com.cashmm.cashflow.investments.io.InvestmentRequest;
import com.cashmm.cashflow.investments.repository.InvestmentRepository;
import com.cashmm.cashflow.investments.services.InvestmentService;
import com.cashmm.cashflow.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class InvestmentServiceImpl implements InvestmentService {

    private final InvestmentRepository investmentRepository;

    @Autowired
    public InvestmentServiceImpl(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    @Override
    public List<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }

    @Override
    public Investment getInvestmentById(Long investmentId) throws ChangeSetPersister.NotFoundException {
        return investmentRepository.findById(investmentId)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    @Override
    public Investment createInvestment(InvestmentRequest request) {
        Investment investment = new Investment();
        investment.setName(request.getName());
        investment.setInvestmentAmount(request.getInvestmentAmount());
        investment.setInvestmentDate(request.getInvestmentDate());
        investment.setInvestmentType(request.getInvestmentType());
        investment.setUserId(request.getUserID());
        investment.setCurrency(request.getCurrency());
        investment.setValidFlag(1); // Giả sử mặc định là đầu tư hợp lệ khi tạo mới
        investment.setCreateAt(new Timestamp(System.currentTimeMillis()));
        return investmentRepository.save(investment);
    }

    @Override
    public Investment updateInvestment(Long investmentId, InvestmentRequest request) throws ChangeSetPersister.NotFoundException {
        Investment existingInvestment = getInvestmentById(investmentId);
        existingInvestment.setName(request.getName());
        existingInvestment.setInvestmentAmount(request.getInvestmentAmount());
        existingInvestment.setInvestmentDate(request.getInvestmentDate());
        existingInvestment.setInvestmentType(request.getInvestmentType());
        existingInvestment.setCurrency(request.getCurrency());
        existingInvestment.setUserId(request.getUserID());

        return investmentRepository.save(existingInvestment);
    }

    @Override
    public void deleteInvestment(Long investmentId) throws ChangeSetPersister.NotFoundException {
        Investment existingInvestment = getInvestmentById(investmentId);
        investmentRepository.delete(existingInvestment);
    }
}
