package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import utils.Utilities;


public class SingInNegativeTest extends BaseTest {
    public String password = Utilities.generatePassword();
    public String username = Utilities.generateUsername();

    @Test
    @Epic("Web interface")
    @Feature("Essential features")
    @Story("Authentication")
    void logOutTest() {
        homePage
                .clickOnSignUpButton()
                .fillUsername(username)
                .fillPassword(password)
                .clickOnSignUpButton()
                .clickOnLogInButton()
                .fillUsername(username)
                .fillPassword(password)
                .clickOnSignInButton()
                .clickOnLogOutButton();
        mainTestData
                .setUsername(username)
                .setPassword(password);

        softAssert.assertFalse(homePage.getUsernameTitle().contains(username));
        softAssert.assertAll();
    }

    @Test
    void signUpPositiveTest() {
        homePage
                .clickOnSignUpButton()
                .fillUsername(username)
                .fillPassword(password)
                .clickOnSignUpButton()
                .clickOnLogInButton()
                .fillUsername(username)
                .fillPassword(password)
                .clickOnSignInButton();
        mainTestData
                .setUsername(username)
                .setPassword(password);

        softAssert.assertTrue(homePage.getUsernameTitle().contains(username));
        softAssert.assertAll();
    }
}
