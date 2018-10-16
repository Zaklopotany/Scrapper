package scraper;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;

import java.util.List;
import java.util.concurrent.ScheduledFuture;

/**
 * Created by mzukowski on 16/10/2018.
 * God bless young Java Dev : *
 */
public class ContinousUrlScraper extends Scraper implements ScrapMethods<HtmlAnchor, HtmlElement> {


    private String baseUrl;
    //e.g. 1 ,2 and so on. Value that is going to change while scraping
    private Object value;
    //Url to fetch data
    private String Url;
    private WebClient webClient;

    ContinousUrlScraper(String baseUrl, String value, WebClient webClient) {
        this.baseUrl = baseUrl;
        this.value = value;
        this.webClient = webClient;
    }

    private void initialize

    public List<HtmlAnchor> getData() {
        return null;
    }

    public List<HtmlElement> processData() {
        return null;
    }

    public boolean isAnythingToProcess(List<HtmlAnchor> list) {
        return false;
    }
}
