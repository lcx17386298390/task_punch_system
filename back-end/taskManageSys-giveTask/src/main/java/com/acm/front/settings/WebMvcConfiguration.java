package com.acm.front.settings;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Package:com.bjpowernode.front.settings
 * Date:2022/3/7 11:47
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    /*处理跨域*/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("===========addCorsMappings===========");

        //addMapping 处理的请求地址， 拦截这些地址，使用跨域处理逻辑
        registry.addMapping("/**")
                .allowedOriginPatterns("*")  //可跨域的域名，可以为 *
                //支持跨域请求的，http方式
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                 //支持跨域的请求头， 在请求头包含哪些数据时，可以支持跨域功能
                .allowedHeaders("*");
    }

}
