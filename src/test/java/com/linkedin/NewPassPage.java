package com.linkedin;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class NewPassPage {
    protected WebDriver driver;

    @FindBy(id = "new_password-newPassword-passwordReset")
    private WebElement newPass;

    @FindBy(id = "new_password_again-newPassword-passwordReset")
    private WebElement newPassAgain;

    @FindBy(id = "reset")
    private WebElement resetPass;

    @FindBy(xpath = "//a[contains(text(),'LinkedIn')]")
    private WebElement goHome;


    public HomePage changePass(String newUserPass){
        newPass.sendKeys(newUserPass);
        newPassAgain.sendKeys(newUserPass);
        resetPass.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        goHome.click();
        return initElements(driver, HomePage.class);

    }


}
