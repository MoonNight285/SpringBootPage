package com.bitc.pagetest.controller;

import com.bitc.pagetest.dto.CustomersDto;
import com.bitc.pagetest.service.PageService;
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
        List<CustomersDto> customersList = pageService.selectCustomersList();
        mv.addObject("customersList", customersList);
        return mv;
    }
}
