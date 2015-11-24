package com.linkedin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class Gmail extends AbstractPage{
    protected WebDriver driver;
    public Gmail(WebDriver driver) {
        this.driver = driver;
    }

        @FindBy(id = "Email" )
        private static WebElement gmailLoginInput;

        @FindBy(id = "next" )
        private static WebElement nextButton;

        @FindBy(id = "Passwd" )
        private static WebElement gmailPassInput;

        @FindBy(id = "signIn" )
        private static WebElement gmailSign;

    public Email gmailLogin(String userEmail, String userPassword){
        gmailLoginInput.sendKeys(userEmail);
        nextButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gmailPassInput.sendKeys(userPassword);
        gmailSign.click();
        return initElements(driver, Email.class);

    }

}


