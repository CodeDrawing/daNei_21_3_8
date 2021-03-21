package top.zwzx.supermarket_001.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.supermarket_001.mapper.RoleMapper;
import top.zwzx.supermarket_001.pojo.Role;

import java.util.List;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/21 17:11
 * @Package: top.zwzx.supermarket_001.service
 * 功能：
 * 细节：
 * 注意：
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getAllRole() {
        List<Role> allRole = roleMapper.getAllRole();
        return allRole;
    }
}
