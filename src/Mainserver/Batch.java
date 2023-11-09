package Mainserver;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Basicfunctionalities.perform;

public class Batch {
    
   public static void createbatch(WebDriver driver,String url, String batchname)
   {
       driver.get(url);
       perform.clickButton(driver, "//img[@class=\"cursor-pointer\"]", Duration.ofSeconds(10));
       perform.clickButton(driver, "//a[@href=\"/batch/list\"]", Duration.ofSeconds(10));
       perform.clickButton(driver, "//button[@class=\"btn btn-theme my-4 mr-4 create-btn tooltip-down\"]", Duration.ofSeconds(10));
       perform.sendKeys(driver, "//input[@id=\"batch-title\"]", Duration.ofSeconds(10), batchname);

       WebElement dropdown= driver.findElement(By.xpath("//select[@id=\"batchAdministrator\"]"));
       Select select = new Select(dropdown);
       select.selectByVisibleText("Pankaj mentor");
       perform.clickButton(driver, "//button[@id=\"submitBatchBtnContainer\"]", Duration.ofSeconds(10));
       System.out.println("Batch created");

    }
    


    
    public static void Findbatch(WebDriver driver, String url, String batchname) throws InterruptedException
    {
        driver.get(url);
        perform.sendKeys(driver, "//input[@id=\"input-search-header\"]", Duration.ofSeconds(10), batchname);
        Thread.sleep(2000);
        List <WebElement> list=driver.findElements(By.xpath("//tbody//tr[@role=\"row\"]"));
        int rows= list.size();
        if(rows<=0)
        {
             System.out.println("Batch not found");
             return;
        }
        else if(rows==1)
        {
            perform.clickButton(driver, "(//a[@data-customtooltip=\"View users\"])[1]",  Duration.ofSeconds(10));
        }
        else
        {
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy\nHH:mm");
          int latestindex=1;
          LocalDateTime maxtime=null;
           for(int i=0;i<rows;i++)
           {
                 String text=driver.findElement(By.xpath("(//tbody//tr[@role=\"row\"])[" +( i+1 )+"]//td[5]")).getText();
                 LocalDateTime time=LocalDateTime.parse(text,formatter);
                 
                 if(maxtime==null)
                 {
                    maxtime=time;           
                 }
                 else
                 {
                    int result=time.compareTo(maxtime);
                    if(result<0){
                        continue;
                    }
                    else if(result>0){
                        maxtime=time;
                        latestindex=i+1;
                    }
                    else{
                        System.out.println("Eaual time");
                    } 
                 }
                    
           }
            System.out.println(maxtime);
            perform.clickButton(driver,"(//a[@data-customtooltip=\"View users\"])[" + latestindex + "]", Duration.ofSeconds(10));
        }
    }

    public static void Addlearners(WebDriver driver, String url){

        driver.get(url);
        perform.clickButton(driver, "//a[@class=\"btn btn-theme mr-3 create-btn tooltip-down\"]", Duration.ofSeconds(10));
    }
}
