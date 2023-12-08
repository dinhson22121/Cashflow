package com.cashmm.cashflow.address.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {
    private Long userId;
    private Integer apartmentNumber;
    private String city;
    private String state;
    private String postalCode;
    private String street;
}
