package com.juan.springboot.config;

import com.juan.springboot.component.LoginHandlerInterceptor;
import com.juan.springboot.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    //所有的webMvcConfigurerAdapter组件会一起起作用
    @Bean //註冊到容器去
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {

                registry.addViewController( "/" ).setViewName( "forward:/login.html" );  //设置默认主页
                registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
                super.addViewControllers( registry );
            }
//            注册拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
////                静态资源 css js 已经做好了静态资源映射
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
//                        excludePathPatterns("/login.html","/","/druid");
//            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
}
