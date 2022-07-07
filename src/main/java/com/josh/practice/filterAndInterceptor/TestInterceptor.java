package com.josh.practice.filterAndInterceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 攔截器邏輯
 * 簡單計算request打進來到方法結束的時間
 */
@Component
public class TestInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(TestInterceptor.class);
    private long startTime;
    private long endTime;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("=====Interceptor preHandle=====");
         startTime = System.currentTimeMillis();
        boolean someExpressionsResult = true;
//        someExpressionResult = false;
        return someExpressionsResult;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("=====Interceptor postHandle=====");
        endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        logger.info("duration: " + duration + " millis");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("=====Interceptor afterCompletion=====");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
