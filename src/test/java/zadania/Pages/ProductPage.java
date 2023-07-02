package zadania.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import zadania.WebDriverWrapper.WebDriverWrapper;

import java.util.HashMap;
import java.util.Objects;

public class ProductPage {

    private final WebDriverWrapper webDriverWrapper;

    private static final String ProductContainerClass = "product-container";
    @FindBy(className = ProductContainerClass)
    private WebElement productContainer;
    private static final String ProductSelectClass = "form-control-select";
    @FindBy(className = ProductSelectClass)
    private WebElement productSelect;



    public ProductPage(WebDriverWrapper webDriverWrapper){
        this.webDriverWrapper = webDriverWrapper;
        PageFactory.initElements(this.webDriverWrapper.getDriver(), this);
    }

    public ProductPage checkIsPageIsOpened(String productName) {
        assert Objects.equals(webDriverWrapper.getText(productContainer), productName.toUpperCase());
        return this;
    }
    public ProductPage setProductSize(String productSize) {
        HashMap<String, String> countryMap = new HashMap<>();
        countryMap.put("S","1");
        countryMap.put("M","2");
        countryMap.put("L","3");
        countryMap.put("XL","4");

        webDriverWrapper.setSelect(productSelect,countryMap.get(productSize));
        return this;
    }
}
