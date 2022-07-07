package com.josh.practice.filterAndInterceptor;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 過濾器，此處預設所有路徑都要處理
 */
@WebFilter(urlPatterns = "/*")
@Order(1) // 如有多個filter, order的值越小，啟動順序越靠前
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("=====Filter init=====");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("=====doFilter before=====");
        chain.doFilter(request, response);
        System.out.println("=====doFilter after=====");
    }

    @Override
    public void destroy() {
        System.out.println("=====Filter destroy=====");;
    }
}
