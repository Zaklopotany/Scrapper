package scraper;

import java.util.List;

/**
 * Created by mzukowski on 16/10/2018.
 * God bless young Java Dev : *
 */
public interface ScrapMethods<T,U> {

    List<T> getData();
    List<U> processData();
    boolean isAnythingToProcess(List<T> list);

}
