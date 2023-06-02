package com.song.jwtproject.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter3 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        System.out.println("Filter 3");


        String headerAuth = req.getHeader("Authorization");
        String method = req.getMethod();

        if (method.equals("POST")){
            System.out.println("POST 요청됨");

            if (headerAuth.equals("song")) {
                filterChain.doFilter(servletRequest, servletResponse);

            }else {
                PrintWriter out = res.getWriter();

                out.println("<h1>인증안됨<h1>");
            }
        }

    }
}
