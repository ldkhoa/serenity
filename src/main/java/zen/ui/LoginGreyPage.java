package zen.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://staging3.intgdc.com/gdc/account/login")
public class LoginGreyPage extends PageObject {

    @FindBy(name = "USER")
    private WebElement emailInput;

    @FindBy(name = "PASSWORD")
    private WebElement passwordInput;

    @FindBy(name = "submit")
    private WebElementFacade signInButton;

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickSignInButton() {
        signInButton.waitUntilVisible().click();
    }
}
