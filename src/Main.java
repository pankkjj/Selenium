import Addquestions.*;
import Mainserver.Batch;
import Quizserver.*;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {
    static WebDriver driver=new ChromeDriver();
    public static void main(String[] args) throws InterruptedException {
        
        Login.login(driver);   
        // Createtest.create(driver,"Mytest");
        // organization.Addquestions(driver, driver.getCurrentUrl());
        // Addkeyword.add(driver, "https://test.cqtestga.com/quest/add/id:651d56c754a3ebf43cd04908");
        Batch.Findbatch(driver, "https://cqtestga.com/batch/list","Mybatch");
        System.out.println(driver.getCurrentUrl());
        Batch.Addlearners(driver, driver.getCurrentUrl());
    }
    
}
