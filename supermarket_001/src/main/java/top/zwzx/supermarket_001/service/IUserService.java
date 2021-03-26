package top.zwzx.supermarket_001.service;

import top.zwzx.supermarket_001.pojo.User;

import java.util.List;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/21 9:13
 * @Package: top.zwzx.supermarket_001.service
 * 功能：自动化插件-----自动生成代码
 * 细节：
 * 注意：
 */

public interface IUserService {
    /***
     * 分页查询 pagehelper
     * @param no
     * @param size
     * @return
     */
    public List<User> getUserByPageSize(int no,int size);

    public User getUserById(Integer id);


    /***
     * 用户注册
     * @param usre
     * @return =0注册失败 =1注册成功
     */
    public int insertUser(User usre);


    /***
     * 用户信息修改
     * @param user
     * @return >0 修改用户
     */
    public int updateUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    public int deleteUser(Integer id);

    public List<User> queryUser(String queryName,String userRole);

    public void addUser(User user);

    public List<User> getUserByUserCode(String userCode);



}
