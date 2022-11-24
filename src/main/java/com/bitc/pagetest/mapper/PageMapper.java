package com.bitc.pagetest.mapper;

import com.bitc.pagetest.dto.CustomersDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PageMapper {
    List<CustomersDto> selectCustomerList() throws Exception;
    
    Page<CustomersDto> selectCustomerListPage() throws Exception;
}
