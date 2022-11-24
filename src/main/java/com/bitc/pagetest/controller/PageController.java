package com.bitc.pagetest.controller;

import com.bitc.pagetest.dto.CustomersDto;
import com.bitc.pagetest.service.PageService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    private PageService pageService;
    
    @RequestMapping("/")
    public String index() throws Exception {
        return "index";
    }
    
    @RequestMapping("/page")
    public ModelAndView page(@RequestParam(required = false, defaultValue = "1") int pageNum) throws Exception {
        ModelAndView mv = new ModelAndView("/page");
        // List<CustomersDto> customersList = pageService.selectCustomersList();
        // mv.addObject("customersList", customersList);
        
        // 첫번쨰 매개변수로 Service를 이용하여 데이터를 가져오기 위한 메서드를 지정
        // 두번째 매개변수로 이동을 하기 위한 페이지 번호 개수를 설정
        PageInfo<CustomersDto> customersList = new PageInfo<>(pageService.selectCustomersList(pageNum), 10);
        mv.addObject("customersList", customersList);
        return mv;
    }
}
