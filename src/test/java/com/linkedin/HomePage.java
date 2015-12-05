package com.linkedin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.PageFactory.initElements;

public class HomePage extends AbstractPage{
    protected WebDriver driver;
//nado update page object chtobi nasledovalo ot Abstrakta.

    public HomePage (WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[contains(text(),'Profile')]")
    private WebElement profileMenuLink;

    @FindBy(id = "main-search-box")
    private WebElement searchBox;

    @FindBy(xpath = "//*[@id='global-search']/fieldset/button")
    private WebElement searchButton;

    public ProfilePage openProfilePage(){
        profileMenuLink.click();
        return PageFactory.initElements(driver, ProfilePage.class);
    }

   public boolean isPageLoaded(){
             if (driver.getTitle().contentEquals("Welcome! | LinkedIn")) {
            return true;
        }
        return false;
    }
    public SearchpageResults SearchForHr(){
        searchBox.sendKeys("HR");
        searchButton.click();
        return initElements(driver, SearchpageResults.class);
    }
}
