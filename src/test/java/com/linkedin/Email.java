package com.linkedin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Email extends AbstractPage{
    protected static WebDriver driver;

    String searchQuery = "security-noreply@linkedin.com";
    public Email(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@aria-label='Search']" )
    private static WebElement gmailSearchInput;

    @FindBy(xpath = "//*[@aria-label='Search Gmail']" )
    private static WebElement gmailSearch;

    public void searchMail(String Searchquery ){
        gmailSearchInput.sendKeys(Searchquery);
        gmailSearch.click();

    }
    /*@FindBy(xpath = "//a[startsWith(), 'https://www.linkedin.com']")
    private static WebElement recoveryMail;*/

   /* @FindBys({@FindBy(css = ".CP table tbody"), @FindBy(tagName = "tr")})
    private static WebElement mailBody;*/
    //@FindBy(xpath = "//*[contains(text(),'here')]")
   @FindBy(xpath = "//td/a[text()='here']")
   private static WebElement hereLink;

    public void getEmail(){
        driver.findElement(By.cssSelector(".Cp table tbody")).findElements(By.tagName("tr")).get(0).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }

    public NewPassPage getNewPass(){
        String recoveryLink = hereLink.getAttribute("href");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get(recoveryLink);
        return PageFactory.initElements(driver, NewPassPage.class);


    }

   // ClickAt|  //div[text()='TestAutomation, here's the link to reset your password']

    //#:3k>b

            //.//*[@id=':3k']/b/text()
}
