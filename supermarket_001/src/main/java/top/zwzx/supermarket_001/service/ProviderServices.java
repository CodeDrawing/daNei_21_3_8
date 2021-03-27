package  top.zwzx.supermarket_001.service;

import top.zwzx.supermarket_001.pojo.Provider;
import top.zwzx.supermarket_001.pojo.ShowData;

import java.util.ArrayList;
import java.util.List;

public interface ProviderServices {

    public ArrayList<Provider> getAllProvider();

    public ArrayList<Provider> getProviderByNo(int no,int size);

    public ArrayList<Provider> getProviderByName(String proName);

    public ArrayList<Provider> getProviderById(int id);

    public int  AddProvider(Provider provider);

    public  int deleteProvider(int id);

    public int updateProvider(Provider provider);
    public List<ShowData> getAllProvinceAndValue();

}
