package com.cashmm.cashflow.address;

import com.cashmm.cashflow.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer apartmentNumber;
    private String city;
    private String state;
    private String postalCode;
    private String street;
    private Integer validFlag;
    private Integer priorities;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Timestamp createAt;
}
