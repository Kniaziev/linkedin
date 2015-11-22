package com.linkedin;

import org.openqa.selenium.WebDriver;

public class ProfilePage /*extends AbstractPage*/ {
    protected WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    public ProfilePage profilePage;
    public void close() {
        driver.quit();
    }
}
