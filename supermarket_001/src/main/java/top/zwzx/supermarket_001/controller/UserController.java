package top.zwzx.supermarket_001.controller;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLFault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zwzx.supermarket_001.mapper.UserMapper;
import top.zwzx.supermarket_001.pojo.ShowData;
import top.zwzx.supermarket_001.pojo.Role;
import top.zwzx.supermarket_001.pojo.User;
import top.zwzx.supermarket_001.service.IGoodsService;
import top.zwzx.supermarket_001.service.IProviderService;
import top.zwzx.supermarket_001.service.IRoleService;
import top.zwzx.supermarket_001.service.IUserService;

import javax.servlet.http.HttpSession;
import java.util.*;

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
    @Autowired
    private IGoodsService iGoodsService;
    @Autowired
    private IProviderService iProviderService;


    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin(User user){
        return "login";
    }
    @RequestMapping("/getDate")
    @ResponseBody
    @CrossOrigin
    public Map getDate(){
        HashMap<String, List<ShowData>> map = new HashMap<>();
//        Goods goods = new Goods();
//
//        goods.setName("洗发水");
//        goods.setValue(5);
//        System.out.println(goods);
//        System.out.println(goods1);
//        goods1.add(goods);
//
//        Goods goodss = new Goods();
//        goodss.setName("饮料");
//        goodss.setValue(3);
//        System.out.println(goodss);
//        System.out.println(goods1);
//        goods1.add(goodss);
//
//        Goods goodsss = new Goods();
//        goodsss.setName("卫生纸");
//        goodsss.setValue(8);
//        System.out.println(goodsss);
//        System.out.println(goods1);
//        goods1.add(goodss);

//        Goods goodssss = new Goods();
//        goodssss.setName("本子");
//        goodssss.setValue(1);
//        System.out.println(goodssss);
//        System.out.println(goods1);
//        goods1.add(goodss);

        List<ShowData> allProductDescAndValue = iGoodsService.getAllProductDescAndValue();
        List<ShowData> allProvinceAndValue = iProviderService.getAllProvinceAndValue();

        map.put("topFive",allProductDescAndValue);
        map.put("provinceCount",allProvinceAndValue);

//        map.put()
//        map.put(200,"洗发水");
//        map.put(200,"饮料");
//        map.put(200,"作业本");
//        map.put(200,"饼干");

        return map;
    }
    @RequestMapping("/login")
    public String login(User user, HttpSession httpSession, Model model){
        System.out.println(user);
        List<User> userByUser = userMapper.getUserByUser(user);
        if(userByUser.size()==1){
//            httpSession.setAttribute("loginUser",user.getUserName());
            httpSession.setAttribute("userName", user.getUserCode());
            httpSession.setAttribute("id", userByUser.get(0).getId());
//            model.addAttribute("userName","sdf");
            model.addAttribute("userName",userByUser.get(0).getUserName());
            return "redirect:/user/index";
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
    public String toUpdateUserInfo(@PathVariable("id") Integer id, Model model) {
        User userById = iUserService.getUserById(id);
        model.addAttribute("user", userById);
        return "/updateUserInfo";

    }

    @RequestMapping("/updateUserInfo")
    public String updateUserInfo(User user, Model model, HttpSession httpSession) {
        System.out.println("更新了用户信息");
        user.setModifyBy((Integer) httpSession.getAttribute("id"));
        user.setModifyDate(new Date());
        int i = iUserService.updateUser(user);
        return "redirect:/user/userList";

    }

    @RequestMapping("/queryUser")
    public String queryUser(String queryName,String queryUserRole,Model model){

        List<User> users = iUserService.queryUser(queryName, queryUserRole);
        List<Role> allRole = iRoleService.getAllRole();
        model.addAttribute("userList",users);
        model.addAttribute("roleList",allRole);
        return "userlist";
    }

    @RequestMapping("/toAddUser")
    public String toAddUser(){
        return "/addUser";
    }

    @RequestMapping("/addUser")
    public String addUser(User user,HttpSession session,Model model){

        if(iUserService.getUserByUserCode(user.getUserCode()).size()!=0){
            model.addAttribute("msg","用户已存在，请重新输入");
            return "/addUser";
        }else if(!user.getUserPassword().equals(user.getConfirmPassword())){
            model.addAttribute("msg","两次密码不一致");
            return "/addUser";
        }
        iUserService.addUser(user);
        user.setCreatedBy((Integer) session.getAttribute("id"));
        user.setCreationDate(new Date());
        return "redirect:/user/userList";
    }

}
