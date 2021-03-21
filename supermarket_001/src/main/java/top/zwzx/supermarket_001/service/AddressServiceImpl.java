package top.zwzx.supermarket_001.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.supermarket_001.mapper.AddressMapper;
import top.zwzx.supermarket_001.pojo.Address;

import java.util.List;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/21 15:37
 * @Package: top.zwzx.supermarket_001.service
 * 功能：
 * 细节：
 * 注意：
 */
@Service
public class AddressServiceImpl implements IAddressService{
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> getAllAddress() {
        List<Address> allAddress = addressMapper.getAllAddress();
        return allAddress;
    }
}
