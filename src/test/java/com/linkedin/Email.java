package com.linkedin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import static org.openqa.selenium.support.PageFactory.initElements;
public class Email extends AbstractPage{
    protected static WebDriver driver;
    String Searchquery = "TestAutomation, here's the link to reset your password";
    public Email(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@aria-label='Search']" )
    private static WebElement gmailSearchInput;

    @FindBy(xpath = "//*[@aria-label='Search Gmail']" )
    private static WebElement gmailSearch;

    /*@FindBy(xpath = "//a[startsWith(), 'https://www.linkedin.com']")
    private static WebElement recoveryMail;*/

    @FindBys({@FindBy(css = ".CP table tbody"), @FindBy(tagName = "tr")})
    private static WebElement mailBody;

   /* public void getEmail(){
        gmail.driver.findElement(By.cssSelector(".Cp table tbody")).findElements(By.tagName("tr")).get(0).click();

    }*/







   // ClickAt|  //div[text()='TestAutomation, here's the link to reset your password']

    //#:3k>b

            //.//*[@id=':3k']/b/text()
}
