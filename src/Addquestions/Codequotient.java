package Addquestions;

import java.time.Duration;
import java.util.List;
import java.util.Vector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Basicfunctionalities.Actions;

public class Codequotient {
    public static void Addquestions(WebDriver driver,String id) throws InterruptedException{
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
            Actions.clickButton(driver, "//button[@title=\"My Questions\"]", Duration.ofSeconds(10)); 
            Actions.clickButton(driver, "//a[normalize-space()=\"CodeQuotient\"]", Duration.ofSeconds(10));
           
            Thread.sleep(4000);
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
                    while(count<=2)
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
