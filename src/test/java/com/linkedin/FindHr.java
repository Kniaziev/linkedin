package com.linkedin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.naming.directory.SearchResult;

/**
 * Created by Administrator on 12/5/2015.
 */
public class FindHr extends AbstractPage {
    protected WebDriver driver;
    private LoginRegistrationPage loginRegistrationPage;
    private SearchpageResults searchpageResults;
    private HrProfilePages hrProfilePages;
    private HomePage homePage;
    String userEmail = "knyazev.alexandr@gmail.com";
    String userPass = "4510698";

    @BeforeMethod
    public void initLoginPage(){
        loginRegistrationPage = PageFactory.initElements(new FirefoxDriver(), LoginRegistrationPage.class);
        loginRegistrationPage.open();

    }

    @Test
    public void HomePage (){
        homePage = loginRegistrationPage.loginUser(userEmail,userPass);
        searchpageResults = homePage.SearchForHr();
        hrProfilePages = searchpageResults.findAllLinks();
        hrProfilePages.checkPosition();


    }

}
