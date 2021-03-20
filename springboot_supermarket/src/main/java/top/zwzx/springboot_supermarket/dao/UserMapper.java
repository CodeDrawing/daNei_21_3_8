package top.zwzx.springboot_supermarket.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import top.zwzx.springboot_supermarket.pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/10 17:41
 * @Package: top.zwzx.springboot_supermarket.dao
 * 功能：
 * 细节：
 * 注意：
 */
@Mapper
public interface UserMapper {
    @Select("select * from user")
    public ArrayList<User> getAllUser();
    public ArrayList<User> loginUser(User user);
    public ArrayList<User> findUser(String name);
    public void register(User user);
}
