package top.zwzx.supermarket_001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.zwzx.supermarket_001.mapper.UserMapper;
import top.zwzx.supermarket_001.pojo.Role;
import top.zwzx.supermarket_001.pojo.User;
import top.zwzx.supermarket_001.service.IRoleService;
import top.zwzx.supermarket_001.service.IUserService;

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
    private UserMapper userMapper;
    @Autowired
    private IRoleService iRoleService;
    @Autowired
    private IUserService iUserService;

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
            model.addAttribute("userName",userByUser.get(0).getUserName());
            return "frame";
        }else{
            model.addAttribute("error","用户名或密码错误！");
            return "login";
        }
    }
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession httpSession){
        httpSession.removeAttribute("userName");
        return "redirect:/user/toLogin";
    }
    @RequestMapping("/userList")
    public String userList(Model model){
        List<User> allUser = userMapper.getAllUser();
        List<Role> allRole = iRoleService.getAllRole();
        model.addAttribute("userList",allUser);
        model.addAttribute("roleList",allRole);
        System.out.println(allUser);
        return "userlist";
    }
    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        iUserService.deleteUser(id);
        System.out.println(id);
        return "redirect:/user/userList";
    }
    @RequestMapping("/toUpdateUserInfo/{id}")
    public String toUpdateUserInfo(@PathVariable("id")Integer id,Model model){
        User userById = iUserService.getUserById(id);
        model.addAttribute("user",userById);
        return "/updateUserInfo";

    }

}
