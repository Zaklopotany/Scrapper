import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.util.logging.Level;

public class Main {

    public static String MAIN_URL = "https://www.wp.pl";

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
            HtmlPage page =  webClient.getPage(MAIN_URL);
            System.out.println(page.asXml());
//
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
