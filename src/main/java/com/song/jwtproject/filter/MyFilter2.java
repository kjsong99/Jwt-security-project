package com.song.jwtproject.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter 2");
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
