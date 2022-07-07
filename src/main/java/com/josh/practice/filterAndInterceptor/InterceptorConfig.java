package com.josh.practice.filterAndInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 註冊攔截器
 * 後續可再將需要排除的url加入exclusionUrlList裡
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private TestInterceptor testInterceptor;

    // 不攔截的清單
    private static List<String> exclusionUrlList = new ArrayList<>();

    // 新增排除url
    /*static {
        exclusionUrlList.add("/");
        exclusionUrlList.add("/index");
    }*/

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(exclusionUrlList);
    }
}
