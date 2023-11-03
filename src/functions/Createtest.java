package functions;
import java.time.Duration;
// import java.util.List;
import Basicfunctionalities.*;
// import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;

public class Createtest {

   public static void create(WebDriver driver,String testname) throws InterruptedException
   {
        driver.get("https://test.cqtestga.com/test/dashboard");
     
        
         if(driver.getCurrentUrl().equals("https://test.cqtestga.com/test/dashboard")) 
        {  
            Actions.clickButton(driver,"//a[contains(text(),'Tests')]" ,  Duration.ofSeconds(20));
        }
        else{
            System.out.println("not in test server");
        }

        Actions.clickButton(driver,"//button[@class=\"btn btn-theme under-tooltip\"]" ,  Duration.ofSeconds(10));
        Actions.sendKeys(driver, "//input[@id='newQuizTitle']",   Duration.ofSeconds(10), testname);
        Actions.clickButton(driver, "//a[contains(text(),'Create')]", Duration.ofSeconds(10));

        Actions.sendKeys(driver, "//input[@id='quizTime']",   Duration.ofSeconds(10), "50");
        
        Actions.clickButton(driver, "//body/form[@id='quizForm']/div[2]/button[1]", Duration.ofSeconds(10));
        Actions.sendKeys(driver, "//input[@id='quizCode']", Duration.ofSeconds(10), "123");
        Actions.clickButton(driver,  "//body/form[@id='quizForm']/div[2]/button[2]", Duration.ofSeconds(10));
        Actions.clickButton(driver,  "//div[@id='change-tab-4']", Duration.ofSeconds(10));
        Actions.clickButton(driver,  "//label[.//input[@id=\"isAppOnly\"]]", Duration.ofSeconds(10));
        Actions.clickButton(driver,  "//label[.//input[@id=\"revisitAllowed\"]]", Duration.ofSeconds(10));
        Actions.clickButton(driver,  "//body/form[@id='quizForm']/div[2]/button[4]", Duration.ofSeconds(10));
        Actions.clickButton(driver,  "//body/form[@id='quizForm']/div[2]/button[5]", Duration.ofSeconds(10));

        if(Actions.isElementVisible(driver, "//p[@id='alert-text']",Duration.ofSeconds(10))){
              System.out.println("Test Created successfully.");
        }
        else{
            System.out.println("Can't create Test");
        }
       
    }
    
    //     }
    // }

 
}





	