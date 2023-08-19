package com.cashmm.cashflow.address;

import com.cashmm.cashflow.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer ApartmentNumber;
    private String city;
    private String state;
    private String postalCode;
    private String street;
    private Integer validFlag;
    private Integer priorities;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "addresses")
    private List<User> users;
    private Timestamp createAt;
}
