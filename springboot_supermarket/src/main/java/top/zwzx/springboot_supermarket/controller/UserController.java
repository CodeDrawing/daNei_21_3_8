package top.zwzx.springboot_supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zwzx.springboot_supermarket.pojo.User;
import top.zwzx.springboot_supermarket.service.IUserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/10 15:17
 * @Package: top.zwzx.springboot_supermarket.controller
 * 细节：
 * 注意：
 */

/**
 * 新建一个控制器，把控制器交给spring管理
 */
@Controller
@RequestMapping("/userController")
public class UserController {

    @Autowired
    private IUserService iUserService;


    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }
    @RequestMapping("/register")
    @CrossOrigin
    @ResponseBody
    public Map register(User user){
        HashMap<String, Object> map = new HashMap<>();

        if(!user.getPassword().equals(user.getConfirmPassword())){
//            两次密码不一致
            map.put("result",3012);
        }else if(user.getName().isEmpty()){
            map.put("result",3014);
        }else{
            if(iUserService.findUser(user.getName())==0){
                iUserService.register(user);
                map.put("result",2011);
            }else{
//                用户名重复
                map.put("result",3013);
            }
        }

        return map;
    }
//    当用户的请求为userContriller/login时，进入到该方法
    @RequestMapping("/login")
    public String login(User user, Model model, HttpSession httpSession){
//        if("admin".equals(user.getName())&&"admin".equals(user.getPassword())){
//            model.addAttribute("msg","登录成功");
//            model.addAttribute("result","210");
//            return "user";
//        }else {
//            model.addAttribute("msg","登录失败");
//            model.addAttribute("result","211");
//            return "login";
//        }
        ArrayList<User> users = iUserService.loginUser(user);
        if(users.size()==1){
            model.addAttribute("msg","登录成功");
            model.addAttribute("result","2010");
            httpSession.setAttribute("loginUser",user.getName());
            return "user";
        }else{
            model.addAttribute("msg","用户名或密码错误！请重试");
            model.addAttribute("result","3011");
            return "login";
        }

    }
}
