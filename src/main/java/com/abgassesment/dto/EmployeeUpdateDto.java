package com.abgassesment.dto;

import com.abgassesment.model.Address;

public class EmployeeUpdateDto {

    private long mobileNumber;
    private Address address;
    
    public long getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    } 
    
    
}
