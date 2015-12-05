package com.linkedin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {
    public WebDriver driver() {

        WebDriver driver = LoginTests.getDriver();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
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
