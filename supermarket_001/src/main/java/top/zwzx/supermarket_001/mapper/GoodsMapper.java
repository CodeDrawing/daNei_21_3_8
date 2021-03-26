package top.zwzx.supermarket_001.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.zwzx.supermarket_001.pojo.ShowData;

import java.util.List;

@Mapper
@Repository
public interface GoodsMapper {

    @Select("select productDesc as name,sum(productCount) as value  from smbms_bill group by productDesc order by sum(productCount) desc  limit 5")
    public List<ShowData> getAllProductDescAndValue();

}
