package com.linkedin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests {
    private LoginRegistrationPage loginRegistrationPage;
    private RecoveryPage recoveryPage;
    private RecoveryPageNext recoveryPageNext;
    private RecoveryPageNext recoveryPageNextFinal;
    private Gmail gmail;
    private Email email;
    //private HomePage homePage;
    //private ProfilePage profilePage;
    String userEmail = "testautomation.acc@gmail.com";


    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void initLoginPage(){
        loginRegistrationPage = PageFactory.initElements(new FirefoxDriver(), LoginRegistrationPage.class);
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

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
        //Assert.assertTrue(loginRegistrationPage.isPageLoaded("Test"));
        HomePage homePage = loginRegistrationPage.loginUser(userEmail,userPassword);
        switch(userPassword) {
            case "Testautomation123":
                // Assert.assertTrue(loginRegistrationPage());
               // Assert.assertTrue(homePage.isPageLoaded("Welcome! | LinkedIn"));
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

        HomePage homePage = loginRegistrationPage.loginUser(userEmail,userPassword);
        ProfilePage profilePage = homePage.openProfilePage();
        //Assert that profile page is loaded
        //profilePage.close();
    }

    @Test
    public void loadRecoveryPageTest(){
        String userPassword = "Testautomation123";
        //loginRegistrationPage = PageFactory.initElements(new FirefoxDriver(), LoginRegistrationPage.class);
        loginRegistrationPage.open();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Assert.assertTrue(recoveryPage.isPageLoaded());
        recoveryPage = loginRegistrationPage.openRecoveryPage();
        recoveryPageNext = recoveryPage.openRecoveryPageNext();
        gmail = recoveryPageNext.openGmail();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gmail.gmailLogin(userEmail,userPassword);
        gmail.driver.findElement(By.cssSelector(".Cp table tbody")).findElements(By.tagName("tr")).get(0).click();
       // Email email = gmail.gmailLogin(userEmail,userPassword);
        //gmail.getEmail();
    }
}