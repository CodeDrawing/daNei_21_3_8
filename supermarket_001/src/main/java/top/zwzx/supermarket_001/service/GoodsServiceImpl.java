package top.zwzx.supermarket_001.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.supermarket_001.mapper.GoodsMapper;
import top.zwzx.supermarket_001.pojo.ShowData;

import java.util.List;
@Service
public class GoodsServiceImpl implements IGoodsService{

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<ShowData> getAllProductDescAndValue() {
        List<ShowData> allProductDescAndValue = goodsMapper.getAllProductDescAndValue();
        return allProductDescAndValue;
    }
}
