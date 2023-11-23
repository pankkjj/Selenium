import Addquestions.*;
import Basicfunctionalities.checkresponse;
import Excel.excelfile;
import Mainserver.Batch;
import Mainserver.Profile;
import Quizserver.*;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {
     static WebDriver driver=new ChromeDriver();
    public static void main(String[] args) throws InterruptedException, IOException {
    //     String [] users = { 
    //            "learner1@gmail.vv",                                                                                                                                                           
    //            "learner2@gmail.vv",
    //            "learner3@gmail.vv",
    //            "user1@gmail.com",
    //            "user2@gmail.com", 
    //            "learner4@gmail.vv",
    //            "learner5@gmail.com",
    //            "learner6@gmial.com",
    //            "learner7@gmail.com",
    //            "learner8@gmail.co",
    //            "learner9@gmail.com",
    //            "learner10@gmail.com",
    //            "learner11@gmail.com",
    //            "learner12@gmail.com",
    //            "learner13@gmail.com",
    //            "learner14@gmail.com",
    //            "learner15@gmail.com",
    //            "learner16@gmail.com",
    //            "learner17@gmail.com",
    //            "learner18@gmail.com",
    //            "learner19@gmail.com",
    //            "learner20@gmail.com",
    //            "learner21@gmail.com",
    //            "learner22@gmail.com",
    //            "admin.learner@cq.test",
    //            "zoro@gmail.com",
    //            "luffy@gmail.com",
    //            "learner40@cqtest.ga",
    //            "learner50@cqtestga.com",
    //            "learner60@cqtestga.com",
    //            "learner500@cq.test",
    //            "learner120@cq.test",
    //            "learner1000@cq.test",
    //            "learner140@cq.test",
    //            "learner150@cq.test",
    //            "learner151@cq.test",
    //            "learner152@cq.test",
    //            "learner153@cq.test",
    //            "learner.152@cq.test",
    //            "learner.156@codequotient.com",
    //            "learner.157@codequotient.com",
    //            "learner.158@codequotient.com",
    //            "learner160@g.vv",
    //            "learner23@gamil.com"
    //    };
    //     int count = 103;
    //     for(String user : users){
    //       Thread.sleep(2000);
    //       Login.login(driver,user,"Holmes@221"); 
    //       System.out.println(user);
    //       Profile.setusername(driver,"user"+count);
    //       count++;
    //       Thread.sleep(1000);
    //     }
            //  excelfile.merge();
         
            Login.login(driver, "pankaj.thakur@codequotient.com", "Holmes@221");
            Createtest.selectdate(driver, "https://test.cqtestga.com/test/add/652e24108d657dd15826adec");
    }



    static void matchtitle(WebDriver driver, String title)
    {

        Set<String> tabs = driver.getWindowHandles();

        for(String tab : tabs)
        {
            driver.switchTo().window(tab);
            
            if(driver.getTitle().equals(title)){
                 System.out.println(driver.getCurrentUrl());
                 break;
            }

        }
    }


}
