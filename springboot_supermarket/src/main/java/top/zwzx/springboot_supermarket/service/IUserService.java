package top.zwzx.springboot_supermarket.service;

import top.zwzx.springboot_supermarket.pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/10 17:49
 * @Package: top.zwzx.springboot_supermarket.service
 * 功能：
 * 细节：
 * 注意：
 */

public interface IUserService {
    public ArrayList<User> loginUser(User user);
    public int findUser(String name);
    public void register(User user);


}
