package com.linkedin;

import com.jayway.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.get;
import static org.testng.Assert.assertEquals;

public class LoginTests {
    private LoginRegistrationPage loginRegistrationPage;
    private RecoveryPage recoveryPage;
    private RecoveryPageNext recoveryPageNext;
    private RecoveryPageNext recoveryPageNextFinal;
    private Gmail gmail;
    private Email email;
    private NewPassPage newPassPage;
    private HomePage homePage;
    //private ProfilePage profilePage;
    String userEmail = "testautomation.acc@gmail.com";
    String newUserPass = "Automation123";


    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

   // @BeforeMethod
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
               Assert.assertTrue(homePage.isPageLoaded("Welcome! | LinkedIn"));
                break;
            case "1234":
                String errorMsg = "Please correct the marked field(s) below.";
                assertEquals(loginRegistrationPage.getAlertErrorMessageText(),errorMsg,"Expected error message not found");
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
        //String searchQuery = "security-noreply@linkedin.com";
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
        email = gmail.gmailLogin(userEmail,userPassword);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //email = gmail.gmailLogin(userEmail,userPassword);
        //email.driver.findElement(By.cssSelector(".Cp table tbody")).findElements(By.tagName("tr")).get(0).click();
        //email = gmail.gmailLogin(userEmail,userPassword);
        email.getEmail();
        //email.searchMail(searchQuery);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // email.searchMail(searchQuery);
        newPassPage = email.getNewPass();
        //email.getNewPass();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage = newPassPage.changePass(newUserPass);
        loginRegistrationPage.close();
        loginRegistrationPage = PageFactory.initElements(new FirefoxDriver(), LoginRegistrationPage.class);
        loginRegistrationPage.open();
        HomePage homePage = loginRegistrationPage.loginUser(userEmail,newUserPass);
        //homePage = loginRegistrationPage.loginUser(userEmail,newUserPass);
        Assert.assertTrue(homePage.isPageLoaded());

    }


   /* @Test
    public void testGetSingleUser() {
        expect().
                statusCode(200).
                body(
                        "title", equalTo("Verify successfull user login")
                ).
                when().
                get("https://okniaziev.testrail.net/index.php?/api/v2/get_case/1");
    }*/
   @Test
   public void testAdd(){
       // Get status code
       Response response = get("/index.php?/api/v2/get_case/1https://okniaziev.testrail.net");
    int statusCode = response.getStatusCode();
       assertEquals(statusCode,200);
   }

    /*@Test
    public void andad(){
        //Response response = get("https://okniaziev.testrail.net/index.php?/api/v2/get_case/1");;
        //int statusCode = response.getStatusCode();
        Response response = get("https://okniaziev.testrail.net/index.php?/api/v2/get_case/1");
        response.then().assertThat().statusCode(200);
    }*/


   /* @Test
    public void testAdd() throws IOException {

        URL url = new URL("https://okniaziev.testrail.net/");
        URLConnection connect = url.openConnection();
        Response res = (Response) get("https://okniaziev.testrail.net/index.php?/api/v2/get_case/1");
        int respCode = ((HttpURLConnection) connect).getResponseCode();
        assertEquals(respCode,200);

    }*/


    }


