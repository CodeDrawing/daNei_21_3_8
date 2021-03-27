package top.zwzx.supermarket_001.mapper;

import org.apache.ibatis.annotations.Insert;
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
    @Select("select * from smbms_bill limit #{page},#{limit}")
    public List<Bill> getAllBill(Integer page,Integer limit);

    @Select("select count(*) from smbms_bill")
    public Integer getCountForBill();

    @Insert("insert into smbms_bill(billCode,productName,productDesc,productUnit,productCount,totalPrice,isPayment,createdBy,creationDate) value(#{billCode},#{productName},#{productDesc},#{productUnit},#{productCount},#{totalPrice},#{isPayment},#{createdBy},#{creationDate})")
    public void addBill(Bill bill);

    @Select("select * from smbms_bill where billCode=#{billCode}")
    public List<Bill> getBillByBillCode(String billCode);

}