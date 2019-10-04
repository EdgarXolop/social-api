package com.voider.socialapi.config;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Order(-110)
public class CORSFilter implements Filter{

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException
    {

        HttpServletRequest request = (HttpServletRequest) req;

        System.out.println(request.getRequestURL());
        System.out.println("AuthType " + request.getAuthType());
        System.out.println(request.getHeader("Authorization"));

        HttpServletResponse response = (HttpServletResponse) resp;

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers",
                "Origin, Content-Type, X-Requested-With, accept, Access-Control-Request-Method, Access-Control-Request-Headers, Authorization");
        response.setHeader("Access-Control-Expose-Headers",
                "Origin, Access-Control-Request-Method, Access-Control-Allow-Origin, Access-Control-Allow-Credentials, Authorization");
        response.setHeader("Access-Control-Max-Age", "4000");

        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
    }

    @Override
    public void destroy()
    {
    }
}