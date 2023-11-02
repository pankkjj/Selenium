package Addquestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Basicfunctionalities.Actions;

public class Bykeywords {
    
    public static void Addquestions(WebDriver driver, String id, String keyword) throws InterruptedException{
         
        driver.get("https://test.cqtestga.com/test/addQuizContent/"+id);
        Actions.clickButton(driver,  "//a[contains(text(),'+ create new section')]", Duration.ofSeconds(10));
        Thread.sleep(2000);
            
     
        String alertmsg=driver.findElement(By.xpath("//p[@id='alert-text']")).getText();
        
        if(alertmsg.equals("New section created.")){
                System.out.println(alertmsg);
        }
        else{
            System.out.println("Failed to create section");
            driver.close();
            return;
        }
         
        Actions.clickButton(driver,  "//a[(@class=\"btn ml-3 add-btn-new add-content-link\")]", Duration.ofSeconds(10));
        Actions.clickButton(driver, "//input[@class=\"filter-input\"]", Duration.ofSeconds(10));
        Actions.clickButton(driver, "//li[normalize-space()=\"Keyword\"]", Duration.ofSeconds(10));
        // Actions.sendKeys(driver, "//input[@class=\"searchTags\"]", Duration.ofSeconds(10), keyword);
        Actions.clickButton(driver, "//label[@title="+ keyword +" ]", Duration.ofSeconds(10));
        Actions.clickButton(driver, "//button[@class=\"btn apply-btn keyword-apply-btn\" ]", Duration.ofSeconds(10));
    }

}
