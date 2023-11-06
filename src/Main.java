import functions.*;
import Addquestions.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {
    static WebDriver driver=new ChromeDriver();
    public static void main(String[] args) throws InterruptedException {
        
        Login.login(driver);   
        
        totalques.getcount(driver, "65460a95f7ead4fa04c4001f");
        // Bykeywords.Addquestions(driver, driver.getCurrentUrl(), "c");
        // selectquestions.select(driver, 3);

        // Codequotient.Addquestions(driver, driver.getCurrentUrl());
        // clearfilters.clear(driver);
        // selectquestions.select(driver, 3);

        // organization.Addquestions(driver, driver.getCurrentUrl());
        // clearfilters.clear(driver);
        // selectquestions.select(driver, 3);
        Actions actions = new Actions(driver);
        
        System.out.println("Test Case passed");
    }
    
}
