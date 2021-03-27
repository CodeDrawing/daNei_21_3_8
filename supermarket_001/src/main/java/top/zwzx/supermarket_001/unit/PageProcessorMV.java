package top.zwzx.supermarket_001.unit;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/27 10:48
 * @Package: top.zwzx.supermarket_001.unit
 * 功能：页面解析
 * 细节：
 * 注意：
 */

public class PageProcessorMV implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        System.out.println(page.getHtml());
    }

    @Override
    public Site getSite() {
        return site;
    }
}
