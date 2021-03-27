package top.zwzx.supermarket_001.unit;

import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import javax.lang.model.element.Element;

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
//        System.out.println(page.getHtml());
        Elements c = page.getHtml().getDocument().getElementsByClass("c");
//        Elements c1 = page.getHtml().getDocument().getElementsByAttribute("title");
        Elements c1 = page.getHtml().getDocument().getElementsByTag("title");

//        System.out.println(c.tagName("title"));
        System.out.println(c);
//        Elements elementsByAttributeValueMatching = c.get(0).getElementsByAttributeValueMatching("title", "TD");
        Elements ttile = c.get(0).getElementsMatchingOwnText("title");
        c.get(0).getElementsByAttributeValueMatching("title","a");
        System.out.println(ttile);
        page.putField("name",c);
    }

    @Override
    public Site getSite() {
        return site;
    }
}
