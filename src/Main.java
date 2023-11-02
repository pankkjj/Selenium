import functions.*;
import Addquestions.*;
// import java.time.Duration;
// import java.util.List;

// import org.openqa.selenium.Alert;
// import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.html5.LocalStorage;
// import org.openqa.selenium.html5.WebStorage;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;


public class Main {
    static WebDriver driver=new ChromeDriver();
    public static void main(String[] args) throws InterruptedException {
        
        Login.login(driver);
        int i=0;
        while(i<5)
        {      
              Deletetest.delete(driver);
              i++;
        }
        // Createtest.create(driver,"auto test");
        // System.out.println(driver.getCurrentUrl());
        // Bykeywords.Addquestions(driver, "65432fe190d091975cd35363", "c++");
    }
    
}
