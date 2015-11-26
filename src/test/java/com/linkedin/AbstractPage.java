package com.linkedin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class AbstractPage {
    public WebDriver driver() {
        WebDriver driver = LoginTests.getDriver();
        if(driver != null) {
            return driver;
        }
        return new FirefoxDriver();
    }

   /*protected WebDriver driver;

    public AbstractPage(){
        this.driver = driver;
    }*/

   boolean isPageLoaded(String pageTitle) {
       WebDriver driver = null;
        if (driver.getTitle().contentEquals(pageTitle)) {
            return true;
        }
        return false;
    }

}
