package scraper;

import com.gargoylesoftware.htmlunit.html.HtmlElement;

import java.util.List;

/**
 * Created by mzukowski on 16/10/2018.
 * God bless young Java Dev : *
 */
public abstract class Scraper<T extends HtmlElement> {
    private List<T> processed;
}
