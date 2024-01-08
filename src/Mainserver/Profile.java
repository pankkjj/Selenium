package Mainserver;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Basicfunctionalities.Basic;


public class Profile {
    
    public static void setusername(WebDriver driver, String username) throws InterruptedException{
        Basic.clickButton(driver, "//div[@class=\"square-dropdown-img\"]", Duration.ofSeconds(10));
        Thread.sleep(500);
        Basic.clickButton(driver, "//a[@href=\"/profile\" and @class=\"square-dropdown-item\"]",  Duration.ofSeconds(10));
        Thread.sleep(500);
        WebElement profilelink = driver.findElement(By.xpath("//input[@class=\"form-control profile__link__text\"]"));
        String value = profilelink.getAttribute("value");
        System.out.println(value);
        
      

     
        if(value.equals("Set up a unique profile link!")){
            Basic.clickButton(driver, "//div[@class=\"input-group flex-grow-1\"]", Duration.ofSeconds(10));
            Basic.sendKeys(driver, "//input[@id=\"username\"]",  Duration.ofSeconds(10), username);
            Thread.sleep(1000);
            Basic.clickButton(driver, "//button[@id=\"checkUsernameAvailableButton\"]", Duration.ofSeconds(10));
            Basic.clickButton(driver, "//form[@id=\"createUsernameForm\"]//button[@class=\"btn btn__form__submit\"]", Duration.ofSeconds(10));
            Thread.sleep(1000);
            Basic.clickButton(driver, "//img[@class=\"dp\"]", Duration.ofSeconds(10));
            Thread.sleep(1000);
            Basic.clickButton(driver, "//a[@href=\"/logout\"]", Duration.ofSeconds(10));
        }
        else{
            Basic.clickButton(driver, "//img[@class=\"dp\"]", Duration.ofSeconds(10));
            Thread.sleep(1000);
            Basic.clickButton(driver, "//a[@href=\"/logout\"]", Duration.ofSeconds(10));
        }
        
    }

}
