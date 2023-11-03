package Addquestions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Basicfunctionalities.Actions;

public class Bykeywords {
    
    public static void Addquestions(WebDriver driver, String id, String keyword) throws InterruptedException{
         
        driver.get("https://test.cqtestga.com/test/addQuizContent/"+id);
         // driver.get(id);
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

        Actions.clickButton(driver, "//input[@class=\"filter-input\"]", Duration.ofSeconds(10));
        Actions.clickButton(driver, "//li[normalize-space()=\"Keyword\"]", Duration.ofSeconds(10));
        // Actions.sendKeys(driver, "//input[@class=\"searchTags\"]", Duration.ofSeconds(10), keyword);
        Actions.clickButton(driver, "//label[@title="+ keyword +" ]", Duration.ofSeconds(10));
        Actions.clickButton(driver, "//button[@class=\"btn apply-btn keyword-apply-btn\" ]", Duration.ofSeconds(10));
    }

}
