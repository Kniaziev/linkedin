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

      @FindBy(xpath = "//div[@id='results-container']//li")
      private List<WebElement> searchLinks;

   // [contains(@href, 'www.linkedin.com/profile')]

           public  HrProfilePages openHrProfilePage(){


               List<String> hrefs = new ArrayList<String>();
               List<WebElement> anchors = driver.findElements(By.tagName("a"));
               for ( WebElement anchor : anchors ) { hrefs.add(anchor.getAttribute("href"));
               } for ( String href : hrefs ) { driver.get(href); }

               return PageFactory.initElements(driver, HrProfilePages.class);
                   }



    // for(int i =0 ; i<searchLinks.size();i++){
               //    searchLinks.get(i).click();
             //  }
         //  for (int i = 0; i < searchLinks.size(); i++){
                //   searchLinks.get(i).click();}

   }

/*
    String ofLinks[] = new String[searchLinks.size()];
for (int i = 0; i < searchLinks.size(); i++){
              ofLinks[i] = allLinks.get(i).getText();
        }
                for (int i = 0; i < searchLinks.size(); i++){
        if (ofLinks[i] != null){
        driver.findElement(By.LinkText(ofLinks[i])).click();
        }


  /*  public HrProfilePages openHrProfilePage() {
        java.util.List<WebElement> links = driver.findElements(By.xpath("//div[@id='results-container']//li/a[contains(@href, 'www.linkedin.com/profile')]"));

        System.out.println(links.size());

        for (int i = 1; i <= links.size(); i = i + 1)

        {
            System.out.println(links.get(i).getText());
        }
        return PageFactory.initElements(driver, HrProfilePages.class);
    }
}*/


