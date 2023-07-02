package zadania.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import zadania.WebDriverWrapper.WebDriverWrapper;

public class CartPage {
    private final WebDriverWrapper webDriverWrapper;

    private static final String ProceedToCheckoutBtnClass = "cart-content-btn";
    @FindBy(className = ProceedToCheckoutBtnClass)
    private WebElement proceedToCheckoutBtn;
    private static final String ProceedToCheckoutBtnClass2 = "js-cart-detailed-actions";
    @FindBy(className = ProceedToCheckoutBtnClass2)
    private WebElement proceedToCheckoutBtnSecond;
    private static final String confirmAddressBtnName = "confirm-addresses";
    @FindBy(name = confirmAddressBtnName)
    private WebElement confirmAddressBtn;

    public CartPage(WebDriverWrapper webDriverWrapper){
        this.webDriverWrapper = webDriverWrapper;
        PageFactory.initElements(this.webDriverWrapper.getDriver(), this);
    }
    public CartPage clickProceedToCheckout() {
        webDriverWrapper.clickOnElement(proceedToCheckoutBtn);
        webDriverWrapper.clickOnElement(proceedToCheckoutBtnSecond);
        return this;
    }
    public CartPage clickConfirmAddress() {
        webDriverWrapper.clickOnElement(confirmAddressBtn);
        return this;
    }
}
