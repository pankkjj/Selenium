import java.time.Duration;
import java.util.List;

// import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Createtest {

    public static void main(String args[]) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://cqtestga.com/login");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginbutton = driver.findElement(By.xpath("//button[@id='btnSubmit']"));

        sendKeys(driver, email, Duration.ofSeconds(10), "pankaj.thakur@codequotient.com");
        sendKeys(driver, password, Duration.ofSeconds(10), "Holmes@221");
        clickButton(driver, loginbutton, Duration.ofSeconds(10));
        
        WebElement errmsg=driver.findElement(By.xpath("//p[@id='alert-message']"));
        if (isElementVisible(driver, errmsg, Duration.ofSeconds(3))) {
            System.out.println("Login failed. Error message: " + errmsg.getText());
        } else {
            System.out.println("Login successful.");
        }
    
        clickButton(driver, driver.findElement(By.xpath("//body/nav[1]/ul[1]/li[2]/div[1]")),  Duration.ofSeconds(10));
        Thread.sleep(2000);
        clickButton(driver, driver.findElement(By.xpath("//a[@id='quizServerRedirect']")), Duration.ofSeconds(10));
        Thread.sleep(2000);
        clickButton(driver,driver.findElement(By.xpath("//a[contains(text(),'Tests')]")) ,  Duration.ofSeconds(20));

        clickButton(driver,driver.findElement(By.xpath("//body/div[9]/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]")) ,  Duration.ofSeconds(10));
        sendKeys(driver, driver.findElement(By.xpath("//input[@id='newQuizTitle']")),   Duration.ofSeconds(10), "iwriteBug free code");
        clickButton(driver,  driver.findElement(By.xpath("//a[contains(text(),'Create')]")), Duration.ofSeconds(10));

        sendKeys(driver, driver.findElement(By.xpath("//input[@id='quizTime']")),   Duration.ofSeconds(10), "50");
        
        clickButton(driver,  driver.findElement(By.xpath("//body/form[@id='quizForm']/div[2]/button[1]")), Duration.ofSeconds(10));
        sendKeys(driver, driver.findElement(By.xpath("//input[@id='quizCode']")),   Duration.ofSeconds(10), "123");
        clickButton(driver,  driver.findElement(By.xpath("//body/form[@id='quizForm']/div[2]/button[2]")), Duration.ofSeconds(10));
        clickButton(driver,  driver.findElement(By.xpath("//div[@id='change-tab-4']")), Duration.ofSeconds(10));
        clickButton(driver,  driver.findElement(By.xpath("//body/form[@id='quizForm']/div[1]/div[2]/div[2]/div[1]/div[1]/label[8]/span[1]")), Duration.ofSeconds(10));
        clickButton(driver,  driver.findElement(By.xpath("//body/form[@id='quizForm']/div[1]/div[2]/div[2]/div[1]/div[1]/label[9]/span[1]")), Duration.ofSeconds(10));
        clickButton(driver,  driver.findElement(By.xpath("//body/form[@id='quizForm']/div[2]/button[4]")), Duration.ofSeconds(10));
        clickButton(driver,  driver.findElement(By.xpath("//body/form[@id='quizForm']/div[2]/button[5]")), Duration.ofSeconds(10));

        WebElement successmsg=driver.findElement(By.xpath("//p[@id='alert-text']"));
        System.out.println(isElementVisible(driver, successmsg,Duration.ofSeconds(10)));
        if(isElementVisible(driver, successmsg,Duration.ofSeconds(10))){
              System.out.println("Test Created successfully.");
        }
        else{
            System.out.println("Test case failed");
        }
        Thread.sleep(5000);
        
        clickButton(driver,  driver.findElement(By.xpath("//a[contains(text(),'+ create new section')]")), Duration.ofSeconds(10));
         WebElement sectioncreatedmsg=driver.findElement(By.xpath("//p[@id='alert-text']"));
       
        if(isElementVisible(driver,sectioncreatedmsg ,  Duration.ofSeconds(10))){
            System.out.print("Section created");
            clickButton(driver,  driver.findElement(By.xpath("//body/div[5]/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/a[1]")), Duration.ofSeconds(10)); 
        }
        else{
            System.out.println("Failed to create section");
        }
         Thread.sleep(1000);
        clickButton(driver,  driver.findElement(By.xpath("//div[@class='filter-input-section']")), Duration.ofSeconds(10));
        clickButton(driver,  driver.findElement(By.xpath("//li[@onclick=\"openItemDropdoen('type-items')\"]")), Duration.ofSeconds(10));
        clickButton(driver,  driver.findElement(By.xpath("//label[normalize-space()='Coding']")), Duration.ofSeconds(10));
        clickButton(driver,  driver.findElement(By.xpath("//button[@class='btn apply-btn type-apply-btn']")), Duration.ofSeconds(10));
       
        int count = 0;
        while(count<5)
        {
            try{
                WebElement checkbox = driver.findElement(By.xpath("(//tr[@role='row'][" + (count + 1) + "]//td//input[@type='checkbox'])"));
                checkbox.click();
            
                count++;
            }catch(Exception e){
              System.out.println("Can't add questions"+e);
            
            }
        }
        clickButton(driver,  driver.findElement(By.xpath(" //button[@type='button'][normalize-space()='save']")), Duration.ofSeconds(10));    
        Thread.sleep(2000);
        clickButton(driver,  driver.findElement(By.xpath("//a[contains(text(),'+ create new section')]")), Duration.ofSeconds(10));

    }

    static void sendKeys(WebDriver driver, WebElement element, Duration time, String value) {
        new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

    static void clickButton(WebDriver driver, WebElement element, Duration time) {
        new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    
    static boolean isElementVisible(WebDriver driver, WebElement element, Duration time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}





	