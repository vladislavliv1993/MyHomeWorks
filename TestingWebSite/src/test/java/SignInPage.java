import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;


public class SignInPage {

    private SmartElement loginButton = new SmartElement(By.xpath("//a[@title='Log in to your customer account']"));
    private SmartElement emailWindow = new SmartElement(By.xpath("//input[@id='email']"));
    private SmartElement passwordWindow = new SmartElement(By.xpath("//input[@id='passwd']"));
    private SmartElement signinBy = new SmartElement(By.xpath("//button[@name='SubmitLogin']"));
    private SmartElement signOut = new SmartElement(By.xpath("//a[@title='Log me out']"));

    private String login = "vladislavliv@mail.ru" ;
    private String password = "testtask2021";


    public void goToSignInPage() {
        loginButton.click();
    }

    public void logInAccount(){
        emailWindow.sendKeys(login);
        passwordWindow.sendKeys(password);
        signinBy.click();
    }

    public void signOutFromAccount(){
        signOut.click();
    }
}


