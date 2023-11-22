package Mainserver;

import java.io.IOException;
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
    
   public static void createbatch(WebDriver driver, String url, String batchname)
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
         try
            {
                Thread.sleep(2000);
                List <WebElement> rowslist = driver.findElements(By.xpath("//table[@id=\"mentor-data-table\"]//tr[ @class='even' or @class='odd']"));
                
                int total=rowslist.size();
                if(rowslist.size()<=0)
                {
                  System.out.println("No questions in my organization to add");
                  return;
                }
                else
                {
                    System.out.println("total questions in page "+total);
                    int count = 1;
                    while(count<=3)
                    {
                        try
                        {
                            perform.clickButton(driver, "//table[@id=\"mentor-data-table\"]//tr[" + count + "]//td//input[@type='checkbox']", Duration.ofSeconds(10));
                          
                            count++;
                        }
                        catch(Exception e)
                        {
                            System.out.println("again here");   
                            System.out.println("Stale Exception");                
                        }
                    }
                } 
             perform.clickButton(driver,  " //button[@type='button'][normalize-space()='Save']", Duration.ofSeconds(10));
            }
            catch(Exception e){
                   System.out.println("Error in selecting Learners"); 
            }   


    }
     
    public static void Addbulkusers(WebDriver driver, String url) throws IOException, InterruptedException{
        driver.get(url);
        perform.clickButton(driver, "//button[@data-customtooltip=\"Bulk add users\"]",  Duration.ofSeconds(10));
        perform.clickButton(driver, "//label[@for=\"upldFile\"]", Duration.ofSeconds(10));

        String path="C:\\Users\\Pankaj Thakur\\Documents\\script.au3";
        ProcessBuilder processbuilder = new ProcessBuilder("C:\\Program Files (x86)\\AutoIt3\\AutoIt3.exe", path);
        Process process = processbuilder.start();
        process.waitFor();
        perform.clickButton(driver, "//button[@type=\"submit\"][normalize-space()=\"Upload\"]", Duration.ofSeconds(10));
        }

    public static void Removelearner(WebDriver driver, String url, String email) throws InterruptedException{
       
        driver.get(url);
        perform.sendKeys(driver, "//input[@placeholder=\"Search in batch\"]", Duration.ofSeconds(10), email);
        Thread.sleep(2000);

        perform.clickButton(driver, "//tr[@class=\"even\" or @class=\"odd\"]//td[15]", Duration.ofSeconds(10));
        perform.clickButton(driver, "//button[@id=\"yes-btn-modal\"]", Duration.ofSeconds(10));
        Thread.sleep(500);

        boolean result= perform.isElementVisible(driver, "//div[@class='toast-alert success-alert visible']", Duration.ofSeconds(10));
        if(result)
        {
            String message=driver.findElement(By.xpath("//div[@class='toast-alert success-alert visible']")).getText();
            System.out.println(message);
        }
    }   
     
}
