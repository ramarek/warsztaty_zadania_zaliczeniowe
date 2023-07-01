package zadania.WebDriverWrapper;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

import java.time.Duration;

public class WebDriverWrapper {


    private final WebDriver driver;
    private final Wait<WebDriver> wait;
    private final String ChromeDriverPath="C:\\Users\\rober\\warsztaty_zadania_zaliczeniowe\\src\\test\\resources\\chromeDriver\\chromedriver.exe";

    public WebDriverWrapper() {
        System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
        this.driver = new ChromeDriver();
        this.wait = getFluentWait();
       }


    private Wait<WebDriver> getFluentWait(){
        return new FluentWait<WebDriver>(this.driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
    }
    public WebDriver getDriver() {
        return driver;
    }
    public void OpenPage(String url) {
        driver.get(url);

    }
    public void quitDriver() {
        driver.quit();

    }
    public void waitUntilElementIsVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement findElementByName(String elementName) {
        return driver.findElement(By.name(elementName));
    }
    public WebElement findElementByLinkText(String text) {
        return driver.findElement(By.linkText(text));
    }
    public WebElement findElementById(String elementId) {
        return driver.findElement(By.id(elementId));
    }
    public WebElement findElementByCss(String css) {
        return driver.findElement(By.cssSelector(css));
    }
    public void clickOnElement(WebElement webElement){
        waitUntilElementIsVisible(webElement);
        webElement.click();

    }
    public void enterText(WebElement webElement, String text){
        waitUntilElementIsVisible(webElement);
        webElement.click();
        webElement.clear();
        webElement.sendKeys(text);

    }
    public void setSelect(WebElement webElement, String value){
        waitUntilElementIsVisible(webElement);
        Select select = new Select(webElement);
        select.selectByValue(value);
    }

    public String getText(WebElement webElement) {
        waitUntilElementIsVisible(webElement);
        return webElement.getText();
    }

}