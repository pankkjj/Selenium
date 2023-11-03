import functions.*;
import Addquestions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {
    static WebDriver driver=new ChromeDriver();
    public static void main(String[] args) throws InterruptedException {
        
        Login.login(driver);   
        Createtest.create(driver, "iwritebugfreecode");

        Acctomarks.Addbymarks(driver, driver.getCurrentUrl());

    }
    
}
