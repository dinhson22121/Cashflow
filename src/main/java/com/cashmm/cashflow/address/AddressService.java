package com.cashmm.cashflow.address;

import com.cashmm.cashflow.user.User;

import java.util.List;

public interface AddressService {
    List<Address> searchAddressByUser(User user);
    Address searchAddressByPriorities();
}
