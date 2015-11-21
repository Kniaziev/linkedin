package com.linkedin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import static org.openqa.selenium.support.PageFactory.*;

public class LoginRegistrationPage /*extends AbstractPage*/ {
    protected WebDriver driver;

    public LoginRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    //Registration elements
    @FindBy(id ="first-name")
    private WebElement firstNameInput;

    @FindBy(id ="last-name")
    private WebElement lastNameInput;

    @FindBy(id ="join-email")
    private WebElement emailInput;

    @FindBy(id ="join-password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement joinButton;

    //Login elements:
    @FindBy(id = "login-email")
    private WebElement loginEmailInput;

    @FindBy(id = "login-password")
    private WebElement loginPasswordInput;

    @FindBy(xpath = "//input[@name='submit']")
    private WebElement loginSubmitButton;

    @FindBy(xpath = "//div[@class='alert error']//strong")
    private WebElement alertErrorMessageBox;

    @FindBy(xpath = "//*[@class='password-wrapper']/a")
    private WebElement forgotPass;



    public String getAlertErrorMessageText(){
        return alertErrorMessageBox.getText();
    }

    public HomePage loginUser(String userEmail, String userPassword){
        loginEmailInput.sendKeys(userEmail);
        loginPasswordInput.sendKeys(userPassword);
        loginSubmitButton.click();
        return initElements(driver, HomePage.class);
    }

    public void submitRegistrationForm(String firstName, String lastName, String email, String password){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        joinButton.click();
    }


    public RecoveryPage openRecoveryPage(){
        forgotPass.click();
        return initElements(driver, RecoveryPage.class);

    }

    public void open() {
        driver.get("https://www.linkedin.com/");
        //final LoginRegistrationPage loginRegistrationPage = PageFactory.initElements(driver, LoginRegistrationPage.class);

        //PageFactory.initElements(driver, TestCase_POF.class);
        //loginRegistrationPage = PageFactory.initElements(new FirefoxDriver(), LoginRegistrationPage.class)
    }


    public void close() {
        driver.quit();
    }


    //put pagefactory into page object

   /* public LoginRegistrationPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }*/

    }