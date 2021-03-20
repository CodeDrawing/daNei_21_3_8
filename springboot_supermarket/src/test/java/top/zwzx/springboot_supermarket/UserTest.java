package top.zwzx.springboot_supermarket;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.zwzx.springboot_supermarket.dao.UserMapper;
import top.zwzx.springboot_supermarket.pojo.User;

import java.util.ArrayList;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/10 17:44
 * @Package: top.zwzx.springboot_supermarket
 * 功能：
 * 细节：
 * 注意：
 */
@SpringBootTest
public class UserTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void userMapperTest(){
        ArrayList<User> allUser = userMapper.getAllUser();
        System.out.println(allUser);
    }
}
