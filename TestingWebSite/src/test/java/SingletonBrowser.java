import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SingletonBrowser {
    private static SingletonBrowser browser = null;
    private WebDriver browserDriver;

    public static SingletonBrowser getInstance() {
        if (browser == null) {
            browser = new SingletonBrowser();
        }
        return browser;
    }

    public WebDriver getDriver() {
        return browserDriver;
    }

    public void turnOnBrowser() {
        if (browserDriver == null) {
            browserDriver = new ChromeDriver();
            browserDriver.get("http://automationpractice.com/index.php");
            browserDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        } else {
        }
    }

    public void turnOfBrowser(){
        browserDriver.quit();
    }
}
