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
    public List<Bill> getAllBill() {
        List<Bill> allBill = billMapper.getAllBill();
        return allBill;
    }
}
