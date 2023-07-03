package zadania.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import zadania.WebDriverWrapper.WebDriverWrapper;

import java.util.List;
import java.util.Objects;

public class CartPage {
    private final WebDriverWrapper webDriverWrapper;

    private static final String ProceedToCheckoutBtnClass = "cart-content-btn";
    @FindBy(className = ProceedToCheckoutBtnClass)
    private WebElement proceedToCheckoutBtn;
    private static final String ProceedToCheckoutBtnClass2 = "js-cart-detailed-actions";
    @FindBy(className = ProceedToCheckoutBtnClass2)
    private WebElement proceedToCheckoutBtnSecond;
    private static final String ConfirmAddressName = "confirm-addresses";
    @FindBy(name = ConfirmAddressName)
    private WebElement confirmAddressBtn;
    private static final String carrierDelayClass = "carrier-delay";
    @FindBy(className = carrierDelayClass)
    private List<WebElement> shippingMethods;
    private static final String PaymentOptionName = "payment-option";
    @FindBy(name = PaymentOptionName)
    private List<WebElement> paymentOptions;
    private static final String ConditionsToApproveId = "conditions_to_approve[terms-and-conditions]";
    @FindBy(name = ConditionsToApproveId)
    private WebElement conditionsToApproveCheckBox;
    private static final String PlaceOrderBtnCss = "conditions_to_approve[terms-and-conditions]button";
    @FindBy(css = PlaceOrderBtnCss)
    private WebElement placeOrderBtn;

    //btn-primary
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
    public CartPage selectShippingMethod(String shippingMethod) {
        for ( WebElement shippingMethodElement : shippingMethods) {
            if(Objects.equals(webDriverWrapper.getText(shippingMethodElement), shippingMethod)) {
                webDriverWrapper.clickOnElement(shippingMethodElement);
            }
        }
        return this;
    }
    public CartPage selectPaymentMethod(String paymentMethod) {
        for ( WebElement paymentMethodElement : paymentOptions) {
            if(Objects.equals(webDriverWrapper.getText(paymentMethodElement), paymentMethod)) {
                webDriverWrapper.clickOnElement(paymentMethodElement);
            }
        }
        return this;
    }
    public CartPage checkConditionsToApproveCheckBox() {
        webDriverWrapper.clickOnElement(conditionsToApproveCheckBox);
        return this;
    }
    public CartPage clickPlaceOrderButton() {
        webDriverWrapper.clickOnElement(placeOrderBtn);
        return this;
    }
}
