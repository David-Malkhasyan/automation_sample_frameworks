package tests;

import org.testng.annotations.Test;
import utils.Utilities;


public class SignUpTest extends BaseTest {
    public String password = Utilities.generatePassword();
    public String username = Utilities.generateUsername();

    @Test
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

        softAssert.assertFalse(homePage.getUsernameTitle().contains("yugyugyugu"));
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

    @Test
    void logInTest() {
        homePage
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
}
