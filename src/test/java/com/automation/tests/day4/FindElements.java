package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElements {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        Thread .sleep(3000);
       List<WebElement> links = driver.findElements(By.tagName("a"));
       for(WebElement link: links){
           System.out.println(link.getText());
           System.out.println(link.getAttribute("href"));
           System.out.println();
           for(int x=1;x<links.size();x++){
               links.get(x).click();
               driver.navigate().back();
               links= driver.findElements(By.tagName("a"));
           }

           driver.quit();
       }
    }
}
