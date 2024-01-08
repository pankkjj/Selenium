package Quizserver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import Basicfunctionalities.Basic;

import org.openqa.selenium.interactions.Actions;

public class Addkeyword {
      
    public static void add(WebDriver driver,String url) throws InterruptedException{
        
        driver.get(url);
        if(Basic.isElementVisible(driver, "//input[@class='form-control tag-editor-hidden-src']",  Duration.ofSeconds(5)))
        {
           
           Actions action=new Actions(driver);
           action.moveToElement(driver.findElement(By.xpath( "//ul[@class='tag-editor ui-sortable']")))
               .click()
               .sendKeys("key")
               .keyDown(Keys.ENTER)
               .build().perform();

             

        }
         
      
    }


}
