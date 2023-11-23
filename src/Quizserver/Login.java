package Quizserver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Login {
    public static void login(WebDriver driver, String email, String password) throws InterruptedException {
      
        driver.manage().window().maximize();
        driver.get("https://cqtestga.com/login");

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("performance.setResourceTimingBufferSize(1000)");

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
