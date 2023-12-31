package zadania.CucumberTests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import zadania.Pages.CartPage;
import zadania.Pages.ProductPage;
import zadania.Pages.ShopLoginPage;
import zadania.Pages.ShopMainPage;
import zadania.WebDriverWrapper.WebDriverWrapper;

import java.io.IOException;

public class ShopSteps {

    ShopLoginPage shopLoginPage;
    ShopMainPage shopMainPage;
    ProductPage productPage;
    CartPage cartPage;
    WebDriverWrapper webDriverWrapper;
    @Before
    public void beforeScenario(Scenario scenario){
        webDriverWrapper = WebDriverWrapper.getInstance();
        shopLoginPage = new ShopLoginPage(webDriverWrapper);
    }

    @After
    public void afterScenario(){
        webDriverWrapper.quitDriver();
    }

    @Given("User is log in {string} {string}")
    public void LogIn(String login, String password) {
        shopMainPage = shopLoginPage.OpenPage().LogIn(login, password);
    }
    @Given("Add new Address is clicked")
    public void ClickAddNewAddress() {
        shopMainPage.clickAddFirstAddress();
    }
    @When("New Address is added {string} {string} {string} {string} {string} {string}")
    public void AddNewAddress(String alias, String address, String city, String postalCode, String country, String phone) {
        shopMainPage.setAddress(alias,address,city,postalCode,country,phone);
    }

    @Then("Check if address is correct {string} {string} {string} {string} {string} {string}")
    public void CheckAddress(String alias, String address, String city, String postalCode, String country, String phone) {
        shopMainPage.assertAddress(alias,address,city,postalCode,country,phone);
    } // ostatni krok pierwszego zadania
    @When("User searches for product {string}")
    public void searchForProduct(String productName) {
        productPage = shopMainPage.searchForProduct(productName);
    }
    @Then("Product page is opened {string}")
    public void productPageIsOpened(String productName) {
        productPage.checkIfPageIsOpened(productName);
    }
    @When("User sets product size {string}")
    public void setProductSize(String productSize) {
        productPage.setProductSize(productSize);
    }
    @When("User sets product quantity {string}")
    public void setProductQuantity(String productQuantity) {
        productPage.setProductQuantity(productQuantity);
    }
    @When("User clicks add to cart")
    public void clickAddToCart() {
        cartPage = productPage.clickAddToCart();
    }
    @When("User clicks Proceed to checkout")
    public void clickProceedToCheckout() {
        cartPage.clickProceedToCheckout();
    }
    @When("User clicks Confirm Address")
    public void clickConfirmAddress() {
        cartPage.clickConfirmAddress();
    }
    @When("User selects shipping method {string}")
    public void selectShippingMethods(String shippingMethod) {
        cartPage.selectShippingMethod(shippingMethod);
    }
    @When("User clicks continue")
    public void clickConfirmDeliveryOptionButton() {
        cartPage.clickConfirmDeliveryOptionButton();
    }
    @When("User selects payment method {string}")
    public void selectPaymentMethods(String paymentMethod) {
        cartPage.selectPaymentMethod(paymentMethod);
    }
    @When("User checks conditions to approve")
    public void checkConditionsToApproveCheckBox() {
        cartPage.checkConditionsToApproveCheckBox();
    }
    @When("User clicks place order button")
    public void clickPlaceOrderButton() {
        cartPage.clickPlaceOrderButton();
    }

    @Then("Take Screenshot {string}")
    public void takeScreenshot(String fileName) throws IOException {
        webDriverWrapper.takeScreenshot(fileName);
    }   //ostatni krok  drógiego zadania

}
