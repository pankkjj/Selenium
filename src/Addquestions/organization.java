package Addquestions;
import Basicfunctionalities.*;
import java.time.Duration;
import java.util.List;
import java.util.Vector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class organization {
    
       public static void Addquestions(WebDriver driver,String url) throws InterruptedException{
            driver.get(url);
            Actions.clickButton(driver,  "//a[contains(text(),'+ create new section')]", Duration.ofSeconds(10));
            Thread.sleep(2000);
            
            if(Actions.isElementVisible(driver, "//div[@class='modal-alert-msg color-1 visible-alert-modal']", Duration.ofSeconds(10))) 
            {
                System.out.println(driver.findElement(By.xpath("//div[@class='modal-alert-msg color-1 visible-alert-modal']")).getText());
            }
            else{
                System.out.println("alert didn't appear");
            }
            List<WebElement>sections=driver.findElements(By.xpath("//div[@class='sections']")); 
            Actions.clickButton(driver,  "(//a[@class=\"btn ml-3 add-btn-new add-content-link\"])[" + sections.size() + "]", Duration.ofSeconds(10)); 
            
            Actions.clickButton(driver, "//button[@title=\"My Questions\"]", Duration.ofSeconds(10)); 
            Actions.clickButton(driver, "//a[normalize-space()=\"My Organization\"]", Duration.ofSeconds(10));
           
            
            try
            {
                List <WebElement> rowslist = driver.findElements(By.xpath("//tr[ @class='even' or @class='odd']"));
                Vector<WebElement> rows = new Vector<WebElement>(rowslist);
                int total=rows.size();
                if(rows.size()<=0)
                {
                  System.out.println("No questions in my organization to add");
                  return;
                }
                else
                {
                    System.out.println(total);
                    int count = 1;
                    while(count<2)
                    {
                        try
                        {
                            Actions.clickButton(driver, "(//tr[@role='row'][" + count + "]//td//input[@type='checkbox'])", Duration.ofSeconds(10));
                            count++;
                        }
                        catch(Exception e)
                        {
                            System.out.println("again here");   
                            System.out.println("Stale Exception");                
                        }
                    }
                } 
                Actions.clickButton(driver,  " //button[@type='button'][normalize-space()='save']", Duration.ofSeconds(10));
            }
            catch(Exception e){
                    
            }
            
            
          
       }

}
