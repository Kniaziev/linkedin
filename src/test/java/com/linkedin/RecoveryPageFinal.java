/* package com.linkedin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RecoveryPageFinal {
    protected WebDriver driver;

    public RecoveryPageFinal(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@class = 'go-provider btn-primary btn-full-width']")
    private WebElement checkMailButton;

    public Gmail openGmail(){
        checkMailButton.click();
        return PageFactory.initElements(driver, Gmail.class);

        }
    }
*/

