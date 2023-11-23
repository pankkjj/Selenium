package Quizserver;
import java.time.Duration;
import Basicfunctionalities.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Createtest {

   public static void create(WebDriver driver,String testname) throws InterruptedException
   {
        driver.get("http://test.cqtestga.com:3003/test/dashboard");
     
        
         if(driver.getCurrentUrl().equals("http://test.cqtestga.com:3003/test/dashboard")) 
        {  
            perform.clickButton(driver,"//a[contains(text(),'Tests')]" ,  Duration.ofSeconds(20));
        }
        else{
            System.out.println("not in test server");
        }

        perform.clickButton(driver,"//button[@class=\"btn btn-theme under-tooltip\"]" ,  Duration.ofSeconds(10));
        perform.sendKeys(driver, "//input[@id='newQuizTitle']",   Duration.ofSeconds(10), testname);
        perform.clickButton(driver, "//a[contains(text(),'Create')]", Duration.ofSeconds(10));

        perform.sendKeys(driver, "//input[@id='quizTime']",   Duration.ofSeconds(10), "50");
        
        perform.clickButton(driver, "//body/form[@id='quizForm']/div[2]/button[1]", Duration.ofSeconds(10));
        perform.sendKeys(driver, "//input[@id='quizCode']", Duration.ofSeconds(10), "123");
        perform.clickButton(driver,  "//body/form[@id='quizForm']/div[2]/button[2]", Duration.ofSeconds(10));
        perform.clickButton(driver,  "//div[@id='change-tab-4']", Duration.ofSeconds(10));
        perform.clickButton(driver,  "//label[.//input[@id=\"isAppOnly\"]]", Duration.ofSeconds(10));
        perform.clickButton(driver,  "//label[.//input[@id=\"revisitAllowed\"]]", Duration.ofSeconds(10));
        perform.clickButton(driver,  "//body/form[@id='quizForm']/div[2]/button[4]", Duration.ofSeconds(10));
        perform.clickButton(driver,  "//body/form[@id='quizForm']/div[2]/button[5]", Duration.ofSeconds(10));

        if(perform.isElementVisible(driver, "//p[@id='alert-text']",Duration.ofSeconds(10))){
              System.out.println("Test Created successfully.");
        }
        else{
            System.out.println("Can't create Test");
        }
       
    }
    
   public static void selectdate(WebDriver driver, String url) throws InterruptedException{
      
      driver.get(url);
      perform.clickButton(driver,"//div[@id='change-tab-2']", Duration.ofSeconds(10));
      perform.clickButton(driver, "//input[@id=\"quizStartDate\"]", Duration.ofSeconds(20));
      perform.clickButton(driver, "(//div[@class=\"xdsoft_label xdsoft_year\"])[2]", Duration.ofSeconds(20));
      Thread.sleep(1000);
      WebElement element= driver.findElement(By.xpath("//div[text()='2000']"));
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
      Thread.sleep(1100);
      Actions actions = new Actions(driver);
      actions.moveToElement(element).perform();
   }

 
}





	