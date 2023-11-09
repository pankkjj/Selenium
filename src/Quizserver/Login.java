package Quizserver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Login {
    public static void login(WebDriver driver) {
      
        driver.manage().window().maximize();
        driver.get("https://cqtestga.com/login");


        driver.findElement(By.id("email")).sendKeys("pankaj.thakur@codequotient.com");
        driver.findElement(By.id("password")).sendKeys("Holmes@221");
        
        driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
        
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://cqtestga.com/login")) {
            WebElement errmsg=driver.findElement(By.xpath("//p[@id='alert-message']"));
            System.out.println("Login failed. Error message: " + errmsg.getText());
            return;
        } 
        else 
        {
            System.out.println("Login successful");
        } 
    }
}
