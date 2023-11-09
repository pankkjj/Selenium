package Quizserver;
import java.time.Duration;
// import java.util.List;

// import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class temp {

    public static void main(String args[]) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://192.168.1.42:3002/test/dashboard");
        
       
        WebElement frame=driver.findElement(By.xpath("//iframe[@id='loginIframe']"));
        driver.switchTo().frame(frame);
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement loginbutton = driver.findElement(By.xpath("//button[@id='submit']"));

        sendKeys(driver, email, Duration.ofSeconds(10), "amit.verma@codequotient.com");
        sendKeys(driver, password, Duration.ofSeconds(10), "Amit@CQ1");
        clickButton(driver, loginbutton, Duration.ofSeconds(10));
        
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        // if (currentUrl.equals("http://192.168.1.42:3002/test/dashboard")) {
        //     WebElement errmsg=driver.findElement(By.xpath("//p[@id='alert-message']"));
        //     System.out.println("Login failed. Error message: " + errmsg.getText());
        //     return;
        // } 
        // else 
        // {
        //     System.out.println("Login successful");
        // }  
       
        // if(driver.getCurrentUrl().equals("https://cqtestga.com/acc")) 
        // {
        //     if(isElementVisible(driver,"//body/nav[1]/ul[1]/li[2]/div[1]",  Duration.ofSeconds(10)))
        //     {
        //         clickButton(driver, driver.findElement(By.xpath("//body/nav[1]/ul[1]/li[2]/div[1]")),  Duration.ofSeconds(10));
        //     }
        //     else{
        //         System.out.println("Cannot find square box icon");
        //         driver.close();
        //         return;
        //     }
        //     clickButton(driver, driver.findElement(By.xpath("//a[@id='quizServerRedirect']")), Duration.ofSeconds(10));
        // }
        // else{
        //     System.out.println("not redirected to /acc");
        //     return;
        // }
        
        // if(isElementVisible(driver, "//a[contains(text(),'Tests')]",  Duration.ofSeconds(10))){
            
        //     clickButton(driver,driver.findElement(By.xpath("//a[contains(text(),'Tests')]")) ,  Duration.ofSeconds(20));
      
        // }
        // else{
        //     System.out.println("cannot redirect to test server");
        // }
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
         clickButton(driver,driver.findElement(By.xpath("(//div[@class=\"dots-btn\"])[1]")) ,  Duration.ofSeconds(20));
        clickButton(driver,driver.findElement(By.xpath("//a[@href=\"/test/list\"]")) ,  Duration.ofSeconds(20));
        sendKeys(driver, driver.findElement(By.xpath("//input[@id='input-search-header']")), Duration.ofSeconds(5), "iwriteBugfreecode");

        clickButton(driver, driver.findElement(By.xpath("//tr[1]//div[@class=\"dots-btn\"]")), Duration.ofSeconds(5));
        clickButton(driver, driver.findElement(By.xpath("//tr[1]//a[@class=\"btnDel\"]")), Duration.ofSeconds(20));
        Thread.sleep(5000);
        clickButton(driver, driver.findElement(By.xpath("//button[@id=\"yes-btn-modal\"]")), Duration.ofSeconds(5));
        // Thread.sleep(5000);
        // if(isElementVisible(driver, "//p[@id='alert-message']", Duration.ofSeconds(10))){
        //     System.out.println("Test deleted");
        // }
        // else{
        //     System.out.println("Can't delete Test");
        // }
    
       
     

     } 
    static void sendKeys(WebDriver driver, WebElement element, Duration time, String value) {
        new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

    static void clickButton(WebDriver driver, WebElement element, Duration time) {
        new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    
    static boolean isElementVisible(WebDriver driver, String path, Duration time) {
        try {
            WebElement element=driver.findElement(By.xpath(path));
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    } 
}   