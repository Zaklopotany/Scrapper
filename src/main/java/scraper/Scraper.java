package scraper;

import com.gargoylesoftware.htmlunit.html.HtmlElement;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by mzukowski on 16/10/2018.
 * God bless young Java Dev : *
 */
public abstract class Scraper<T extends HtmlElement> {
    private List<T> processed;
    private List<T> data;

    static final Logger logger = Logger.getLogger(Scraper.class.getName());


    protected abstract void initalizeScraper();



    public void setData(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public List<T> getProcessed() {
        return processed;
    }

    public void setProcessed(List<T> processed) {
        this.processed = processed;
    }
}
