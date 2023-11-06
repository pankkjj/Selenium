package Addquestions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Basicfunctionalities.perform;

public class Codequotient {
    public static void Addquestions(WebDriver driver,String id) throws InterruptedException{
            // driver.get("https://test.cqtestga.com/test/addQuizContent/"+id);
            driver.get(id);
            perform.clickButton(driver,  "//a[contains(text(),'+ create new section')]", Duration.ofSeconds(10));
            Thread.sleep(2000);
            
     
            if(perform.isElementVisible(driver, "//div[@class='modal-alert-msg color-1 visible-alert-modal']", Duration.ofSeconds(10))) 
            {
                System.out.println(driver.findElement(By.xpath("//div[@class='modal-alert-msg color-1 visible-alert-modal']")).getText());
            }
            else{
                System.out.println("alert didn't appear");
            }

            List<WebElement>sections=driver.findElements(By.xpath("//div[@class='sections']")); 
            perform.clickButton(driver,  "(//a[@class=\"btn ml-3 add-btn-new add-content-link\"])[" + sections.size() + "]", Duration.ofSeconds(10)); 

            perform.clickButton(driver, "//button[@data-id=\"fltrQBy\"]", Duration.ofSeconds(10)); 
            perform.clickButton(driver, "//a[normalize-space()=\"CodeQuotient\"]", Duration.ofSeconds(10));
           
            
            
          
       }
}
