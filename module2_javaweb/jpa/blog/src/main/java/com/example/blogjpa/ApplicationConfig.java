package com.example.blogjpa;

import com.example.blogjpa.formatter.CategoryFormatter;
import com.example.blogjpa.services.CategoryService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration
//public class ApplicationConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
////    private ApplicationContext applicationContext;
////    @Override
////    public void addFormatters(FormatterRegistry registry) {
////        registry.addFormatter(new CategoryFormatter(applicationContext.getBean(CategoryService.class)));
////    }
////    @Override
////    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
////        this.applicationContext = applicationContext;
////    }
//}
