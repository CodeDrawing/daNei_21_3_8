package top.zwzx.supermarket_001.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.supermarket_001.mapper.UserMapper;
import top.zwzx.supermarket_001.pojo.User;

import java.util.List;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/21 16:00
 * @Package: top.zwzx.supermarket_001.service
 * 功能：
 * 细节：
 * 注意：
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserByPageSize(int no, int size) {
        List<User> userByPageSize = userMapper.getUserByPageSize(no, size);
        return userByPageSize;
    }

    @Override
    public User getUserById(Integer id) {
        User userById = userMapper.getUserById(id);
        return userById;
    }

    @Override
    public int insertUser(User usee) {
        int i = userMapper.insertUser(usee);
        return i;
    }

    @Override
    public int updateUser(User user) {
        int updateuser = userMapper.updateUser(user);
        return updateuser;
    }

    @Override
    public int deleteUser(Integer id) {
        int deleteuser = userMapper.deleteuser(id);
        return deleteuser;
    }

    @Override
    public List<User> queryUser(String queryName, String userRole) {
        List<User> users = userMapper.queryUser(queryName, userRole);
        return users;
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }
}
