package com.bitc.pagetest.dto;

import lombok.Data;

@Data
public class CustomersDto {
    private int customerId;
    private int storeId;
    private String firstName;
    private String lastName;
    private String email;
    private int addressId;
    private int active;
    private String createDate;
    private String lastUpdate;
}
