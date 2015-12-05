package com.linkedin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Administrator on 12/5/2015.
 */
public class HrProfilePages extends AbstractPage {
    protected WebDriver driver;
    SearchpageResults searchpageResults;

    @FindBy(xpath = "//*[@id='headline']/p[contains(text(),'HR')]")
    private WebElement hrPosition;

    public HrProfilePages(WebDriver driver) {
        this.driver = driver;

    }

    public boolean checkPosition() {
                hrPosition.isDisplayed();
        return true;
    }

    public SearchpageResults goBackToSearch() {
                driver.navigate().back();
        return PageFactory.initElements(driver, SearchpageResults.class);
            }
}


