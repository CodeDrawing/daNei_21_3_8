package top.zwzx.supermarket_001.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //添加了所有的set get toString 方法
@AllArgsConstructor
@NoArgsConstructor
public class Provider {
    private int id;
    private String proCode;
    private String proName;
    private String proDesc;
    private String proContact;
    private String proPhone;
    private String proAddress;
    private String proFax;
    private int createdBy;
    private String creationDate;
    private String modifyDate;
    private int modifyBy;
    private String province;

}
