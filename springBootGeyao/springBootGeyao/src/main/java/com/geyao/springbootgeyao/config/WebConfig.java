package com.geyao.springbootgeyao.config;

import com.geyao.springbootgeyao.filter.GeyaoFilter;
import com.geyao.springbootgeyao.listener.GeyaoListener;
import com.geyao.springbootgeyao.servlet.GeyaoServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.sql.DataSource;

@Configuration
public class WebConfig implements ServletContextInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

    }
    @Bean
    public ServletRegistrationBean<GeyaoServlet> servletServletRegistrationBean(){
        ServletRegistrationBean<GeyaoServlet> registrationBean = new ServletRegistrationBean<>(new GeyaoServlet(), "/geyao1");
        return registrationBean;
    }
    @Bean
    public FilterRegistrationBean<GeyaoFilter> filterFilterRegistrationBean(){
        FilterRegistrationBean<GeyaoFilter> registrationBean = new FilterRegistrationBean<>(new GeyaoFilter());
        registrationBean.addUrlPatterns("/geyao");
        return registrationBean;
    }
    @Bean
    public ServletContextListener geyaoListener() {
        return new GeyaoListener();
    }

    @Bean
    public JdbcTemplate  jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
