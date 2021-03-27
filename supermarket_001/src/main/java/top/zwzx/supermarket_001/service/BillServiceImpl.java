package top.zwzx.supermarket_001.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.supermarket_001.mapper.BillMapper;
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
@Service
public class BillServiceImpl implements  IBillService{

    @Autowired
    private BillMapper billMapper;

    @Override
    public List<Bill> getAllBill(Integer page,Integer limit) {
        List<Bill> allBill = billMapper.getAllBill((page-1)*limit,limit);
//        System.out.println(page+" ,"+limit);
        return allBill;
    }

    @Override
    public Integer getCountForBill() {
        Integer countForBill = billMapper.getCountForBill();
        return countForBill;
    }

    @Override
    public void addBill(Bill bill) {
        billMapper.addBill(bill);
    }

    @Override
    public List<Bill> getBillByBillCode(String billCode) {
        List<Bill> billByBillCode = billMapper.getBillByBillCode(billCode);
        return billByBillCode;
    }
}
