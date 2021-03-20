package top.zwzx.springboot_001;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.zwzx.springboot_001.pojo.DefaultCache;
import top.zwzx.springboot_001.pojo.DefaultCache2;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/9 15:33
 * @Package: top.zwzx.springboot_001
 */
@SpringBootTest
public class DefaultCacheTest {
//    测试spring是否管理了DefaultCache;

    @Autowired //从spring容器中取出对象
    private DefaultCache defaultCache;
    @Autowired //从spring容器中取出对象
    private DefaultCache2 defaultCache2;
//    单元测试
    @Test
    void testDefaultCacheTest(){
        System.out.println(defaultCache.getInfo());
        System.out.println(defaultCache);
    }




}
