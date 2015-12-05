package com.linkedin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Kasha on 05.12.2015.
 */
public class TestIteration {

        public static void main(String[] args) {

            WebDriver driver = new FirefoxDriver();

            java.util.List<WebElement> links = driver.findElements(By.xpath("//div[@id='results-container']//li/a[contains(@href, 'www.linkedin.com/profile')])"));

            System.out.println(links.size());

            for (int i = 1; i<=links.size(); i=i+1)

            {

                System.out.println(links.get(i).getText());

            }

        }

    }

