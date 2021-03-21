package top.zwzx.supermarket_001.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.zwzx.supermarket_001.pojo.Role;

import java.util.List;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/21 17:10
 * @Package: top.zwzx.supermarket_001.mapper
 * 功能：
 * 细节：
 * 注意：
 */
@Mapper
@Repository
public interface RoleMapper {
    @Select("select * from smbms_role")
    public List<Role> getAllRole();
}
