package functions;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import Basicfunctionalities.perform;

public class Deletetest {

    public static void delete(WebDriver driver,String testname) throws InterruptedException {
        if(!driver.getCurrentUrl().equals("https://test.cqtestga.com/test/list")){
            driver.get("https://test.cqtestga.com/test/list");
        }
        
        perform.Clearkeys(driver, "//input[@id=\"input-search-header\"]", Duration.ofSeconds(5));
        perform.sendKeys(driver, "//input[@id=\"input-search-header\"]", Duration.ofSeconds(5), testname);
        Thread.sleep(2000);
        perform.clickButton(driver, "//tr[1]//div[@class=\"dots-btn\"]", Duration.ofSeconds(5));
        perform.clickButton(driver, "//tr[1]//a[@class=\"btnDel\"]", Duration.ofSeconds(20));
        Thread.sleep(1000);
        perform.clickButton(driver,"//button[@id=\"yes-btn-modal\"]", Duration.ofSeconds(5));

      
        if(perform.isElementVisible(driver, "//div[@class='modal-alert-msg color-1 visible-alert-modal']", Duration.ofSeconds(10))){
            System.out.println(driver.findElement(By.xpath("//div[@class='modal-alert-msg color-1 visible-alert-modal']")).getText());
        }
        else{
            System.out.println("Can't delete Test");
        }
       

     } 
  
}     

