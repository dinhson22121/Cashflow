package com.cashmm.cashflow.investments.controller;


import com.cashmm.cashflow.investments.Investment;
import com.cashmm.cashflow.investments.io.InvestmentRequest;
import com.cashmm.cashflow.investments.services.InvestmentService;

import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.RequiredArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class InvestmentController {

    private final InvestmentService investmentService;

    @GetMapping("/investments")
    public ResponseEntity<List<Investment>> getAllInvestments() {
        List<Investment> investments = investmentService.getAllInvestments();
        return new ResponseEntity<>(investments, HttpStatus.OK);
    }

    @GetMapping("/investments/{investmentId}")
    public ResponseEntity<Investment> getInvestmentById(@PathVariable Long investmentId) throws ChangeSetPersister.NotFoundException {
        Investment investment = investmentService.getInvestmentById(investmentId);
        return new ResponseEntity<>(investment, HttpStatus.OK);
    }

    @PostMapping("/investments")
    public ResponseEntity<Investment> createInvestment(@RequestBody InvestmentRequest request) {
        Investment newInvestment = investmentService.createInvestment(request);
        return new ResponseEntity<>(newInvestment, HttpStatus.CREATED);
    }

    @PutMapping("/investments/{investmentId}")
    public ResponseEntity<Investment> updateInvestment(
            @PathVariable Long investmentId,
            @RequestBody InvestmentRequest request) throws ChangeSetPersister.NotFoundException {
        Investment updatedInvestment = investmentService.updateInvestment(investmentId, request);
        return new ResponseEntity<>(updatedInvestment, HttpStatus.OK);
    }

    @DeleteMapping("/investments/{investmentId}")
    public ResponseEntity<Void> deleteInvestment(@PathVariable Long investmentId) throws ChangeSetPersister.NotFoundException {
        investmentService.deleteInvestment(investmentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping("/investments/{investmentId}")
    public ResponseEntity<?> patchInvestment(@PathVariable Long investmentId, @RequestBody Map<String, Object> request){
        try {
            Investment updatedInvestment = investmentService.patchInvestment(investmentId, request);
            return ResponseEntity.ok(updatedInvestment);
        } catch (ChangeSetPersister.NotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating investment.");
        }
    }

}
