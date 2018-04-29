package com.example.demo.interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: Bob Simon
 * @Description:配置首页
 * @Date: Created in 9:31 2018\4\29
 */
@Configuration
public class MyAdapter extends WebMvcConfigurerAdapter{

    /**
     * @param registry
     */
    @Override
    public void addViewControllers( ViewControllerRegistry registry ) {
        registry.addViewController("/").setViewName("forward:/login.shtml");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

}
