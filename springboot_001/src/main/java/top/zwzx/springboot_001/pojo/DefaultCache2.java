package top.zwzx.springboot_001.pojo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/9 16:30
 * @Package: top.zwzx.springboot_001.pojo
 * 细节：延迟加载      —— 基本上不用的对象；大对象
 *      对象的生命周期 --
 * 注意：
 */
//模拟延迟加载----
@Lazy  //延迟加载：使用时，才进行加载

@Component   //将该类让spring来管理
public class DefaultCache2 {
    public DefaultCache2(){
        System.out.println("正在创建DefaultCache2");
    }
}
