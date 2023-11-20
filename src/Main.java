import Addquestions.*;
import Mainserver.Batch;
import Quizserver.*;

import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {
    static WebDriver driver=new ChromeDriver();
    public static void main(String[] args) throws InterruptedException, IOException {
        
        Login.login(driver);   

        Batch.Findbatch(driver, "https://cqtestga.com/batch/list","Mybatch");
        
        matchtitle(driver, "Batch Learners | CodeQuotient");
        
        Batch.Addbulkusers(driver, driver.getCurrentUrl());
        
        // System.out.println(tabs);
        
        // String currenttab = tabs.iterator().next();
        // tabs.remove(currenttab);

        // String newtab= tabs.iterator().next();

        // driver.switchTo().window(newtab);

        // System.out.println(driver.getCurrentUrl());
        // Batch.Addlearners(driver, driver.getCurrentUrl());
        Batch.Removelearner(driver, driver.getCurrentUrl(), "learner23@gmail.com");
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
