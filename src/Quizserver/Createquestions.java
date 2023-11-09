package Quizserver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import Basicfunctionalities.perform;

public class Createquestions {
    
   public static void Coding(WebDriver driver,String url, String Testname){
        
      driver.get(url);
      perform.sendKeys(driver, "//input[@id=\"txtQuesTitle\"]",  Duration.ofSeconds(5), "Myques");
      
   }
   
   public static void MCQ(WebDriver driver, String Testname){
    
   }

   public static void MQ(WebDriver driver, String Testname){
    
   }

   public static void Web(WebDriver driver, String Testname){
    
   }
   
   public static void Subjective(WebDriver driver, String Testname){
    
   }

}
