package com.bitc.pagetest.service;

import com.bitc.pagetest.dto.CustomersDto;
import com.github.pagehelper.Page;

import java.util.List;

public interface PageService {
    List<CustomersDto> selectCustomersList() throws Exception;
    
    Page<CustomersDto> selectCustomersList(int pageNo) throws Exception;
}
