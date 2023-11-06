package Addquestions;
import Basicfunctionalities.*;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class organization {
    
       public static void Addquestions(WebDriver driver,String url) throws InterruptedException{
            driver.get(url);
            Thread.sleep(1000);
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
            
            perform.clickButton(driver, "//button[@title=\"My Questions\"]", Duration.ofSeconds(10)); 
            perform.clickButton(driver, "//a[normalize-space()=\"My Organization\"]", Duration.ofSeconds(10));
           
            
          
       }

}
