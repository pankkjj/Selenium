package Addquestions;
import Basicfunctionalities.*;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class addquestions {

    public static void Addbymarks(WebDriver driver,String id) throws InterruptedException{

            // driver.get("https://test.cqtestga.com/test/addQuizContent/"+id);
            driver.get(id);
            Basic.clickButton(driver,  "//a[contains(text(),'+ create new section')]", Duration.ofSeconds(10));
            Thread.sleep(2000);
            
            if(Basic.isElementVisible(driver, "//div[@class='modal-alert-msg color-1 visible-alert-modal']", Duration.ofSeconds(10))) 
            {
                System.out.println(driver.findElement(By.xpath("//div[@class='modal-alert-msg color-1 visible-alert-modal']")).getText());
            }
            else{
                System.out.println("alert didn't appear");
            }
            List<WebElement>sections=driver.findElements(By.xpath("//div[@class='sections']")); 
            Basic.clickButton(driver,  "(//a[@class=\"btn ml-3 add-btn-new add-content-link\"])[" + sections.size() + "]", Duration.ofSeconds(10)); 
        
            Basic.clickButton(driver, "//div[@class='filter-input-section']", Duration.ofSeconds(10));
            Basic.clickButton(driver,  "//li[@onclick=\"openItemDropdoen('type-items')\"]", Duration.ofSeconds(10));
            Basic.clickButton(driver,  "//label[normalize-space()='Coding']", Duration.ofSeconds(10));
            Basic.clickButton(driver,  "//button[@class='btn apply-btn type-apply-btn']", Duration.ofSeconds(10));
            Thread.sleep(2000);
            
            int count = 1;
            while(count<5)
            {
                try{
                     
                    WebElement score=driver.findElement(By.xpath("(//tr[@role='row']["+ count +"]//td[8])"));
                    int marks=Integer.parseInt(score.getText());
                    if(marks>0){

                        System.out.println(marks+"  "+count+ "(//tr[@role='row']["+ count +"]//td[8])" );
                        System.out.println(driver.findElement(By.xpath("(//tr[@role='row']["+ count +"]//td[3])")).getText());
                        Basic.clickButton(driver, "(//tr[@role='row'][" + count  + "]//td//input[@type='checkbox'])", Duration.ofSeconds(5));

                    }
                    
                    count++;

                }catch(Exception e){
                      
                  System.out.println("Stale exception");
                  
                }
            }

            Basic.clickButton(driver,  " //button[@type='button'][normalize-space()='save']", Duration.ofSeconds(10));    

    }

    public static void Bykeywords(WebDriver driver, String id, String keyword) throws InterruptedException{
         
        // driver.get("https://test.cqtestga.com/test/addQuizContent/"+id);
        driver.get(id);
        Basic.clickButton(driver,  "//a[contains(text(),'+ create new section')]", Duration.ofSeconds(10));
        Thread.sleep(2000);
            
     
        if(Basic.isElementVisible(driver, "//div[@class='modal-alert-msg color-1 visible-alert-modal']", Duration.ofSeconds(10))) 
        {
            System.out.println(driver.findElement(By.xpath("//div[@class='modal-alert-msg color-1 visible-alert-modal']")).getText());
        }
        else{
            System.out.println("alert didn't appear");
        }

        List<WebElement>sections=driver.findElements(By.xpath("//div[@class='sections']")); 
        Basic.clickButton(driver,  "(//a[@class=\"btn ml-3 add-btn-new add-content-link\"])[" + sections.size() + "]", Duration.ofSeconds(10)); 
        List <WebElement> filters=driver.findElements(By.xpath("(//img[starts-with(@onclick,'tagclear')])"));
        int i=1;
        while(i<=filters.size())
        {
            Basic.clickButton(driver, "(//img[starts-with(@onclick,'tagclear')])["+ i + "]", Duration.ofSeconds(10));
            i++;
        }
        Basic.clickButton(driver, "//input[@class=\"filter-input\"]", Duration.ofSeconds(10));
        Basic.clickButton(driver, "//li[normalize-space()=\"Keyword\"]", Duration.ofSeconds(10));
     

        Basic.clickButton(driver, "//label[@title='"+ keyword +"' ]", Duration.ofSeconds(10));
        Basic.clickButton(driver, "//button[@class=\"btn apply-btn keyword-apply-btn\" ]", Duration.ofSeconds(10));
       
    }

    public static void Codequotient(WebDriver driver,String id) throws InterruptedException{

        // driver.get("https://test.cqtestga.com/test/addQuizContent/"+id);
        driver.get(id);
        Basic.clickButton(driver,  "//a[contains(text(),'+ create new section')]", Duration.ofSeconds(10));
        Thread.sleep(2000);
        
 
        if(Basic.isElementVisible(driver, "//div[@class='modal-alert-msg color-1 visible-alert-modal']", Duration.ofSeconds(10))) 
        {
            System.out.println(driver.findElement(By.xpath("//div[@class='modal-alert-msg color-1 visible-alert-modal']")).getText());
        }
        else{
            System.out.println("alert didn't appear");
        }

        List<WebElement>sections=driver.findElements(By.xpath("//div[@class='sections']")); 
        Basic.clickButton(driver,  "(//a[@class=\"btn ml-3 add-btn-new add-content-link\"])[" + sections.size() + "]", Duration.ofSeconds(10)); 

        Basic.clickButton(driver, "//button[@data-id=\"fltrQBy\"]", Duration.ofSeconds(10)); 
        Basic.clickButton(driver, "//a[normalize-space()=\"CodeQuotient\"]", Duration.ofSeconds(10));
        
      
   }

    public static void organization(WebDriver driver,String url) throws InterruptedException{
    driver.get(url);
    Thread.sleep(1000);
    Basic.clickButton(driver,  "//a[contains(text(),'+ create new section')]", Duration.ofSeconds(10));
    Thread.sleep(2000);
    
    if(Basic.isElementVisible(driver, "//div[@class='modal-alert-msg color-1 visible-alert-modal']", Duration.ofSeconds(10))) 
    {
        System.out.println(driver.findElement(By.xpath("//div[@class='modal-alert-msg color-1 visible-alert-modal']")).getText());
    }
    else{
        System.out.println("alert didn't appear");
    }
    List<WebElement>sections=driver.findElements(By.xpath("//div[@class='sections']")); 
    Basic.clickButton(driver,  "(//a[@class=\"btn ml-3 add-btn-new add-content-link\"])[" + sections.size() + "]", Duration.ofSeconds(10)); 
    
    Basic.clickButton(driver, "//button[@title=\"My Questions\"]", Duration.ofSeconds(10)); 
    Basic.clickButton(driver, "//a[normalize-space()=\"My Organization\"]", Duration.ofSeconds(10)); 
   }

    public static void quesperpage(WebDriver driver,String id,String count) throws InterruptedException 
    {
        driver.get("https://test.cqtestga.com/test/addQuizContent/"+id);
         Basic.clickButton(driver,  "//a[contains(text(),'+ create new section')]", Duration.ofSeconds(10));
            Thread.sleep(2000);
          
            if(Basic.isElementVisible(driver, "//div[@class='modal-alert-msg color-1 visible-alert-modal']", Duration.ofSeconds(10))) 
            {
                System.out.println(driver.findElement(By.xpath("//div[@class='modal-alert-msg color-1 visible-alert-modal']")).getText());
            }
            else{
                System.out.println("alert didn't appear");
            }
            
            List<WebElement>sections=driver.findElements(By.xpath("//div[@class='sections']")); 
            Basic.clickButton(driver,  "(//a[@class=\"btn ml-3 add-btn-new add-content-link\"])[" + sections.size() + "]", Duration.ofSeconds(10));
            
            WebElement dropdown=driver.findElement(By.xpath("//select[@name=\"tblCCLs_length\"]"));
            Select select=new Select(dropdown);
            select.selectByVisibleText(count);

    }

    public static void getcount(WebDriver driver,String id) throws InterruptedException
    {
           driver.get("https://test.cqtestga.com/test/addQuizContent/"+id);
           Basic.clickButton(driver,  "//a[contains(text(),'+ create new section')]", Duration.ofSeconds(10));
           Thread.sleep(2000);
         
           if(Basic.isElementVisible(driver, "//div[@class='modal-alert-msg color-1 visible-alert-modal']", Duration.ofSeconds(10))) 
           {
               System.out.println(driver.findElement(By.xpath("//div[@class='modal-alert-msg color-1 visible-alert-modal']")).getText());
           }
           else{
               System.out.println("alert didn't appear");
           }
           
           List<WebElement>sections=driver.findElements(By.xpath("//div[@class='sections']")); 
           Basic.clickButton(driver,  "(//a[@class=\"btn ml-3 add-btn-new add-content-link\"])[" + sections.size() + "]", Duration.ofSeconds(10));
           Thread.sleep(500);
           List <WebElement> pages=driver.findElements(By.xpath("//a[starts-with(@class,\"paginate_button \")]")); 
           int totalpages=pages.size()-1;
           Basic.clickButton(driver, "(//a[starts-with(@class,'paginate_button')])["+ totalpages +"]", Duration.ofSeconds(10));
           Thread.sleep(1000);

           List <WebElement> rowslist = driver.findElements(By.xpath("//tr[ @class='even' or @class='odd']"));
           WebElement lastnumber=driver.findElement(By.xpath("//tr[@role='row'][" + rowslist.size() + "]//td[2]"));
           System.out.println("Total number of questions are:" + lastnumber.getText());
    } 
}
