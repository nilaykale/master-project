package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void click(WebElement element){
        waitForElementToBeClickable(element);
        element.click();
    }

    protected  void sendKeys(WebElement element, String keys){
        waitForElementToBeVisible(element);
        element.sendKeys(keys);
    }

    protected void waitForElementToBeVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void waitForElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    protected void tryClick(WebElement element) {
        try {
            Thread.sleep(2000);
            element.click();
        } catch (Exception ignored) {
        }
    }

    public Boolean isExist(WebElement element) {
        waitForElementToBeVisible(element);
        return element.isDisplayed();
    }
}
