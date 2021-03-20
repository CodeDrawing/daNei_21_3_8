package top.zwzx.springboot_supermarket.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/10 15:51
 * @Package: top.zwzx.springboot_supermarket.pojo
 * 细节：
 * 注意：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String password;
    private String confirmPassword;
}
