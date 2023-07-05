package zadania.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import zadania.WebDriverWrapper.WebDriverWrapper;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ShopMainPage {
    private final WebDriverWrapper webDriverWrapper;
    private static final String AddFirstAddressCss = "a[data-link-action='add-address']";
    @FindBy(css = AddFirstAddressCss)
    private WebElement addFirstAddress;
    private static final String AliasFiledId = "field-alias";
    @FindBy(id = AliasFiledId)
    private WebElement aliasField;
    private static final String AddressFiledId = "field-address1";
    @FindBy(id = AddressFiledId)
    private WebElement addressField;
    private static final String CityFiledId = "field-city";
    @FindBy(id = CityFiledId)
    private WebElement cityField;
    private static final String PostalCodeFiledId = "field-postcode";
    @FindBy(id = PostalCodeFiledId)
    private WebElement postalCodeField;
    private static final String CountryFiledId = "field-id_country";
    @FindBy(id = CountryFiledId)
    private WebElement countrySelect;
    private static final String PhoneFiledId = "field-phone";
    @FindBy(id = PhoneFiledId)
    private WebElement phoneField;
    private static final String SaveButtonClass = "form-control-submit";
    @FindBy(className = SaveButtonClass)
    private WebElement saveButton;
    private static final String UserAddressClass = "address";
    @FindBy(css = UserAddressClass)
    private WebElement userAddress;
    // zmiana adresu
    private static final String searchClass = "ui-autocomplete-input"; // wyszukiwarka
    @FindBy(className = searchClass)
    private WebElement search; // wyszukiwarka
    private static final String productsTitlesClass = "product-title"; // lista wyszukanych produktów
    @FindBy(className = productsTitlesClass)
    private List<WebElement> products; // lista wyszukanych produktów

    public ShopMainPage(WebDriverWrapper webDriverWrapper){
        this.webDriverWrapper = webDriverWrapper;
        PageFactory.initElements(this.webDriverWrapper.getDriver(), this);
    }

    public ShopMainPage clickAddFirstAddress() {
        webDriverWrapper.clickOnElement(addFirstAddress);
        return this;
    }
    public ShopMainPage setAddress(String alias, String address, String city, String postalCode, String country, String phone) {

        HashMap<String, String> countryMap = new HashMap<>();
        countryMap.put("United Kingdom","17" );

        webDriverWrapper.enterText(aliasField,alias);
        webDriverWrapper.enterText(addressField,address);
        webDriverWrapper.enterText(cityField,city);
        webDriverWrapper.enterText(postalCodeField,postalCode);
        webDriverWrapper.setSelect(countrySelect,countryMap.get(country));
        webDriverWrapper.enterText(phoneField,phone);

        webDriverWrapper.clickOnElement(saveButton);
        return this;
    }// dodanie adresu
    public ShopMainPage assertAddress(String alias, String address, String city, String postalCode, String country, String phone) {
        String addressData = webDriverWrapper.getText(userAddress);
        assert addressData.contains(alias);
        assert addressData.contains(address);
        assert addressData.contains(city);
        assert addressData.contains(postalCode);
        assert addressData.contains(country);
        assert addressData.contains(phone);

        return this;
    }// sprawdzenie poprawnści adresu


    public ProductPage searchForProduct(String productName){
        webDriverWrapper.enterText(search,productName);
        webDriverWrapper.pressEnter();
        return openProduct(productName);
    } // wyszukanie i otwarcie produktu
    public ProductPage openProduct(String productName) {
        for ( WebElement product : products)
        {
            if (Objects.equals(webDriverWrapper.getText(product), productName)) {
                webDriverWrapper.clickOnElement(product);
                return new ProductPage(webDriverWrapper);
            }
        } // wybór produktu z listy
        return null;
    }

}
