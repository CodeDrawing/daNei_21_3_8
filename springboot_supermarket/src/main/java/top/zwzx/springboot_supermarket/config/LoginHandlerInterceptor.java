package top.zwzx.springboot_supermarket.config;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/13 9:49
 * @Package: top.zwzx.springboot_supermarket.config
 * 功能：
 * 细节：
 * 注意：
 */
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zx
 * @date 2020/6/1
 **/
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//             登陆成功后，应该有用户的session

        Object loginUser = request.getSession().getAttribute("loginUser");

        if(loginUser==null){
                request.setAttribute("msg", "没有权限，请先登陆");
                request.getRequestDispatcher("/login.html").forward(request, response);
//            不放行
            return false;
        }else{
//            否则放行
            return true;
        }

    }
}
