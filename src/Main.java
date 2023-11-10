import Addquestions.*;
import Mainserver.Batch;
import Quizserver.*;

import org.openqa.selenium.interactions.Actions;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {
    static WebDriver driver=new ChromeDriver();
    public static void main(String[] args) throws InterruptedException {
        
        Login.login(driver);   

        Batch.Findbatch(driver, "https://cqtestga.com/batch/list","Mybatch");
        
        Set<String> tabs = driver.getWindowHandles();
        System.out.println(tabs);
        
        String currenttab = tabs.iterator().next();
        tabs.remove(currenttab);

        String newtab= tabs.iterator().next();

        driver.switchTo().window(newtab);

        System.out.println(driver.getCurrentUrl());
        Batch.Addlearners(driver, driver.getCurrentUrl());
    }
    
}
