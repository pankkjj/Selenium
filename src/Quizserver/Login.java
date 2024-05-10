package Quizserver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Basicfunctionalities.Basic;


public class Login {
    public static void login(WebDriver driver, String email, String password) throws InterruptedException {
      
        
        driver.get("https://codequotient.com/login");
        
        driver.switchTo().frame(0);
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.xpath("//button[@id='submit']")).click();
        Thread.sleep(500);
        driver.switchTo().defaultContent();
        if(Basic.isElementVisible(driver, "//div[@id='myModal-alert-only']", Duration.ofSeconds(10)))
        {
            WebElement errmsg=driver.findElement(By.xpath("//p[@id='alert-text']"));
            System.out.println( "error message  "+errmsg.getText());
        } 

    }
}
