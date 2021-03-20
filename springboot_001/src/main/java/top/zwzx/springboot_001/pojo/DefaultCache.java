package top.zwzx.springboot_001.pojo;

import org.springframework.stereotype.Component;

@Component
public class DefaultCache {

    private String info;
//    spring 管理对象默认是单例模式
    public DefaultCache(){
        System.out.println("spring正在创建");
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
