package  top.zwzx.supermarket_001.service;

import  top.zwzx.supermarket_001.mapper.ProviderMapper;
import top.zwzx.supermarket_001.pojo.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.supermarket_001.pojo.ShowData;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderServices {

    @Autowired
    ProviderMapper providerMapper;

    @Override
    public ArrayList<Provider> getAllProvider() {
        return providerMapper.getAllProvider();
    }

    @Override
    public ArrayList<Provider> getProviderByNo(int no, int size) {
        return providerMapper.getProviderByNo(no,size);
    }

    @Override
    public ArrayList<Provider> getProviderByName(String proName) {
        return providerMapper.getProviderByName(proName);
    }

    @Override
    public ArrayList<Provider> getProviderById(int id) {
        return providerMapper.getProviderById(id);
    }

    @Override
    public int AddProvider(Provider provider) {
        return providerMapper.insertProvider(provider);
    }

    @Override
    public int deleteProvider(int id) {
        return providerMapper.deleteProvider(id);
    }

    @Override
    public int updateProvider(Provider provider) {
        return providerMapper.updateProvider(provider);
    }

    @Override
    public List<ShowData> getAllProvinceAndValue() {
        List<ShowData> allProvinceAndValue = providerMapper.getAllProvinceAndValue();
        return allProvinceAndValue;
    }
}
