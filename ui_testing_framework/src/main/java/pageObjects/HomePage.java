package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//div[@id='navbarExample']//li[3]")
    private WebElement aboutUsButton;
    @FindBy(xpath = "//div[@id='navbarExample']//li[4]")
    private WebElement cartButton;
    @FindBy(xpath = "//div[@id='navbarExample']//li[2]")
    private WebElement contactbutton;
    @FindBy(xpath = "//div[@id='navbarExample']//li[1]")
    private WebElement homeButton;
    @FindBy(xpath = "//div[@id='navbarExample']//li[5]")
    private WebElement logInButton;
    @FindBy(xpath = "//div[@id='navbarExample']//li[6]")
    private WebElement logOutButton;
    @FindBy(xpath = "//div[@id='navbarExample']//li[8]")
    private WebElement signUpButton;
    @FindBy(xpath = "//div[@id='navbarExample']//li[7]")
    private WebElement usernameTitle;

    public HomePage clickOnHomeButton() {
        clickOnElement(homeButton);
        logger.info("Clicked on Home button");
        return this;
    }

    public HomePage clickOnContactButton() {
        clickOnElement(homeButton);
        logger.info("Clicked on Contact button");
        return this;
    }

    public HomePage clickOnAboutUsButton() {
        clickOnElement(aboutUsButton);
        logger.info("Clicked on About Us button");
        return this;
    }

    public HomePage clickOnCartButton() {
        clickOnElement(cartButton);
        logger.info("Clicked on Home button");
        return this;
    }

    public LoginPage clickOnLogInButton() {
        clickOnElement(logInButton);
        logger.info("Clicked on Home button");
        return new LoginPage();
    }

    public SignUpPage clickOnSignUpButton() {
        clickOnElement(signUpButton);
        logger.info("Clicked on Home button");
        return new SignUpPage();
    }

    public HomePage clickOnLogOutButton() {
        clickOnElement(logOutButton);
        logger.info("Clicked on Log Out button");
        return this;
    }

    public String getUsernameTitle() {
        return getElementText(usernameTitle);
    }
}
