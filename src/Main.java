import Addquestions.*;
import Basicfunctionalities.checkresponse;
import Excel.excelfile;
import Mainserver.Batch;
import Mainserver.Profile;
import Quizserver.*;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Main {
   
     
    public static void main(String[] args) throws InterruptedException, IOException {
            System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
    
            ChromeOptions options = new ChromeOptions();
            options.addArguments("use-fake-device-for-media-stream");
            options.addArguments("use-fake-ui-for-media-stream");
            options.addArguments("start-maximized");

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", "chrome");
            caps.setCapability("browserVersion", "75.0");
            caps.setCapability("platformName", "Windows");
            caps.setCapability("platformVersion", "10");
            caps.setCapability(ChromeOptions.CAPABILITY, options);

            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            
            for(int i=0;i<2;i++){
               Attempttest.signup(driver, 
               "https://tests.cqtestga.com/test/1704359016339",
               "automation" + i +"@gmail.com",
               "Holmes@221",
               "123",
               "auto"+i
               );
            }
       
    }



    static void matchtitle(WebDriver driver, String title)
    {

        Set<String> tabs = driver.getWindowHandles();

        for(String tab : tabs)
        {
            driver.switchTo().window(tab);
            
            if(driver.getTitle().equals(title))
            {
                 System.out.println(driver.getCurrentUrl());
                 break;
            }

        }
    }


}
