package top.zwzx.supermarket_001.config;


import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
/**
 * @Author: CodeDrawing
 * @Date: 2021/3/21 14:19
 * @Package: top.zwzx.supermarket_001.config
 * 功能：
 * 细节：
 * 注意：
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
//        registry.addViewController("/login.jsp").setViewName("login");
//        registry.addViewController("/main.html").setViewName("dashboard");
    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/login","/user/toLogin","/user/index","/user/getDate","/statics/**");
    }
//    ,"/WEB-INF/login.jsp","/WEB-INF/lib/**","/WEB-INF/classes/**"

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/studentText/uploadFile/**").
//                addResourceLocations("file:/"+"Volumes/studentText/uploadFile/");
//    }
}
