package Basicfunctionalities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Basic
 {
    
    public static void sendKeys(WebDriver driver, String path, Duration time, String value) {
        try{
            WebElement element=driver.findElement(By.xpath(path));
             new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
             element.sendKeys(value);
        }
        catch(Exception e){
           takescreenshot.shot(driver, "SendKeys");
           System.out.println("Element not found" + path);
        }
       
    }

     public static void clickButton(WebDriver driver, String path, Duration time) {
        try{
      
            new WebDriverWait(driver, time).until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
            WebElement element=driver.findElement(By.xpath(path));
            new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }
        catch(Exception e){
            takescreenshot.shot(driver,"clickError");
            System.out.println("Cannot find element "+path);
        }
      
    }
    
    public static boolean isElementVisible(WebDriver driver, String path, Duration time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void Clearkeys(WebDriver driver, String path,Duration time){
        try{
              WebElement element=driver.findElement(By.xpath(path));
              element.clear();   
        }catch(Exception e){

            System.out.println("Error in clearing keys");
        }
    }
    
    public static WebElement find(WebDriver driver,String path, Duration time){
        try{
            new WebDriverWait(driver, time).until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
            WebElement element = driver.findElement(By.xpath(path));
            return element;
        }catch(Exception e){
            takescreenshot.shot(driver,"unableToFind");
            System.out.println("element not found"+path);
             return null;
        }
        
    }
}
