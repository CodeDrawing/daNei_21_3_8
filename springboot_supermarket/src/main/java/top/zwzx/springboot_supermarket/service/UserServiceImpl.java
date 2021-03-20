package top.zwzx.springboot_supermarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.springboot_supermarket.dao.UserMapper;
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
@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public ArrayList<User> loginUser(User user) {
        ArrayList<User> users = userMapper.loginUser(user);
        return users;
    }

    @Override
    public int findUser(String name) {
        ArrayList<User> user = userMapper.findUser(name);
        int size = user.size();
        System.out.println(size);
        return size;
    }

    @Override
    public void register(User user) {
        userMapper.register(user);
    }
}
