package com.example.EmployeeInfoMgt.Service;

import com.example.EmployeeInfoMgt.Entity.Address;
import com.example.EmployeeInfoMgt.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address save(Address address){
        return addressRepository.save(address);
    }
}
