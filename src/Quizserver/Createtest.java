package Quizserver;
import java.time.Duration;
import Basicfunctionalities.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class Createtest {

   public static void create(WebDriver driver,String testname, Integer duration) throws InterruptedException
   {
        driver.get("https://cqtestga.com/test/dashboard");
        Basic.clickButton(driver,"//a[contains(text(),'Tests')]" ,  Duration.ofSeconds(20));
        
        //  if(driver.getCurrentUrl().equals("https://assess.supercoders.tech/test/dashboard")) 
        // {  
        //     Basic.clickButton(driver,"//a[contains(text(),'Tests')]" ,  Duration.ofSeconds(20));
        // }
        // else{
        //     System.out.println("not in test server");
        // }

        Basic.clickButton(driver,"//button[@class=\"btn btn-theme under-tooltip\"]" ,  Duration.ofSeconds(10));
        Basic.sendKeys(driver, "//input[@id='newQuizTitle']",   Duration.ofSeconds(10), testname);
        Basic.clickButton(driver, "//a[contains(text(),'Create')]", Duration.ofSeconds(10));

        Basic.sendKeys(driver, "//input[@id='quizTime']",   Duration.ofSeconds(10), String.valueOf(duration));
        
        Basic.clickButton(driver, "//body/form[@id='quizForm']/div[2]/button[1]", Duration.ofSeconds(10));
        Basic.sendKeys(driver, "//input[@id='quizCode']", Duration.ofSeconds(10), "123");
        Basic.clickButton(driver,  "//body/form[@id='quizForm']/div[2]/button[2]", Duration.ofSeconds(10));
        Basic.clickButton(driver,  "//div[@id='change-tab-4']", Duration.ofSeconds(10));
        // Basic.clickButton(driver,  "//label[.//input[@id=\"isAppOnly\"]]", Duration.ofSeconds(10));
        Basic.clickButton(driver,  "//label[.//input[@id=\"revisitAllowed\"]]", Duration.ofSeconds(10));
        Basic.clickButton(driver,  "//body/form[@id='quizForm']/div[2]/button[4]", Duration.ofSeconds(10));
        // System.out.println(driver.getCurrentUrl());
        Basic.clickButton(driver,  "//body/form[@id='quizForm']/div[2]/button[5]", Duration.ofSeconds(10));
        System.out.println("Test created");
        
       
    }
    
   public static void selectdate(WebDriver driver, String url) throws InterruptedException{
      
      driver.get(url);
      Basic.clickButton(driver,"//div[@id='change-tab-2']", Duration.ofSeconds(10));
      WebElement element = driver.findElement(By.xpath("//input[@id='quizStartDate']"));
      Actions actions = new Actions(driver);
      actions.moveToElement(element)
      .doubleClick()
      .click()
      .sendKeys("200012181000")
      .build().perform();
       
      Basic.clickButton(driver, "//div[@class=\"save-on-edit-btn-container d-none\"]//button", Duration.ofSeconds(10));
      Thread.sleep(500);
        if(Basic.isElementVisible(driver, "//p[@id='alert-text']",Duration.ofSeconds(10))){
              System.out.println(driver.findElement(By.xpath("//p[@id='alert-text']")).getText() );
        }
      
   }

 
} 