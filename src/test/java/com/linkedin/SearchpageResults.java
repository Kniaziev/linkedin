package com.linkedin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchpageResults extends AbstractPage {

    protected WebDriver driver;


    public SearchpageResults(WebDriver driver) {
        this.driver = driver;
    }

      @FindBy(xpath = "//div[@id='results-container']//li/a[contains(@href, 'www.linkedin.com/profile')]")
      private List<WebElement> searchLinks;

   // [contains(@href, 'www.linkedin.com/profile')]

          public HrProfilePages openHrProfilePage() {
              List<String> hrefs = new ArrayList<String>();
              List<WebElement> anchors = driver.findElements(By.xpath("//div[@id='results-container']//li/a"));
              for ( WebElement anchor : anchors ) { hrefs.add(anchor.getAttribute("href")); }
              for ( String href : hrefs ) { driver.get(href); }

              return PageFactory.initElements(driver, HrProfilePages.class);}}


/*
* List<String> hrefs = new ArrayList<String>();
 * List<WebElement> anchors = driver.findElements(By.tagName("a"));
 * for ( WebElement anchor : anchors ) { hrefs.add(anchor.getAttribute("href")); }
 * for ( String href : hrefs ) { driver.get(href); }
*
* */