package top.zwzx.supermarket_001.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.supermarket_001.mapper.ProviderMapper;
import top.zwzx.supermarket_001.pojo.ShowData;

import java.util.List;

@Service
public class ProviderServiceImpl implements IProviderService {

    @Autowired
    private ProviderMapper providerMapper;

    @Override
    public List<ShowData> getAllProvinceAndValue() {
        List<ShowData> allProvinceAndValue = providerMapper.getAllProvinceAndValue();
        return allProvinceAndValue;
    }
}
