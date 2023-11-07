package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css="input[name='email'][type='text']")
    public WebElement emailBox;

    @FindBy(css="input[name='password']")
    public WebElement passwordBox;

    @FindBy(css="button[type='submit'][class='full-width-button orange-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(),' Invalid Credential. Please try again. ')]")
    public WebElement errorMesaage;
    @FindBy(css = ".input-error-message")
    public WebElement inLineErrorMessage;

    @FindBy(xpath = "//span[text()='Pharuk']")
    public WebElement successfulLogin;

}
