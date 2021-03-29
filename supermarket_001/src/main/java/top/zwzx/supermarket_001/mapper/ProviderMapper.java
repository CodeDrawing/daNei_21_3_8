package  top.zwzx.supermarket_001.mapper;

import top.zwzx.supermarket_001.pojo.Provider;
import org.apache.ibatis.annotations.*;
import top.zwzx.supermarket_001.pojo.ShowData;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface ProviderMapper {
    @Select("select * from smbms_provider")
    public ArrayList<Provider> getAllProvider();

    /***
     * 获取供应商分页信息
     * @param no
     * @param size
     * @return
     */
    @Select("select * from smbms_provider limit #{no},#{size}")
    public ArrayList<Provider> getProviderByNo(int no, int size);

    @Select("select count(*) from smbms_provider")
    public int getProviderCount();

    @Select("select * from smbms_provider where proName like '%${proName}%'")
    public ArrayList<Provider> getProviderByName(String proName);

    @Select("select * from smbms_provider where id=#{id}")
    public ArrayList<Provider> getProviderById(int id);

    @Insert("insert into smbms_provider(proCode,proName,proDesc,proContact,proPhone,proAddress,proFax,createdBy,creationDate) " +
            "values(#{proCode},#{proName},#{proDesc},#{proContact},#{proPhone},#{proAddress},#{proFax},#{createdBy},#{creationDate})")
    public int insertProvider(Provider provider);
    @Delete("delete from smbms_provider where id=#{id}")
    public int deleteProvider(int id);
    @Update("update smbms_provider set proCode=#{proCode},proName=#{proName},proDesc=#{proDesc},proContact=#{proContact},proPhone=#{proPhone}," +
            "proAddress=#{proAddress},proFax=#{proFax},modifyDate=#{modifyDate},modifyBy=#{modifyBy} where id=#{id}")
    public int updateProvider(Provider provider);


    @Select("select province as name,count(province) as value from smbms_provider group by province order by count(province) desc")
    public List<ShowData> getAllProvinceAndValue();
}
