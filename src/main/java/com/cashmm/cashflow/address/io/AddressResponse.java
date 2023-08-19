package com.cashmm.cashflow.address.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {
    private Integer apartmentNumber;
    private String city;
    private String state;
    private String postalCode;
    private String street;
    private Integer validFlag;
    private Integer priorities;
    private Timestamp createAt;
}
