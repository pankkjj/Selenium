package Addquestions;
import Basicfunctionalities.*;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Acctomarks {

    public static void Addbymarks(WebDriver driver,String url) throws InterruptedException{

            driver.get(url);
            Actions.clickButton(driver,  "//a[contains(text(),'+ create new section')]", Duration.ofSeconds(10));
            Thread.sleep(2000);
            
            int sections=0;
            String alertmsg=driver.findElement(By.xpath("//p[@id='alert-text']")).getText();
            System.out.println(alertmsg);
            if(alertmsg.equals("New section created.")){
                sections++;
            }
            else{
                System.out.println("Failed to create section");
                driver.close();
                return;
            }
            
            Actions.clickButton(driver,  "//a[(@class=\"btn ml-3 add-btn-new add-content-link\")]", Duration.ofSeconds(10)); 
        
            Actions.clickButton(driver, "//div[@class='filter-input-section']", Duration.ofSeconds(10));
            Actions.clickButton(driver,  "//li[@onclick=\"openItemDropdoen('type-items')\"]", Duration.ofSeconds(10));
            Actions.clickButton(driver,  "//label[normalize-space()='Coding']", Duration.ofSeconds(10));
            Actions.clickButton(driver,  "//button[@class='btn apply-btn type-apply-btn']", Duration.ofSeconds(10));
        
            int count = 1;
            while(count<5)
            {
                try{
                     
                    WebElement score=driver.findElement(By.xpath("(//tr[@role='row']["+ count +"]//td[8])"));
                    int marks=Integer.parseInt(score.getText());
                    if(marks>=5){

                        System.out.println(marks+"  "+count+ "(//tr[@role='row']["+ count +"]//td[8])" );
                        Actions.clickButton(driver, "(//tr[@role='row'][" + count  + "]//td//input[@type='checkbox'])", Duration.ofSeconds(5));

                    }
                    
                    count++;

                }catch(Exception e){
                //   System.out.println(count+ "(//tr[@role='row']["+ count +"]//td[8])" );
                //   System.out.println(e);   
                  System.out.println("Stale exception");
                  
                }
            }

            Actions.clickButton(driver,  " //button[@type='button'][normalize-space()='save']", Duration.ofSeconds(10));    

            // Thread.sleep(2000);

            // Actions.clickButton(driver, "//a[contains(text(),'+ create new section')]", Duration.ofSeconds(10));
            // Thread.sleep(2000);
            // System.out.println(driver.findElement(By.xpath("//p[@id='alert-text']")).getText());
            // if(driver.findElement(By.xpath("//p[@id='alert-text']")).getText().equals("New section created.")){
            //     System.out.println(sections+" sections created");
            //     sections++;
            // }
            // else{
            //     System.out.println("Failed to create section");
            //     driver.close();
            //     return;
            // }
    }


}
