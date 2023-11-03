package functions;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import Basicfunctionalities.Actions;

public class Deletetest {

    public static void delete(WebDriver driver,String testname) throws InterruptedException {
        if(!driver.getCurrentUrl().equals("https://test.cqtestga.com/test/list")){
            driver.get("https://test.cqtestga.com/test/list");
        }
        
        Actions.Clearkeys(driver, "//input[@id=\"input-search-header\"]", Duration.ofSeconds(5));
        Actions.sendKeys(driver, "//input[@id=\"input-search-header\"]", Duration.ofSeconds(5), testname);
        Thread.sleep(2000);
        Actions.clickButton(driver, "//tr[1]//div[@class=\"dots-btn\"]", Duration.ofSeconds(5));
        Actions.clickButton(driver, "//tr[1]//a[@class=\"btnDel\"]", Duration.ofSeconds(20));
        Thread.sleep(1000);
        Actions.clickButton(driver,"//button[@id=\"yes-btn-modal\"]", Duration.ofSeconds(5));

      
        if(Actions.isElementVisible(driver, "//div[@class='modal-alert-msg color-1 visible-alert-modal']", Duration.ofSeconds(10))){
            System.out.println(driver.findElement(By.xpath("//div[@class='modal-alert-msg color-1 visible-alert-modal']")).getText());
        }
        else{
            System.out.println("Can't delete Test");
        }
       

     } 
  
}     

