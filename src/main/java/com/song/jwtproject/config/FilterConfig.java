package com.song.jwtproject.config;

import com.song.jwtproject.filter.MyFilter1;
import com.song.jwtproject.filter.MyFilter2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration 필터 해제를 위해서 주석 처리
public class FilterConfig {

    public FilterRegistrationBean<MyFilter1> filter1(){
        FilterRegistrationBean<MyFilter1> bean = new FilterRegistrationBean<MyFilter1>(new MyFilter1());
        bean.addUrlPatterns("/*");
        bean.setOrder(0);
        return bean;
    }


    public FilterRegistrationBean<MyFilter2> filter2(){
        FilterRegistrationBean<MyFilter2> bean = new FilterRegistrationBean<MyFilter2>(new MyFilter2());
        bean.addUrlPatterns("/*");
        bean.setOrder(1);
        return bean;
    }

}
