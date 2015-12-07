package com.linkedin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class SearchpageResults extends AbstractPage {

    protected WebDriver driver;


    public SearchpageResults(WebDriver driver) {
        this.driver = driver;
    }
    static ArrayList<String> linkList;
     // @FindBy(xpath = "//div[@id='results-container']//li/a[contains(@href, 'www.linkedin.com/profile')]")
      //private List<WebElement> searchLinks;

   // [contains(@href, 'www.linkedin.com/profile')]

          public void openHrProfilePage() {

              List<String> hrefs = new ArrayList<String>();
              List<WebElement> anchors = driver.findElements(By.xpath("//div[@id='results-container']//li/a[contains(@href, 'www.linkedin.com/profile')]"));
                      for ( WebElement anchor : anchors ) {
                   hrefs.add(anchor.getAttribute("href")); }
               for ( String href : hrefs ) { driver.get(href); }




              /*linkList = new ArrayList<String>();
               for(WebElement searchLinks: driver.findElements(By.xpath("//div[@id='results-container']//li/a[contains(@href, 'www.linkedin.com/profile')]"))){
              {
                  String curlink = searchLinks.getAttribute("href");
                  linkList.add(curlink);
                   }
               for(String curlink: linkList)
              {
                  driver.get(curlink);

                  //System.out.println(curlink);*/
              }

              }





/*
* linkList = new ArrayList<String>();
* for(WebElement aTag: driver.findElements(By.xpath("//div[@id='results-container']//li/a")){
* String curlink = aTag.getAttribute("href");
* linkList.add(curlink);
* }
* for(String curlink: linkList)
			{
			driver.get(curlink);
			}
* */





    /*List<String> hrefs = new ArrayList<String>();
    List<WebElement> anchors = driver.findElements(By.xpath("//div[@id='results-container']//li/a"));
for ( WebElement anchor : anchors ) {
        hrefs.add(anchor.getAttribute("href"));
        }
        for ( String href : hrefs ) {
        driver.get(href);
        }
        return PageFactory.initElements(driver, HrProfilePages.class);*/



/*
HashMap results = rest.getResponse().jsonPath().get("result");
        Set result_ids = results.keySet();
        Iterator iterator = result_ids.iterator();
        while (iterator.hasNext()) {
            String endPath = productsPath + "/" + iterator.next() + "?ext=persons";
            rest.when_get(endPath);
            ArrayList<String> nicknames = rest.getResponse().jsonPath().get("result.prod_entity.person_nickname");
            assertThat(nicknames, hasItem(personName));

        }
* */

/**
 * List<String> hrefs = new ArrayList<String>();
 * List<WebElement> anchors = driver.findElements(By.xpath(""//div[@id='results-container']//li/a[contains(@href, 'www.linkedin.com/profile')]""));
 * for ( WebElement anchor : anchors ) {
 *  hrefs.add(anchor.getAttribute("href")); }
 *  for ( String href : hrefs ) { driver.get(href); }
 *
 */


