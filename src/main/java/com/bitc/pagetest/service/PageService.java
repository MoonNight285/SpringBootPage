package com.bitc.pagetest.service;

import com.bitc.pagetest.dto.CustomersDto;

import java.util.List;

public interface PageService {
    List<CustomersDto> selectCustomersList() throws Exception;
}
