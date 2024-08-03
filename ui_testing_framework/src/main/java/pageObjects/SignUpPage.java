package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends HomePage {
    @FindBy(xpath = "//div[@id='signInModal']//div[@class='modal-footer']//button[1]")
    private WebElement closeButton;
    @FindBy(xpath = "//input[@id='sign-password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//div[@id='signInModal']//div[@class='modal-footer']//button[2]")
    private WebElement signUpButton;
    @FindBy(xpath = "//h5[@id='signInModalLabel']/following-sibling::button")
    private WebElement signUpModalCloseButton;
    @FindBy(xpath = "//h5[@id='signInModalLabel']")
    private WebElement signUpModalTitle;
    @FindBy(xpath = "//input[@id='sign-username']")
    private WebElement usernameInput;

    public String getSignUpModalTitle() {
        return getElementText(signUpModalTitle);
    }

    public SignUpPage clickSignUpModalCloseButton() {
        clickOnElement(signUpModalCloseButton);
        logger.info("Clicked on Sign Up modal close button");
        return this;
    }

    public SignUpPage clickOnSignUpButton() {
        clickOnElement(signUpButton);
        logger.info("Clicked on Sign Up button");
        alertAccept();
        return this;
    }

    public SignUpPage fillUsername(String username) {
        fillField(usernameInput, username);
        logger.info("Username filled");
        return this;
    }

    public SignUpPage fillPassword(String password) {
        fillField(passwordInput, password);
        logger.info("Password filled");
        return this;
    }
}
