
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
    //         // for(int i=410;i<=415;i++)
    //         // {
    //         //     System.out.println(i+"th shinobi attempting");
    //         //    Attempttest.signup(driver, 
    //         //    testLink,
    //         //    "shinobi"+ i+"@gmail.vvv",
    //         //    "Holmes@221",
    //         //    testCode,
    //         //    "shinobi"+ i
    //         //    );
    //         // }
    //         // Attempttest.login(driver, testLink, "ptthakur46@gmail.com", "Holmes@221", testCode);
            
            // GetQuestions.getQuestions(driver,""https://codequotient.com/quest/preview/63b98f9859d8e1c0f601102d",");
            // GetQuestions.readFile(driver, mainFilePath);
     
            String[] links = {  "https://codequotient.com/quest/preview/63b98f9859d8e1c0f601102d",
                                "https://codequotient.com/quest/preview/63bc3817a9023fc14497e0cc",
                                "https://codequotient.com/quest/preview/63bc3058a9023fc14497e09f",
                                "https://codequotient.com/quest/preview/63bc135059d8e1c0f6012879",
                                "https://codequotient.com/quest/preview/63bc3848a9023fc14497e0d7",
                                "https://codequotient.com/quest/preview/638dc5dc8a541f05ef6e9a92",
                                "https://codequotient.com/quest/preview/63bc373fa9023fc14497e0bd",
                                "https://codequotient.com/quest/preview/63bc3738a9023fc14497e0bb",
                                "https://codequotient.com/quest/preview/63bc16cd59d8e1c0f6012893",
                                "https://codequotient.com/quest/preview/63bc3044a9023fc14497e09d",
                                "https://codequotient.com/quest/preview/63bc30cba9023fc14497e0a7",
                                "https://codequotient.com/quest/preview/63b990f559d8e1c0f6011031",
                                "https://codequotient.com/quest/preview/63bc305ca9023fc14497e0a0",
                                "https://codequotient.com/quest/preview/63bc13a159d8e1c0f601287b",
                                "https://codequotient.com/quest/preview/6395aa3aefc7e205c87b4abe",
                                "https://codequotient.com/quest/preview/6395a9bcefc7e205c87b4abc",
                                "https://codequotient.com/quest/preview/638dc4b98a541f05ef6e9a90",
                                "https://codequotient.com/quest/preview/638dc45b8a541f05ef6e9a8e",
                                "https://codequotient.com/quest/preview/638ed1cfefc7e205c87b3839",
                                "https://codequotient.com/quest/preview/636bad68007e1006166b47bf",
                                "https://codequotient.com/quest/preview/636bae08007e1006166b47c5",
                                "https://codequotient.com/quest/preview/636bada0007e1006166b47c1",
                                "https://codequotient.com/quest/preview/636bb7e7007e1006166b47d9",
                                "https://codequotient.com/quest/preview/636777cc8a541f05ef6dca18",
                                "https://codequotient.com/quest/preview/63bc3830a9023fc14497e0d1",
                                "https://codequotient.com/quest/preview/63b986d259d8e1c0f601101b",
                                "https://codequotient.com/quest/preview/63bc3296a9023fc14497e0b3",
                                "https://codequotient.com/quest/preview/63b9864c59d8e1c0f6011019",
                                "https://codequotient.com/quest/preview/63bc30b9a9023fc14497e0a4",
                                "https://codequotient.com/quest/preview/636b382cefc7e205c87a83f5",
                                "https://codequotient.com/quest/preview/63bc375ca9023fc14497e0c3",
                                "https://codequotient.com/quest/preview/6395a2a9efc7e205c87b4aaa",
                                "https://codequotient.com/quest/preview/6395a905efc7e205c87b4aba",
                                "https://codequotient.com/quest/preview/6395a5dfefc7e205c87b4ab2",
                                "https://codequotient.com/quest/preview/638dc7e38a541f05ef6e9a95",
                                "https://codequotient.com/quest/preview/638ed885efc7e205c87b38b0",
                                "https://codequotient.com/quest/preview/6395a019efc7e205c87b4aa2",
                                "https://codequotient.com/quest/preview/6395a749efc7e205c87b4ab6",
                                "https://codequotient.com/quest/preview/638dcb518a541f05ef6e9a97",
                                "https://codequotient.com/quest/preview/63bc32b6a9023fc14497e0b9",
                                "https://codequotient.com/quest/preview/63bc30e9a9023fc14497e0aa",
                                "https://codequotient.com/quest/preview/638dc4d98a541f05ef6e9a91",
                                "https://codequotient.com/quest/preview/63bc30c2a9023fc14497e0a5",
                                "https://codequotient.com/quest/preview/63b988a359d8e1c0f6011021",
                                "https://codequotient.com/quest/preview/636776f98a541f05ef6dca12",
                                "https://codequotient.com/quest/preview/636a0ce1efc7e205c87a81a2",
                                "https://codequotient.com/quest/preview/636bb747007e1006166b47d7",
                                "https://codequotient.com/quest/preview/63677b9e8a541f05ef6dca24",
                                "https://codequotient.com/quest/preview/63960ef38a541f05ef6eadbd",
                                "https://codequotient.com/quest/preview/639609aa8a541f05ef6ead9a",
                                "https://codequotient.com/quest/preview/636bba8e007e1006166b47db",
                                "https://codequotient.com/quest/preview/636bbb04007e1006166b47dd",
                                "https://codequotient.com/quest/preview/636bac9d007e1006166b47b7",
                                "https://codequotient.com/quest/preview/636bad39007e1006166b47bd",
                                "https://codequotient.com/quest/preview/636badd4007e1006166b47c3",
                                "https://codequotient.com/quest/preview/636bac6b007e1006166b47b5",
                                "https://codequotient.com/quest/preview/636bacda007e1006166b47b9",
                                "https://codequotient.com/quest/preview/636baba0007e1006166b47b0",
                                "https://codequotient.com/quest/preview/636b38c4efc7e205c87a83fe",
                                "https://codequotient.com/quest/preview/63c986c359d8e1c0f60161d1",
                                "https://codequotient.com/quest/preview/63c99357a9023fc144981adf",
                                "https://codequotient.com/quest/preview/63c99164a9023fc144981ad5",
                                "https://codequotient.com/quest/preview/63bc3752a9023fc14497e0c1",
                                "https://codequotient.com/quest/preview/636bab57007e1006166b47ae",
                                "https://codequotient.com/quest/preview/63c98ca9a9023fc144981ab4",
                                "https://codequotient.com/quest/preview/63c98e9da9023fc144981ac3",
                                "https://codequotient.com/quest/preview/63c98e64a9023fc144981ac1",
                                "https://codequotient.com/quest/preview/63c980a759d8e1c0f60161c7",
                                "https://codequotient.com/quest/preview/63c98fb559d8e1c0f60161d7",
                                "https://codequotient.com/quest/preview/63c9895f59d8e1c0f60161d3",
                                "https://codequotient.com/quest/preview/63960f338a541f05ef6eadbf",
                                "https://codequotient.com/quest/preview/6364d973007e1006166b310e",
                                "https://codequotient.com/quest/preview/63c983ff59d8e1c0f60161ce",
                                "https://codequotient.com/quest/preview/63c98d2ca9023fc144981ab8",
                                "https://codequotient.com/quest/preview/63bc3285a9023fc14497e0b0",
                                "https://codequotient.com/quest/preview/6395a81eefc7e205c87b4ab8",
                                "https://codequotient.com/quest/preview/6395a430efc7e205c87b4ab0",
                                "https://codequotient.com/quest/preview/63960aef8a541f05ef6eada2",
                                "https://codequotient.com/quest/preview/63c98b3d59d8e1c0f60161d4",
                                "https://codequotient.com/quest/preview/63c98c03a9023fc144981aae",
                                "https://codequotient.com/quest/preview/63bc3822a9023fc14497e0ce",
                                "https://codequotient.com/quest/preview/63bc30efa9023fc14497e0ab",
                                "https://codequotient.com/quest/preview/63bc32bba9023fc14497e0ba",
                                "https://codequotient.com/quest/preview/63c9825659d8e1c0f60161cc",
                                "https://codequotient.com/quest/preview/63c980c059d8e1c0f60161c8",
                                "https://codequotient.com/quest/preview/63c9851859d8e1c0f60161cf",
                                "https://codequotient.com/quest/preview/63c9817559d8e1c0f60161c9",
                                "https://codequotient.com/quest/preview/63c98d95a9023fc144981aba",
                                "https://codequotient.com/quest/preview/63c99293a9023fc144981add",
                                "https://codequotient.com/quest/preview/63c98f45a9023fc144981ac7",
                                "https://codequotient.com/quest/preview/63c98ffaa9023fc144981acb",
                                "https://codequotient.com/quest/preview/63c98c7ca9023fc144981ab2",
                                "https://codequotient.com/quest/preview/63960c5e8a541f05ef6eadab",
                                "https://codequotient.com/quest/preview/63bc3826a9023fc14497e0cf",
                                "https://codequotient.com/quest/preview/63c988c159d8e1c0f60161d2",
                                "https://codequotient.com/quest/preview/63960a658a541f05ef6eada0",
                                "https://codequotient.com/quest/preview/63bc384da9023fc14497e0d8",
                                "https://codequotient.com/quest/preview/63bc3777a9023fc14497e0c9",
                                "https://codequotient.com/quest/preview/638ed722efc7e205c87b389d",
                                "https://codequotient.com/quest/preview/638ed76befc7e205c87b38a1"

            };

            Login.login(driver, "pankaj.thakur@codequotient.com", "Codequotient@1");
            for(int i=0;i<links.length;i++){
                String id = getid(links[i]);
                GetQuestions.getQuestionDetails(driver, id);
            }

            // GetQuestions.getQuestionDetails(driver,"https://codequotient.com/quest/preview/63b98f9859d8e1c0f601102d");
    }

    static String getid(String url){
        String[] urlParts = url.split("/");
        String potentialId = urlParts[urlParts.length - 1];
        if (!potentialId.isEmpty()) {
          return potentialId;
        } else {
         return null;
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
