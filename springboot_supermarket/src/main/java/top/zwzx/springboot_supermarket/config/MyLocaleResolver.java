package top.zwzx.springboot_supermarket.config;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/13 9:48
 * @Package: top.zwzx.springboot_supermarket.config
 * 功能：
 * 细节：
 * 注意：
 */


import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author zx
 * @date 2020/6/1
 **/
public class MyLocaleResolver implements LocaleResolver {

    //    解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String language=httpServletRequest.getParameter("l");

        Locale locale =Locale.getDefault();
        if(!StringUtils.isEmpty(language)){
            String[] split = language.split("_");
            locale = new Locale(split[0], split[1]);

        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
