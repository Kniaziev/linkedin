package com.linkedin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Kasha on 20.11.2015.
 */
public class RecoveryPage /*extends AbstractPage*/{
    protected WebDriver driver;

    public RecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "email-requestPasswordReset")
    private WebElement reqestPass;

    @FindBy(id = "request")
    private WebElement continueButton;

       public RecoveryPageNext openRecoveryPageNext(){
       String userEmail = "testautomation.acc@gmail.com";
           try {
               Thread.sleep(5000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           reqestPass.sendKeys(userEmail);
           continueButton.click();
           return PageFactory.initElements(driver, RecoveryPageNext.class);
    }

    public void open() {
        driver.get("https://www.linkedin.com/");
        PageFactory.initElements(driver, RecoveryPage.class);
    }

    public boolean isRecoveryPageLoaded(){
        if (driver.getTitle().contentEquals("Password Change | LinkedIn")) {
            return true;
        }
        return false;
    }


}
