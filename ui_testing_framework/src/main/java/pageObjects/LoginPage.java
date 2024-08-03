package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HomePage {
    @FindBy(xpath = "/html/body/div[3]/div/div/div[1]/button")
    private WebElement closeButton;
    @FindBy(xpath = "//h5[@id='logInModalLabel']/following-sibling::button")
    private WebElement logInModalCloseButton;
    @FindBy(xpath = "//h5[@id='logInModalLabel']")
    private WebElement logInModalTitle;
    @FindBy(xpath = "//input[@id='loginpassword']")
    private WebElement passwordInput;
    @FindBy(xpath = "//div[@id='logInModal']//div[@class='modal-footer']//button[2]")
    private WebElement signInButton;
    @FindBy(xpath = "//input[@id='loginusername']")
    private WebElement usernameInput;

    public String getLogInModalTitle() {
        return getElementText(logInModalTitle);
    }

    public LoginPage clickLogINModalCloseButton() {
        clickOnElement(logInModalCloseButton);
        logger.info("Clicked on Sign Up modal close button");
        return this;
    }

    public HomePage clickOnSignInButton() {
        clickOnElement(signInButton);
        logger.info("Clicked on Sign Up button");
        return new HomePage();
    }

    public LoginPage fillUsername(String username) {
        fillField(usernameInput, username);
        logger.info("Username filled");
        return this;
    }

    public LoginPage fillPassword(String password) {
        fillField(passwordInput, password);
        logger.info("Password filled");
        return this;
    }
}
