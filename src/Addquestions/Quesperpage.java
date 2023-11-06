package Addquestions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Basicfunctionalities.perform;

public class Quesperpage {
    public static void change(WebDriver driver,String id,String count) throws InterruptedException
    {
        driver.get("https://test.cqtestga.com/test/addQuizContent/"+id);
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
            
            WebElement dropdown=driver.findElement(By.xpath("//select[@name=\"tblCCLs_length\"]"));
            Select select=new Select(dropdown);
            select.selectByVisibleText(count);

    }
}
