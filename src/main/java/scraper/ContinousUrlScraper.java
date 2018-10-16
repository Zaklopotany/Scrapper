package scraper;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

/**
 * Created by mzukowski on 16/10/2018.
 * God bless young Java Dev : *
 */
public class ContinousUrlScraper extends Scraper implements ScrapMethods<HtmlAnchor, String> {


    private String baseUrl;
    //e.g. 1 ,2 and so on. Value that is going to change while scraping
    private Object value;
    //Url to fetch data
    private String url;
    private WebClient webClient;

    ContinousUrlScraper(String baseUrl, String value, WebClient webClient) {
        this.baseUrl = baseUrl;
        this.value = value;
        this.webClient = webClient;
    }


    {
        initalizeScraper();
    }

    @Override
    protected void initalizeScraper() {
        StringBuffer stringBuffer = new StringBuffer(baseUrl);
        stringBuffer.append(value.toString());
        this.url = stringBuffer.toString();
    }


    public List<HtmlAnchor> getData() {
        List<HtmlAnchor> list = new ArrayList<HtmlAnchor>();

        try {
            HtmlPage page = webClient.getPage(url);
            list = page.getByXPath("//a[contains(@class, 'goods-name')]");

        } catch (IOException e) {
            logger.warning("Problem with data, url : " + this.url );
            e.printStackTrace();
        }


        return list;
    }

    public List<String> processData() {
        return null;
    }

    public boolean isAnythingToProcess(List<HtmlAnchor> list) {
        return false;
    }
}
