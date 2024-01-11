import Addquestions.*;
import Basicfunctionalities.checkresponse;
import Config.Config;
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

public class App {
   
     
    public static void main(String[] args) throws InterruptedException, IOException {
        String testLink = Config.testlink;
        String testCode = Config.testCode;
        String driverPath =  Config.driverPath;
        String screenshotPath = Config.screenshotPath;
        System.out.println(driverPath);
            System.setProperty("webdriver.chrome.driver", driverPath);
    
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
            for(int i=209;i<=211;i++){
            
               Attempttest.signup(driver, 
               testLink,
               "shinobi" + i +"@gmail.com",
               "Holmes@221",
               testCode,
               "Shinobi"+i,
               screenshotPath
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
