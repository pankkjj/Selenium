package Addquestions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Basicfunctionalities.perform;

public class selectquestions {
    public static void select(WebDriver driver,int num)
    {
        try
            {
                Thread.sleep(2000);
                List <WebElement> rowslist = driver.findElements(By.xpath("//tr[ @class='even' or @class='odd']"));
                
                int total=rowslist.size();
                if(rowslist.size()<=0)
                {
                  System.out.println("No questions in my organization to add");
                  return;
                }
                else
                {
                    System.out.println("total questions in page "+total);
                    int count = 1;
                    while(count<=num)
                    {
                        try
                        {
                            perform.clickButton(driver, "(//tr[@role='row'][" + count + "]//td//input[@type='checkbox'])", Duration.ofSeconds(10));
                            count++;
                        }
                        catch(Exception e)
                        {
                            System.out.println("again here");   
                            System.out.println("Stale Exception");                
                        }
                    }
                } 
                perform.clickButton(driver,  " //button[@type='button'][normalize-space()='save']", Duration.ofSeconds(10));
            }
            catch(Exception e){
                   System.out.println("Error in selecting questions"); 
            }   
    }

}
