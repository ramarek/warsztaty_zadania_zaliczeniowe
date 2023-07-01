package zadania.CucumberTests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import zadania.Pages.ShopLoginPage;
import zadania.WebDriverWrapper.WebDriverWrapper;

public class ShopSteps {

    ShopLoginPage shopLoginPage;
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
        shopLoginPage.OpenPage().LogIn(login, password);
     }
}
