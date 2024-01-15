package com.synex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class AppConfig {
        
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();  // view resolver returns views (file names) with controller
        viewResolver.setPrefix("/WEB-INF/views/");  // directory of jsp file (views)
        viewResolver.setSuffix(".jsp");  // extension of jsp file
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }
    
}
