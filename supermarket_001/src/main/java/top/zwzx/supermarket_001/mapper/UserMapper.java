package top.zwzx.supermarket_001.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import top.zwzx.supermarket_001.pojo.User;

import java.util.List;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/20 17:30
 * @Package: top.zwzx.supermarket_001.mapper
 * 功能：
 * 细节：
 * 注意：
 */
@Mapper
public interface UserMapper {
    //用户登录
    @Select("select * from smbms_user where userCode=#{userCode} and userPassword=#{userPassword}")
    public List<User> getUserByUser(User user);
//  用户注册
    @Insert("insert into smbms_user(userName,userPassword,birthday,phone,address,createdBy,createDate,modifyBy,modifyDate,userRole) value (#{userName},#{userPassword},#{birthday},#{phone},#{address},#{createdBy},#{createDate},#{modifyBy},{modifyDate},#{userRole})")
    public int insertUser(User user);

    //    用户列表信息
    @Select("select * from smbms_user")
    public List<User> getAllUser();

    @Select("select * from smbms_user where id=#{id}")
    public User getUserById(Integer id);

    @Select("select * from smbms_user where userCode=#{userCode}")
    public List<User> getUserByUserCode(String userCode);

    //    分页获取
    @Select("select limit..... * from smbms_user")
    public List<User> getUserByPageSize(int no, int size);

    //    用户修改信息
    @Update("update smbms_user set userName=#{userName},gender=#{gender},birthday=#{birthday},phone=#{phone},address=#{address},modifyBy=#{modifyBy},modifyDate=#{modifyDate} where id=#{id}")
    public int updateUser(User user);

//    用户删除
    @Delete("delete from smbms_user where id=#{id}")
    public int deleteuser(int Userid);

//    查询用户
    public List<User> queryUser(String queryName,String userRole);

//   添加用户
    public void addUser(User user);
@Update("update smbms_user set userPassword=#{userPassword} where id=#{id}" )
    public void updatePasswordById(User user);
}