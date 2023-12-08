package com.cashmm.cashflow.investments;

import com.cashmm.cashflow.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Investment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private BigDecimal investmentAmount;
    private Integer investmentDate;
    private String investmentType;
    private String currency;
    private Long userId;
    private Integer validFlag;
    private Timestamp createAt;

}
