package zadania.Pages;

import org.openqa.selenium.JavascriptExecutor;
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
    private static final String ConditionsToApproveClass = "custom-checkbox";
    @FindBy(className = ConditionsToApproveClass)
    private WebElement conditionsToApproveCheckBox;
    private static final String PlaceOrderBtnCss = "conditions_to_approve[terms-and-conditions]button";
    @FindBy(css = PlaceOrderBtnCss)
    private WebElement placeOrderBtn;
    private static final String confirmDeliveryOptionName = "confirmDeliveryOption";
    @FindBy(name = confirmDeliveryOptionName)
    private WebElement confirmDeliveryOptionButton;

    //checkout
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
    public CartPage clickConfirmDeliveryOptionButton() {
        webDriverWrapper.clickOnElement(confirmDeliveryOptionButton);
        return this;
    }
    public CartPage selectPaymentMethod(String paymentMethod) {
        for ( WebElement paymentMethodElement : paymentOptions) {
            WebElement paymentMethodElementParent = webDriverWrapper.getParent(paymentMethodElement);
            WebElement paymentMethodElementGrantParent = webDriverWrapper.getParent(paymentMethodElementParent);
            String paymentMethodElementText = webDriverWrapper.getText(paymentMethodElementGrantParent);
            if(Objects.equals(paymentMethodElementText, paymentMethod)) {
                webDriverWrapper.clickOnElement(paymentMethodElementParent);
            }
        }
        return this;
    }
    public CartPage checkConditionsToApproveCheckBox() {
        webDriverWrapper.clickOnElement(webDriverWrapper.getParent(conditionsToApproveCheckBox));
        return this;
    }
    public CartPage clickPlaceOrderButton() {
        webDriverWrapper.clickOnElement(placeOrderBtn);
        return this;
    }
}
