package com.linkedin;

import com.thoughtworks.selenium.webdriven.commands.ClickAt;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;
public class Email extends AbstractPage{
    protected WebDriver driver;
    String Searchquery = "TestAutomation, here's the link to reset your password";
    public Email(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@aria-label='Search']" )
    private static WebElement gmailSearchInput;

    @FindBy(xpath = "//*[@aria-label='Search Gmail']" )
    private static WebElement gmailSearch;

    @FindBy(xpath = "//a[startsWith(), 'https://www.linkedin.com']")
    private static WebElement recoveryMail;

    //"//a[contains(text(),'Profile')]")

   /* public Email gmailSearch(String Searchquery){
        gmailSearchInput.sendKeys(Searchquery);
        gmailSearch.click();

    }*/



   // ClickAt|  //div[text()='TestAutomation, here's the link to reset your password']

    //#:3k>b

            //.//*[@id=':3k']/b/text()
}
