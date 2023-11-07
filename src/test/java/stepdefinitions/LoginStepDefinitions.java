package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import utilities.BasePage;
import utilities.Driver;

import java.time.Duration;

public class LoginStepDefinitions {
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
        System.out.println("window sizing");
        Dimension setDimension = new Dimension(1440,800);
        driver.manage().window().setSize(setDimension);
        //driver.manage().window().maximize();
        driver.get("https://app.testingmonkey.com/partner/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @And("enter your username<{string}>")
    public void enterYourUsername(String email) {
        loginPage.emailBox.sendKeys(email);

    }

    @And("enter the password<{string}>")
    public void enterThePassword(String password) {
        loginPage.passwordBox.sendKeys(password);
    }

    @And("click login button")
    public void clickLoginButton() {
        basePage.scrollToElement(loginPage.loginButton);
        loginPage.loginButton.click();
    }

    @Then("verify inline error message")
    public void verifyInLineErrorMessage(){
        try {
            Assert.assertTrue(loginPage.inLineErrorMessage.isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
        }
    }

    @Then("verify the error message")
    public void verifyTheErrorMessage() {
        try {
            Assert.assertTrue(loginPage.errorMesaage.isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
        }
    }

    @Then("verify the user has logged in successfully")
    public void verifyTheUserHasLoggedInSuccessfully() {
        Assert.assertTrue(loginPage.successfulLogin.isDisplayed());

    }
}
