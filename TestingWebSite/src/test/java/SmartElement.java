import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class SmartElement {
    private By locator;

    public SmartElement(By locator) {
        this.locator = locator;
    }

    public void click() {
        WebDriverWait waitLoginButton = new WebDriverWait
                (SingletonBrowser.getInstance().getDriver(), 10);
        WebElement webElement = waitLoginButton.until(ExpectedConditions.visibilityOfElementLocated(locator));
        webElement.click();
    }

    public void sendKeys(String data) {
        WebDriverWait waitLoginInput = new WebDriverWait
                (SingletonBrowser.getInstance().getDriver(), 10);
        WebElement webElement = waitLoginInput.until(ExpectedConditions.visibilityOfElementLocated
                (locator));
        webElement.sendKeys(data);
    }

    public List<WebElement> getList(){
        WebDriver driverForList = SingletonBrowser.getInstance().getDriver();
        WebDriverWait waitForListOfSections = new WebDriverWait
                (driverForList, 10);
        waitForListOfSections.until(ExpectedConditions.visibilityOfElementLocated
                (locator));
        List<WebElement> sectionsOnMainPage = driverForList.findElements((locator));
        return sectionsOnMainPage;
    }
}
