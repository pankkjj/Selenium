package Addquestions;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Basicfunctionalities.perform;

public class Bykeywords {
    
    public static void Addquestions(WebDriver driver, String id, String keyword) throws InterruptedException{
         
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
        List <WebElement> filters=driver.findElements(By.xpath("(//img[starts-with(@onclick,'tagclear')])"));
        int i=1;
        while(i<=filters.size())
        {
            perform.clickButton(driver, "(//img[starts-with(@onclick,'tagclear')])["+ i + "]", Duration.ofSeconds(10));
            i++;
        }
        perform.clickButton(driver, "//input[@class=\"filter-input\"]", Duration.ofSeconds(10));
        perform.clickButton(driver, "//li[normalize-space()=\"Keyword\"]", Duration.ofSeconds(10));
     

        perform.clickButton(driver, "//label[@title='"+ keyword +"' ]", Duration.ofSeconds(10));
        perform.clickButton(driver, "//button[@class=\"btn apply-btn keyword-apply-btn\" ]", Duration.ofSeconds(10));
       
    }

}
