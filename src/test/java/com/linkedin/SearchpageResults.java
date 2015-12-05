package com.linkedin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * Created by Administrator on 12/5/2015.
 */
public class SearchpageResults extends AbstractPage {
    protected WebDriver driver;
    public SearchpageResults (WebDriver driver) {
        this.driver = driver;
    }

       public static HrProfilePages findAllLinks() {
           WebDriver driver = new FirefoxDriver();

           java.util.List<WebElement> links = driver.findElements(By.xpath("//div[@id='results-container']//li/a[contains(@href, 'www.linkedin.com/profile')]"));

           System.out.println(links.size());

           for (int i = 1; i <= links.size(); i = i + 1){
               return links.as
               driver.navigate(i);
           }
           return initElements(driver, HrProfilePages.class);
}
}
//http://stackoverflow.com/questions/13448091/how-to-fetch-all-links-and-click-those-links-one-by-one-using-selenium-webdriver
