package com.linkedin;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests {
    private LoginRegistrationPage loginRegistrationPage;
    private RecoveryPage recoveryPage;
    private RecoveryPageNext recoveryPageNext;
    private RecoveryPageNext recoveryPageNextFinal;
    private Gmail gmail;
    private HomePage homePage;
    private ProfilePage profilePage;
    String userEmail = "testautomation.acc@gmail.com";

   /* @BeforeMethod
    //public void initLoginPage(){
   //     loginRegistrationPage = PageFactory.initElements(new FirefoxDriver(), LoginRegistrationPage.class);
    }*/

   /* @AfterMethod
    public void closeBrowser(){
        homePage.close();
    }*/

    @DataProvider(name = "userLoginTestData")
    public Object[][] createdata() {
        return new Object[][] {
                new Object[] { "Testautomation123" },
                new Object[] { "1234"}};
    }

    @Test(dataProvider = "userLoginTestData")
    public void userLoginGenericTest(String userPassword) {
        loginRegistrationPage.open();
        homePage = loginRegistrationPage.loginUser(userEmail,userPassword);
        switch(userPassword) {
            case "Testautomation123":
                Assert.assertTrue(homePage.isPageLoaded());
                break;
            case "1234":
                String errorMsg = "Please correct the marked field(s) below.";
                Assert.assertEquals(loginRegistrationPage.getAlertErrorMessageText(),errorMsg,"Expected error message not found");
                Assert.assertFalse(homePage.isPageLoaded());
                break;
            default:
                break;
        }
    }

    @Test
    public void loadProfilePageTest(){
        String userPassword = "Testautomation123";
        loginRegistrationPage = PageFactory.initElements(new FirefoxDriver(), LoginRegistrationPage.class);
        loginRegistrationPage.open();
        homePage = loginRegistrationPage.loginUser(userEmail,userPassword);
        profilePage = homePage.openProfilePage();
        //Assert that profile page is loaded
        //profilePage.close();
    }

    @Test
    public void loadRecoveryPageTest(){

        loginRegistrationPage = PageFactory.initElements(new FirefoxDriver(), LoginRegistrationPage.class);
        loginRegistrationPage.open();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         //Assert.assertTrue(recoveryPage.isRecoveryPageLoaded());
        recoveryPage = loginRegistrationPage.openRecoveryPage();
        recoveryPageNext = recoveryPage.openRecoveryPageNext();
        gmail = recoveryPageNext.openGmail();
        loginRegistrationPage.close();

/* // Store the current window handle
String winHandleBefore = driver.getWindowHandle();

// Perform the click operation that opens new window

// Switch to new window opened
for(String winHandle : driver.getWindowHandles()){
    driver.switchTo().window(winHandle);
}

// Perform the actions on new window

// Close the new window, if that window no more required
driver.close();

// Switch back to original browser (first window)
driver.switchTo().window(winHandleBefore);

// Continue with original browser (first window)*/
        }
    }

