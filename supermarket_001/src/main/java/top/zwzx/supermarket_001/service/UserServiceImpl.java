package top.zwzx.supermarket_001.service;

import org.springframework.beans.factory.annotation.Autowired;
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
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserByPageSize(int no, int size) {
        List<User> userByPageSize = userMapper.getUserByPageSize(no, size);
        return userByPageSize;
    }

    @Override
    public int insertUser(User usee) {
        int i = userMapper.insertUser(usee);
        return i;
    }

    @Override
    public int updateUser(User user) {
        int updateuser = userMapper.updateuser(user);
        return updateuser;
    }

    @Override
    public int deleteUser(Integer id) {
        int deleteuser = userMapper.deleteuser(id);
        return deleteuser;
    }
}
