package top.zwzx.supermarket_001;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.zwzx.supermarket_001.mapper.UserMapper;
import top.zwzx.supermarket_001.pojo.User;

import java.util.List;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/20 19:38
 * @Package: top.zwzx.supermarket_001
 * 功能：
 * 细节：
 * 注意：
 */
@SpringBootTest
public class UserTest {
    @Autowired
    public UserMapper userMapper;
    @Test
    public void queryAllUser(){
        List<User> allUser = userMapper.getAllUser();
        System.out.println(allUser);
    }
}
