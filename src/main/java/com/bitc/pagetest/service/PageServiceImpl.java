package com.bitc.pagetest.service;

import com.bitc.pagetest.dto.CustomersDto;
import com.bitc.pagetest.mapper.PageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService {
    @Autowired
    private PageMapper pageMapper;
    
    @Override
    public List<CustomersDto> selectCustomersList() throws Exception {
        return pageMapper.selectCustomerList();
    }
}
