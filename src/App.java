import Addquestions.*;
import Basicfunctionalities.Basic;
import Basicfunctionalities.checkresponse;
import Config.Config;
import Excel.GetQuestions;
import Excel.excelfile;
import Mainserver.Batch;
import Mainserver.Profile;
import Quizserver.*;
import Testng.Firsttestngscript;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.remote.DesiredCapabilities;

public class App {
   
     
    public static void main(String[] args) throws InterruptedException, IOException {
        String testLink = Config.testlink;
        String testCode = Config.testCode;
        String driverPath =  Config.driverPath;
        String mainFilePath = Config.mainFilePath;
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
            // for(int i=410;i<=415;i++)
            // {
            //     System.out.println(i+"th shinobi attempting");
            //    Attempttest.signup(driver, 
            //    testLink,
            //    "shinobi"+ i+"@gmail.vvv",
            //    "Holmes@221",
            //    testCode,
            //    "shinobi"+ i
            //    );
            // }
            // Attempttest.login(driver, testLink, "ptthakur46@gmail.com", "Holmes@221", testCode);
            
            GetQuestions.getQuestions(driver,"https://cqtestga.com/test/addQuizContent/6544c418f7ead4fa04c3fed5");
            GetQuestions.readFile(driver, mainFilePath);
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

    static void sendEmails(WebDriver driver){
        String [] Emails = { "learner1@gmail.vv",                                                                                                                                                           "learner2@gmail.vv",
        "learner3@gmail.vv",
       "user1@gmail.com",
        "user2@gmail.com", 
           "learner4@gmail.vv",
               "learner5@gmail.com",
               "learner6@gmial.com",
               "learner7@gmail.com",
               "learner8@gmail.co",
               "learner9@gmail.com",
               "learner10@gmail.com",
               "learner11@gmail.com",
               "learner12@gmail.com",
               "learner13@gmail.com",
               "learner14@gmail.com",
               "learner15@gmail.com",
               "learner16@gmail.com",
               "learner17@gmail.com",
               "learner18@gmail.com",
               "learner19@gmail.com",
               "learner20@gmail.com",
               "learner21@gmail.com",
               "learner22@gmail.com",
               "bhumit.learner@cq.test1696828761191",
               "admin.learner@cq.test",
               "zoro@gmail.com",
               "luffy@gmail.com",
               "asdfas@fasdf.com1696829762633",
               "asdfasdf@asdf.com1696829853945",
               "asdfasdf@asdfasdf.com1696829954983",
               "asdfasdf@asdfasdf.com1696831200180",
               "sadfasdf@asdfasdf.com1696831224854",
               "asdfasdfasdf@asdfasdf.com1696831278039",
               "asdfasdf@asdfasdf.com1696831552552",
               "asdfasdfasdf@asdfasfd.com1696831611310",
               "learner40@cqtest.ga",
               "learner50@cqtestga.com",
               "learner60@cqtestga.com",
               "learner500@cq.test",
               "learner120@cq.test",
               "learner1000@cq.test",
               "learner140@cq.test",
               "learner150@cq.test",
               "learner151@cq.test",
               "learner152@cq.test",
               "learner153@cq.test",
               "learner.152@cq.test",
               "learner.156@codequotient.com",
               "learner.157@codequotient.com",
               "learner.158@codequotient.com",
               "learner160@g.vv",
               "learner23@gamil.com"
      };
      Basic.clickButton(driver, "//a[@id='inviteBarOpenBtn']", Duration.ofSeconds(2)); 
      Actions action = new Actions(driver);
        
        for(int i=0;i<1;i++){
            action.click(Basic.find(driver, "//div[@class='invite-form-container']//ul[@class=\"tag-editor ui-sortable\"]", Duration.ofSeconds(2)))
            .sendKeys(Emails[i])
            .sendKeys(Keys.SPACE)
            .perform();
        }
    //    Basic.clickButton(driver, "//input[@id='expireTime']", Duration.ofSeconds(2));
       WebElement date = Basic.find(driver, "//input[@id='expireTime']", Duration.ofSeconds(2));
      
       action.moveToElement(date)
            .doubleClick()
            .click()
            .sendKeys("202401211000")
            .perform();

       
      Basic.clickButton(driver, "//button[normalize-space()='Send invitation']", Duration.ofSeconds(2));
    }

}
