package Quizserver;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Login {
    public static void login(WebDriver driver, String email, String password) {
      
        driver.manage().window().maximize();
        driver.get("https://cqtestga.com/login");

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        
        driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
        
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://cqtestga.com/login")) {
            WebElement errmsg=driver.findElement(By.xpath("//p[@id='alert-message']"));
            System.out.println("Login failed. Error message: " + errmsg.getText());
            return;
        } 
        else 
        {
            TakesScreenshot screenshot = ((TakesScreenshot)driver);
            File SrcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("C:\\Users\\Pankaj Thakur\\eclipse-workspace\\Selenium\\test.png");
            try {
                FileUtils.copyFile(SrcFile, destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Login successful");
        } 
    }
}
