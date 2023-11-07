package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import static utilities.Driver.driver;
public abstract class BasePage {
    public abstract WebElement username();

    public void scrollToElement(WebElement element) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        int elementY = element.getLocation().getY();
        int elementHeight = element.getSize().getHeight();
        int centerY = elementY + elementHeight / 2;
        // Get the viewport height
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        long viewportHeight = (long) jsExecutor.executeScript("return window.innerHeight");

        // Calculate the scroll amount to center the element
        long scrollY = centerY - viewportHeight / 2;

        // Scroll to the calculated position
        jsExecutor.executeScript("window.scrollTo(0,arguments[0]);", scrollY);
    }
}
