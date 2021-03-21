package top.zwzx.supermarket_001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.zwzx.supermarket_001.mapper.UserMapper;
import top.zwzx.supermarket_001.pojo.User;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/20 20:15
 * @Package: top.zwzx.supermarket_001.controller
 * 功能：
 * 细节：
 * 注意：
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserMapper userMapper;

    @RequestMapping("/toLogin")
    public String toLogin(User user){
        return "login";
    }
    @RequestMapping("/login")
    public String login(User user, HttpSession httpSession, Model model){
        System.out.println(user);
        List<User> userByUser = userMapper.getUserByUser(user);
        if(userByUser.size()==1){
//            httpSession.setAttribute("loginUser",user.getUserName());
            httpSession.setAttribute("userName",user.getUserCode());
//            model.addAttribute("userName","sdf");
            model.addAttribute("userName",user.getUserCode());
            return "frame";
        }else{
            model.addAttribute("error","用户名或密码错误！");
            return "redirect:/user/toLogin";
        }
    }
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession httpSession){
        httpSession.removeAttribute("userName");
        return "redirect:/user/toLogin";
    }
    @RequestMapping("/userList")
    public String userList(){
        return "/user/userlist";
    }

}
