package functions;
import java.time.Duration;
// import java.util.List;

// import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;

import Basicfunctionalities.Actions;

public class Deletetest {

    public static void delete(WebDriver driver) throws InterruptedException {
        if(!driver.getCurrentUrl().equals("https://test.cqtestga.com/test/dashboard")){
            driver.get("https://test.cqtestga.com/test/dashboard");
        }
        
     
        if(driver.getCurrentUrl().equals("https://test.cqtestga.com/test/dashboard")) 
        {  
           Actions.clickButton(driver,"//a[contains(text(),'Tests')]" ,  Duration.ofSeconds(20));
        }
        else
        {
           System.out.println("not in test server");
        }

        Actions.sendKeys(driver, "//input[@id=\"input-search-header\"]", Duration.ofSeconds(5), "autotest");
        Thread.sleep(2000);
        Actions.clickButton(driver, "//tr[1]//div[@class=\"dots-btn\"]", Duration.ofSeconds(5));
        Actions.clickButton(driver, "//tr[1]//a[@class=\"btnDel\"]", Duration.ofSeconds(20));
        Thread.sleep(1000);
        Actions.clickButton(driver,"//button[@id=\"yes-btn-modal\"]", Duration.ofSeconds(5));
        Thread.sleep(3000);
        // if(isElementVisible(driver, "//p[@id='alert-message']", Duration.ofSeconds(10))){
        //     System.out.println("Test deleted");
        // }
        // else{
        //     System.out.println("Can't delete Test");
        //     System.out.println(driver.findElement(By.xpath("//p[@id='alert-message']")).getText());
        // }
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        
        localStorage.clear();

     } 
  
}     

