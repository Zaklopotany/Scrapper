import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlListItem;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.util.List;
import java.util.logging.Level;

public class Main {

    public static String MAIN_URL = "";

    public static void main(String[] args) {
        //webClient settings
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(true);
//        webClient.getOptions().setCssEnabled(true);
        webClient.getOptions().setRedirectEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.setJavaScriptTimeout(100000);

        webClient.waitForBackgroundJavaScript(300000);

        try {
            HtmlPage page = webClient.getPage(MAIN_URL);
            System.out.println("Main page not emtpy " + page != null );
            HtmlElement htmlElement =  page.getFirstByXPath("//li[contains(@class, 'page-next')]");

            List<HtmlAnchor> htmlAnchor = htmlElement.getByXPath("//a");
            HtmlAnchor htmlAnchor1 = (HtmlAnchor) htmlElement.getFirstChild();
            System.out.println(htmlElement);
            System.out.println(htmlAnchor1);


            HtmlPage page1 = htmlAnchor1.click();

            System.out.println(page.getUrl());
            System.out.println(page1.getUrl());



//

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
