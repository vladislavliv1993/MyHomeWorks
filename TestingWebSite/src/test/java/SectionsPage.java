import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class SectionsPage {

    private SmartElement sections = new SmartElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li/a"));
    private SmartElement checkName = new SmartElement(By.xpath("//span[@class='cat-name']"));


    public List<WebElement> getListOfSections(){
        List<WebElement> listOfSections = sections.getList();
        return listOfSections;
    }

    public void printListOfSections(List<WebElement> list){
        System.out.println("The list of the most popular sections on web-site: ");
        for (WebElement element : list) {
            System.out.println(element.getText());
        }
    }

    public WebElement getWebelementOfRandomSection(List<WebElement> list){
        Random rand = new Random();
        WebElement randomSection = list.get(rand.nextInt(list.size()));
        return randomSection;
    }

    public String getExpectedRandomSectionName(WebElement randomSection){
        String expectedElement = randomSection.getText().trim();
        return expectedElement;
    }

    public void clickRandomSection(WebElement randomSection){
        WebDriverWait waitLoginButton = new WebDriverWait
                (SingletonBrowser.getInstance().getDriver(), 10);
        WebElement webElement = waitLoginButton.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"block_top_menu\"]/ul/li/a")));
        randomSection.click();
    }

    public String getActualRandomSectionName(){
        WebDriver driverForList = SingletonBrowser.getInstance().getDriver();
        WebElement actual = driverForList.findElement(By.xpath("//span[@class='cat-name']"));
        String actualElement = actual.getText().trim();
        return actualElement;
    }

    public void checkCorrectSection(String actual, String expected){
        Assert.assertEquals(actual, expected);
    }




}
