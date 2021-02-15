import org.junit.*;
import org.openqa.selenium.WebElement;

import java.util.List;


public class TestingYourLogo {

    @Before
    public void TurningOnBrowser(){
       SingletonBrowser browserChrome = SingletonBrowser.getInstance();
       browserChrome.turnOnBrowser();
    }

    @Test
    public void TestingYourLogo(){
        SignInPage entrancing = new SignInPage();
        SectionsPage randomSections = new SectionsPage();

        entrancing.goToSignInPage();
        entrancing.logInAccount();

        List<WebElement> listOfSections = randomSections.getListOfSections();
        randomSections.printListOfSections(listOfSections);
        WebElement randomSection = randomSections.getWebelementOfRandomSection(listOfSections);
        String expectedSectionName = randomSections.getExpectedRandomSectionName(randomSection);
        randomSections.clickRandomSection(randomSection);
        String actualSectionName = randomSections.getActualRandomSectionName();
        randomSections.checkCorrectSection(actualSectionName, expectedSectionName);

        entrancing.signOutFromAccount();
    }

    @After
    public void turningOfBrowser(){
        SingletonBrowser browserChrome = SingletonBrowser.getInstance();
        browserChrome.turnOfBrowser();
    }



}


