package zadania.CucumberTests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import zadania.Pages.ShopLoginPage;
import zadania.Pages.ShopMainPage;
import zadania.WebDriverWrapper.WebDriverWrapper;

public class ShopSteps {

    ShopLoginPage shopLoginPage;
    ShopMainPage shopMainPage;
    WebDriverWrapper webDriverWrapper;
    @Before
    public void beforeScenario(Scenario scenario){
        webDriverWrapper = new WebDriverWrapper();
        shopLoginPage = new ShopLoginPage(webDriverWrapper);
    }

    @After
    public void afterScenario(){
        webDriverWrapper.quitDriver();
    }

    @Given("user is log in {string} {string}")
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
}
