package Addquestions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Basicfunctionalities.Actions;

public class totalques 
{
     public static void getcount(WebDriver driver,String id) throws InterruptedException
     {
            driver.get("https://test.cqtestga.com/test/addQuizContent/"+id);
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
            Thread.sleep(500);
            List <WebElement> pages=driver.findElements(By.xpath("//a[starts-with(@class,\"paginate_button \")]")); 
            int totalpages=pages.size()-1;
            Actions.clickButton(driver, "(//a[starts-with(@class,'paginate_button')])["+ totalpages +"]", Duration.ofSeconds(10));
            Thread.sleep(1000);

            List <WebElement> rowslist = driver.findElements(By.xpath("//tr[ @class='even' or @class='odd']"));
            WebElement lastnumber=driver.findElement(By.xpath("//tr[@role='row'][" + rowslist.size() + "]//td[2]"));
            System.out.println("Total number of questions are:" + lastnumber.getText());
     } 
   
}
