package top.zwzx.springboot_supermarket.config;
import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/13 9:52
 * @Package: top.zwzx.springboot_supermarket.config
 * 功能：
 * 细节：
 * 注意：
 */


@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
//        registry.addViewController("/main.html").setViewName("dashboard");
    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/login.html","/layer-v3.2.0/**","/layui-v2.5.7/**","/userController/toLogin","/userController/login","/userController/toRegister","/userController/register","/css/**","/img/**","/js/**");
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/studentText/uploadFile/**").
//                addResourceLocations("file:/"+"Volumes/studentText/uploadFile/");
//    }
}