package top.zwzx.supermarket_001.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.zwzx.supermarket_001.pojo.Bill;

import java.util.List;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/27 8:22
 * @Package: top.zwzx.supermarket_001.mapper
 * 功能：
 * 细节：
 * 注意：
 */
@Mapper
public interface BillMapper {
    @Select("select * from smbms_bill")
    public List<Bill> getAllBill();
}
