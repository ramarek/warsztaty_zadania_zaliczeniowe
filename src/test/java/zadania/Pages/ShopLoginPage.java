package zadania.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import zadania.WebDriverWrapper.WebDriverWrapper;


public class ShopLoginPage {
    private static String url = "https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=addresses";
    private final WebDriverWrapper webDriverWrapper;
    private static final String LoginFiledId = "field-email";
    @FindBy(id = LoginFiledId)
    private WebElement loginField;
    private static final String PasswordFiledId = "field-password";
    @FindBy(id = PasswordFiledId)
    private WebElement passwordField;
    private static final String LoginButtonId = "submit-login";
    @FindBy(id =LoginButtonId)
    private WebElement loginButton;

    public ShopLoginPage(WebDriverWrapper webDriverWrapper){
        this.webDriverWrapper = webDriverWrapper;
        PageFactory.initElements(this.webDriverWrapper.getDriver(), this);
    }
    public ShopLoginPage OpenPage() {
        webDriverWrapper.OpenPage(url);
        return this;
    }

    public ShopMainPage LogIn(String login, String password){
        webDriverWrapper.enterText(loginField,login);
        webDriverWrapper.enterText(passwordField,password);
        webDriverWrapper.clickOnElement(loginButton);

        return new ShopMainPage(webDriverWrapper);
    }
}
// email:dapik41292@extemer.com
// password:Test123!