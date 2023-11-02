package functions;
import java.time.Duration;
// import java.util.List;
import Basicfunctionalities.*;
// import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;

public class Createtest {

   public static void create(WebDriver driver,String testname) throws InterruptedException
   {
        driver.get("https://test.cqtestga.com/test/dashboard");
     
        
         if(driver.getCurrentUrl().equals("https://test.cqtestga.com/test/dashboard")) 
        {  
            Actions.clickButton(driver,"//a[contains(text(),'Tests')]" ,  Duration.ofSeconds(20));
        }
        else{
            System.out.println("not in test server");
        }

        Actions.clickButton(driver,"//body/div[9]/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]" ,  Duration.ofSeconds(10));
        Actions.sendKeys(driver, "//input[@id='newQuizTitle']",   Duration.ofSeconds(10), testname);
        Actions.clickButton(driver, "//a[contains(text(),'Create')]", Duration.ofSeconds(10));

        Actions.sendKeys(driver, "//input[@id='quizTime']",   Duration.ofSeconds(10), "50");
        
        Actions.clickButton(driver, "//body/form[@id='quizForm']/div[2]/button[1]", Duration.ofSeconds(10));
        Actions.sendKeys(driver, "//input[@id='quizCode']", Duration.ofSeconds(10), "123");
        Actions.clickButton(driver,  "//body/form[@id='quizForm']/div[2]/button[2]", Duration.ofSeconds(10));
        Actions.clickButton(driver,  "//div[@id='change-tab-4']", Duration.ofSeconds(10));
        Actions.clickButton(driver,  "//body/form[@id='quizForm']/div[1]/div[2]/div[2]/div[1]/div[1]/label[8]/span[1]", Duration.ofSeconds(10));
        Actions.clickButton(driver,  "//body/form[@id='quizForm']/div[1]/div[2]/div[2]/div[1]/div[1]/label[9]/span[1]", Duration.ofSeconds(10));
        Actions.clickButton(driver,  "//body/form[@id='quizForm']/div[2]/button[4]", Duration.ofSeconds(10));
        Actions.clickButton(driver,  "//body/form[@id='quizForm']/div[2]/button[5]", Duration.ofSeconds(10));

        if(Actions.isElementVisible(driver, "//p[@id='alert-text']",Duration.ofSeconds(10))){
              System.out.println("Test Created successfully.");
        }
        else{
            System.out.println("Can't create Test");
        }
       
    }
    // public static void main(String args[]) throws InterruptedException  {
    //     System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver-win64\\chromedriver.exe");
    //     WebDriver driver = new ChromeDriver();
    //     driver.manage().window().maximize();
    //     driver.get("https://cqtestga.com/login");


    //     WebElement email = driver.findElement(By.id("email"));
    //     WebElement password = driver.findElement(By.id("password"));

    //     Actions.sendKeys(driver, email, Duration.ofSeconds(10), "pankaj.thakur@codequotient.com");
    //     Actions.sendKeys(driver, password, Duration.ofSeconds(10), "Holmes@221");
    //     Actions.clickButton(driver, "//button[@id='btnSubmit']", Duration.ofSeconds(10));
        
    //     String currentUrl = driver.getCurrentUrl();
    //     System.out.println(currentUrl);
    //     if (currentUrl.equals("https://cqtestga.com/login")) {
    //         WebElement errmsg=driver.findElement(By.xpath("//p[@id='alert-message']"));
    //         System.out.println("Login failed. Error message: " + errmsg.getText());
    //         return;
    //     } 
    //     else 
    //     {
    //         System.out.println("Login successful");
    //     }  
       
    //     if(driver.getCurrentUrl().equals("https://cqtestga.com/acc")) 
    //     {
            
    //         Thread.sleep(1000);
    //         Actions.clickButton(driver, "//body/nav[1]/ul[1]/li[2]/div[1]",  Duration.ofSeconds(10));
    //         Actions.clickButton(driver, "//a[@id='quizServerRedirect']", Duration.ofSeconds(10));
    //     }
    //     else{
    //         System.out.println("not redirected to /acc");
    //         return;
    //     }
        
    //      if(driver.getCurrentUrl().equals("https://test.cqtestga.com/test/dashboard")) 
    //     {  
    //         Actions.clickButton(driver,"//a[contains(text(),'Tests')]" ,  Duration.ofSeconds(20));
    //     }
    //     Actions.clickButton(driver,"//a[contains(text(),'Tests')]" ,  Duration.ofSeconds(20));

    //     Actions.clickButton(driver,"//body/div[9]/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]" ,  Duration.ofSeconds(10));
    //     Actions.sendKeys(driver, driver.findElement(By.xpath("//input[@id='newQuizTitle']")),   Duration.ofSeconds(10), "iwriteBug free code");
    //     Actions.clickButton(driver, "//a[contains(text(),'Create')]", Duration.ofSeconds(10));

    //     Actions.sendKeys(driver, driver.findElement(By.xpath("//input[@id='quizTime']")),   Duration.ofSeconds(10), "50");
        
    //     Actions.clickButton(driver, "//body/form[@id='quizForm']/div[2]/button[1]", Duration.ofSeconds(10));
    //     Actions.sendKeys(driver, driver.findElement(By.xpath("//input[@id='quizCode']")), Duration.ofSeconds(10), "123");
    //     Actions.clickButton(driver,  "//body/form[@id='quizForm']/div[2]/button[2]", Duration.ofSeconds(10));
    //     Actions.clickButton(driver,  "//div[@id='change-tab-4']", Duration.ofSeconds(10));
    //     Actions.clickButton(driver,  "//body/form[@id='quizForm']/div[1]/div[2]/div[2]/div[1]/div[1]/label[8]/span[1]", Duration.ofSeconds(10));
    //     Actions.clickButton(driver,  "//body/form[@id='quizForm']/div[1]/div[2]/div[2]/div[1]/div[1]/label[9]/span[1]", Duration.ofSeconds(10));
    //     Actions.clickButton(driver,  "//body/form[@id='quizForm']/div[2]/button[4]", Duration.ofSeconds(10));
    //     Actions.clickButton(driver,  "//body/form[@id='quizForm']/div[2]/button[5]", Duration.ofSeconds(10));

    //     if(isElementVisible(driver, "//p[@id='alert-text']",Duration.ofSeconds(10))){
    //           System.out.println("Test Created successfully.");
    //     }
    //     else{
    //         System.out.println("Can't create Test");
    //     }
    //     Actions.clickButton(driver,  "//a[contains(text(),'+ create new section')]", Duration.ofSeconds(10));
    //     Thread.sleep(2000);
        
    //     int sections=0;
    //     String alertmsg=driver.findElement(By.xpath("//p[@id='alert-text']")).getText();
    //     System.out.println(alertmsg);
    //     if(alertmsg.equals("New section created.")){
    //         sections++;
    //     }
    //     else{
    //         System.out.println("Failed to create section");
    //         driver.close();
    //         return;
    //     }
        
    //     Actions.clickButton(driver,  "//a[(@class=\"btn ml-3 add-btn-new add-content-link\")]", Duration.ofSeconds(10)); 
      
    //     Actions.clickButton(driver, "//div[@class='filter-input-section']", Duration.ofSeconds(10));
    //     Actions.clickButton(driver,  "//li[@onclick=\"openItemDropdoen('type-items')\"]", Duration.ofSeconds(10));
    //     Actions.clickButton(driver,  "//label[normalize-space()='Coding']", Duration.ofSeconds(10));
    //     Actions.clickButton(driver,  "//button[@class='btn apply-btn type-apply-btn']", Duration.ofSeconds(10));
       
    //     int count = 0;
    //     while(count<5)
    //     {
    //         try{
    //             WebElement checkbox = driver.findElement(By.xpath("(//tr[@role='row'][" + (count + 1) + "]//td//input[@type='checkbox'])"));
    //             checkbox.click();
    //             count++;
    //         }catch(Exception e){
    //           System.out.println("again here");   
    //           System.out.println("Stale Exception");
    
    //         }
    //     }

    //     Actions.clickButton(driver,  " //button[@type='button'][normalize-space()='save']", Duration.ofSeconds(10));    
    //     Thread.sleep(2000);

    //     Actions.clickButton(driver, "//a[contains(text(),'+ create new section')]", Duration.ofSeconds(10));
    //     Thread.sleep(2000);
    //     System.out.println(driver.findElement(By.xpath("//p[@id='alert-text']")).getText());
    //     if(driver.findElement(By.xpath("//p[@id='alert-text']")).getText().equals("New section created.")){
    //         System.out.println(sections+" sections created");
    //         sections++;
    //     }
    //     else{
    //         System.out.println("Failed to create section");
    //         driver.close();
    //         return;
    //     }
    //     Actions.clickButton(driver,  "//div[@class=\"sections\"]["+sections+"]//a[(@class=\"btn ml-3 add-btn-new add-content-link\")]", Duration.ofSeconds(10)); 
    //     Actions.clickButton(driver, "//img[starts-with(@onclick,'tagclear')]", Duration.ofSeconds(10));
    //     Actions.clickButton(driver, "//div[@class='filter-input-section']", Duration.ofSeconds(10));
    //     Actions.clickButton(driver,  "//li[@onclick=\"openItemDropdoen('type-items')\"]", Duration.ofSeconds(10));
    //     Actions.clickButton(driver,  "//label[normalize-space()='MCQ']", Duration.ofSeconds(10));
    //     Actions.clickButton(driver,  "//button[@class='btn apply-btn type-apply-btn']", Duration.ofSeconds(10));
    //     int mcqcount=0;
    //     while(mcqcount<2)
    //     {
    //         try{
    //             WebElement checkbox = driver.findElement(By.xpath("(//tr[@role='row'][" + (mcqcount + 1) + "]//td//input[@type='checkbox'])"));
    //             checkbox.click();
    //             mcqcount++;
    //         }catch(Exception e){
    //           System.out.println("again here");   
    //           System.out.println("Stale Exception");
    
    //         }
    //     }
    // }

 
}





	