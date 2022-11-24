package com.bitc.pagetest.service;

import com.bitc.pagetest.dto.CustomersDto;
import com.bitc.pagetest.mapper.PageMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    
    @Override
    public Page<CustomersDto> selectCustomersList(int pageNo) throws Exception {
        // PageHelper => mybatis에서 페이징 기법을 쉽게 사용할 수 있도록 도와주는 라이브러리
        // PageInfo : ArrayList와 비슷한 형태의 클래스, 해당 클래스 타입의 변수에 객체에 실제 DB에서 받아온 데이터를 저장하고 View로
        // 전송한다.
        // PageInfo 클래스는 페이징을 쉽게 하기 위한 몇가지 맴버를 제공하고 있다.
        // int pageNum : 현재 페이지
        // int pageSize : 페이지당 수량
        // int size : 페이지 수
        // long startRow : 현재 페이지에서 첫번째 요소가 데이터베이스에 있는 줄 번호
        // long endRow : 현재 페이지에서 마지막 요소가 데이터베이스에 있는 줄 번호
        // int pages : 전체 페이지 수
        // int prePage : 이전 페이지 번호
        // int nextPage : 다음 페이지 번호
        // boolean isFirstPage : 첫번째 페이지 존재 여부
        // boolean isLastPage : 마지막 페이지 존재 여부
        // boolean hasPreviousPage : 이전 페이지 존재 여부
        // boolean hasNextPage : 다음 페이지 존재 여부
        // int navigatePages : 네비게이션 페이지 번호
        // int[] navigatePageNums : 모든 네비게이션 페이지 번호
        // int navigateFirstPage : 네비게이션 바의 첫번째 페이지
        // int navigateLastPage : 네비게이션 바의 마지막 페이지
        
        // List<t> list() : 실제 데이터 리스트가 들어있는 ArrayList
        
        // startPate => 첫번째 매개변수로 화면에 출력할 페이지, 두번째 매개변수로 화면에 출력할 컨텐츠의 수 설정
        PageHelper.startPage(pageNo, 5);
        return pageMapper.selectCustomerListPage();
    }
}
