package top.zwzx.supermarket_001.unit;

import us.codecraft.webmagic.Spider;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/27 10:47
 * @Package: top.zwzx.supermarket_001.unit
 * 功能：
 * 细节：
 * 注意：
 */
public class WebMagic {
    public static void main(String[] args) {
//        声明spider
       Spider spider= Spider.create(new PageProcessorMV());
//       设置spider的参数
        spider.addUrl("http://lib.njtc.edu.cn/pagelist2-4e944354be7c4b47ba855ab19960c1f3.html");
        spider.thread(5);
        spider.run();
    }
}
