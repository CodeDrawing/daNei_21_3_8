package top.zwzx.supermarket_001.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.zwzx.supermarket_001.pojo.ShowData;

import java.util.List;

@Mapper
@Repository
public interface ProviderMapper {
    @Select("select province as name,count(province) as value from smbms_provider group by province order by count(province) desc")
    public List<ShowData> getAllProvinceAndValue();
}
