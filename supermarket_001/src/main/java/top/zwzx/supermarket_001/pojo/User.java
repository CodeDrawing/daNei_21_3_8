package top.zwzx.supermarket_001.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/20 17:22
 * @Package: top.zwzx.supermarket_001.pojo
 * 功能：
 * 细节：
 * 注意：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer id;
    private String userCode;
    private String userName;
    private String userPassword;
    private String confirmPassword;
    private String originalPassword;
    private Integer gender;
    private Date birthday;
    private String phone;
    private String address;
    private Integer userRole;
    private Integer createdBy;
    private Date creationDate;
    private Integer modifyBy;
    private Date modifyDate;
    private int age;
}
