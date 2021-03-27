package top.zwzx.supermarket_001.service;

import top.zwzx.supermarket_001.pojo.Bill;

import java.util.List;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/27 8:24
 * @Package: top.zwzx.supermarket_001.service
 * 功能：
 * 细节：
 * 注意：
 */
public interface IBillService {
    public List<Bill> getAllBill(Integer page,Integer limit);
    public Integer getCountForBill();
    public void addBill(Bill bill);
    public List<Bill> getBillByBillCode(String billCode);
    public int deleteBillById(Integer id);
    public Bill getBillById(Integer id);
    public void updateBill(Bill bill);


}
