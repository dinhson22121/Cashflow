package com.cashmm.cashflow.investments.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Builder
@Data
public class InvestmentRequest {
    private String name;
    private BigDecimal investmentAmount;
    private Integer investmentDate;
    private String investmentType;
    private String currency;
    private Long userID;

}
