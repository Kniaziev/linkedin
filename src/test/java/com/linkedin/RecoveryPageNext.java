package com.linkedin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecoveryPageNext /*extends AbstractPage*/ {

    protected WebDriver driver;

    public RecoveryPageNext(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@class = 'go-provider btn-primary btn-full-width']")
    private WebElement checkMailButton;

   /* public Gmail openGmail() {
        checkMailButton.click();
        return PageFactory.initElements(driver, Gmail.class);}
        */

        public Gmail openGmail() {
            driver.get("www.gmail.com");
            return PageFactory.initElements(driver, Gmail.class);
        }
        }




