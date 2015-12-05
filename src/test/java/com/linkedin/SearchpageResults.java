package com.linkedin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Administrator on 12/5/2015.
 */
public class SearchpageResults extends AbstractPage {
    protected WebDriver driver;

    public SearchpageResults(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@id='results-container']//li/a[contains(@href, 'www.linkedin.com/profile')]")
    private List<WebElement> searchLinks;



    public HrProfilePages openHrProfilePage(){
            System.out.println(searchLinks.size());
            for (int i = 0; i<searchLinks.size(); i++)
            {
                searchLinks.get(i).click();

            }
       return PageFactory.initElements(driver, HrProfilePages.class);
       }

    }
