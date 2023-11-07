package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import utilities.BasePage;
import utilities.Driver;

import java.time.Duration;

public class SendWorkOfferStepDefinitions {
    LoginPage loginPage;
    BasePage basePage = new BasePage() {
        @Override
        public WebElement username() {
            return null;
        }
    };
    public WebDriver driver;
    public ChromeOptions options;
    @Given("navigate to the website")
    public void navigateToTheWebsite() {
        loginPage= new LoginPage();
        driver= Driver.getDriver();
        options=new ChromeOptions();
        options.addArguments("start minimize");
//        System.out.println("window sizing");
//        Dimension setDimension = new Dimension(1440,800);
//       driver.manage().window().setSize(setDimension);
        driver.manage().window().maximize();
        driver.get("https://app.testingmonkey.com/partner/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @And("login with <{string}> and <{string}>")
    public void loginWithClient(String email, String password) {
    loginPage.emailBox.sendKeys(email);
    loginPage.passwordBox.sendKeys(password);
    loginPage.loginButton.click();
    }

    @And("redirect to public profile <{URL}>")
    public void openPublicProfile(String Url){
        driver.get(Url);
    }

    @And("Select contract Duration of <{num}> months")
    public void selectContractDuration( ){
    }
}
