package zadania.WebDriverWrapper;

// import selenium
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
// potrzebne rzeczy do liczenia czasu, screanshot...
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;

public class WebDriverWrapper {
    private static WebDriverWrapper INSTANCE; // na przyszłośc do rozbudowy
    private final WebDriver driver;
    private final Wait<WebDriver> wait; // potrzebne do liczenia czasu
    private final String ChromeDriverPath = "C:\\Users\\rober\\warsztaty_zadania_zaliczeniowe\\src\\test\\resources\\chromeDriver\\chromedriver.exe";

    private WebDriverWrapper() {
        System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
        this.driver = new ChromeDriver();
        this.wait = getFluentWait();
    }

    public static WebDriverWrapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WebDriverWrapper();
        }
        return INSTANCE;
    }
    private Wait<WebDriver> getFluentWait() {
        return new FluentWait<WebDriver>(this.driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
    } // liczymy czas

    public WebDriver getDriver() {
        return driver;
    }

    public void OpenPage(String url) {
        driver.get(url);
    }

    public void quitDriver() {
        driver.quit();
    }

    public void waitUntilElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /*public WebElement findElementByName(String elementName) {
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
    }*/ //osobny spowób do wyszukiwania elementuy na stronie

    public void clickOnElement(WebElement webElement) {
        waitUntilElementIsVisible(webElement);
        webElement.click();
    } // to klika tam gdzie ma

    public void enterText(WebElement webElement, String text) {
        waitUntilElementIsVisible(webElement);
        webElement.click();
        webElement.sendKeys(Keys.BACK_SPACE);
        webElement.sendKeys(text);
    } // czyszczenie pola i uzupenienie

    public void setSelect(WebElement webElement, String value) {
        waitUntilElementIsVisible(webElement);
        Select select = new Select(webElement);
        select.selectByValue(value);
    }// metoda do wybierania elementu z listy

    public String getText(WebElement webElement) {
        waitUntilElementIsVisible(webElement);
        return webElement.getText(); // pobieranie tekstu. na przykład podczas srawdzania uzupełnionegi adresu
    }

    public void pressEnter() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER);
        actions.perform();
    }// wciska enter np w wyszukiwarce

    public void takeScreenshot(String fileName) throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileName);
        FileUtils.copyFile(SrcFile, DestFile);
    } // screenshot

    public WebElement getParent(WebElement webElement) {
        return   (WebElement)((JavascriptExecutor) driver).executeScript(
                "return arguments[0].parentNode;", webElement);
    }// zwraca element wyżej w hierarchi strony
}