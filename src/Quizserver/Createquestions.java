package Quizserver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Basicfunctionalities.Basic;

public class Createquestions {
    
   public static void Coding(WebDriver driver,String url, String Tittle){
        
      driver.get(url);
      Basic.clickButton(driver, "//button[@class=\"btn-thm under-tooltip mr-4\"]", Duration.ofSeconds(5));
      Basic.sendKeys(driver, "//input[@id=\"txtQuesTitle\"]",  Duration.ofSeconds(5), Tittle);
      WebElement quesele = driver.findElement(By.xpath("//select[@id='type']"));
      Select questype = new Select(quesele);
      questype.selectByVisibleText("Coding");
      Actions actions = new Actions(driver);
      actions.moveToElement(driver.findElement(By.xpath("//div[@id='editorQuil']//div[@class='ql-editor ql-blank']")))
              .click()
              .sendKeys("My Description")
              .sendKeys(Keys.ENTER)
              .sendKeys("line 2")
              .perform();
      WebElement dropdown = driver.findElement(By.xpath("//select[@id='progLang']"));
      Select select = new Select(dropdown);
      select.selectByVisibleText("C++");
      select.selectByVisibleText("Java");

      Basic.clickButton(driver, "//button[@id=\"saveBtn\"]", Duration.ofSeconds(5));

   }
   
   public static void MCQ(WebDriver driver, String Tittle){
    
   }

   public static void MQ(WebDriver driver, String Tittle){
    
   }

   public static void Web(WebDriver driver, String Tittle){
    
   }
   
   public static void Subjective(WebDriver driver, String Tittle){
    
   }

}
