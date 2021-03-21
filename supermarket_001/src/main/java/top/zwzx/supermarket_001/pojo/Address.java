package top.zwzx.supermarket_001.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/21 9:27
 * @Package: top.zwzx.supermarket_001.pojo
 * 功能：地址实体类
 * 细节：
 * 注意：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    private Integer id;
    private String contact;
    private String addressDesc;
    private String postCode;
    private String tel;
    private Integer createdBy;
    private Date creationDate;
    private Integer modifyBy;
    private Date modifyDate;
    private Integer userId;
}
