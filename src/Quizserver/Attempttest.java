package Quizserver;

import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.formula.eval.ConcatEval;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Basicfunctionalities.Basic;
import Basicfunctionalities.takescreenshot;

public class Attempttest {
    
    
    public static void login(WebDriver driver,String testlink, String email, String password, String testcode) throws InterruptedException
    {
        driver.get(testlink);
        Thread.sleep(1000);
        Basic.sendKeys(driver, "//input[@id='email']", Duration.ofSeconds(10), email);
        Basic.sendKeys(driver, "//input[@id='password']", Duration.ofSeconds(10), password);
        Basic.sendKeys(driver, "//input[@id='quizCode']", Duration.ofSeconds(10), testcode); 
        Basic.clickButton(driver, "//button[@type='submit']", Duration.ofSeconds(10));
        if(Basic.isElementVisible(driver, "//div[@class=\"ant-message\"]", Duration.ofSeconds(3))){
            System.out.println(driver.findElement(By.xpath("//div[@class=\"ant-message\"]")).getText());
            takescreenshot.shot(driver, "logInError");
            return;
        }
        Thread.sleep(2000);
        if(Basic.isElementVisible(driver, "//button[normalize-space()=\"Full Screen\"]", Duration.ofSeconds(3))){
            Basic.clickButton(driver, "//button[normalize-space()=\"Full Screen\"]", Duration.ofSeconds(3));
        }  
        if(( driver.getCurrentUrl().contains("details"))){
            Basic.clickButton(driver, "//button[normalize-space()=\"start test\"]", Duration.ofSeconds(10));
        }
        // start(driver);
      
    }

    public static void signup(WebDriver driver, String testlink, String email, String password, String testcode, String name, String screenshotPath) throws InterruptedException
    {
        driver.get(testlink);
        Thread.sleep(1000);
        Basic.clickButton(driver, "//button[normalize-space()=\"sign up\"]", Duration.ofSeconds(10));
        Basic.find(driver, "//input[@id='name']", Duration.ofSeconds(5)).sendKeys(name);
        Basic.find(driver, "//input[@id='email']", Duration.ofSeconds(5)).sendKeys(email);
        Basic.find(driver, "//input[@id='password']", Duration.ofSeconds(5)).sendKeys(password);
        Basic.find(driver, "//input[@id='quizCode']", Duration.ofSeconds(5)).sendKeys(testcode);
        String mobile = generateRandomMobileNumber();
        Basic.find(driver, "//input[@id='mobile']", Duration.ofSeconds(5)).sendKeys(mobile);
        Basic.clickButton(driver, "(//button[normalize-space()='sign up'])[2]", Duration.ofSeconds(5));

        if(Basic.isElementVisible(driver, "//div[@class=\"ant-message\"]", Duration.ofSeconds(3))){
            System.out.println(driver.findElement(By.xpath("//div[@class=\"ant-message\"]")).getText());
            takescreenshot.shot(driver, "SignUpError");
            return;
        }
        Thread.sleep(2000);
        if(Basic.isElementVisible(driver, "//button[normalize-space()=\"Full Screen\"]", Duration.ofSeconds(3))){
            Basic.clickButton(driver, "//button[normalize-space()=\"Full Screen\"]", Duration.ofSeconds(3));
        }  
        else{
            takescreenshot.shot(driver,"NoFullScreen");
        }
        if(( driver.getCurrentUrl().contains("details"))){
            Basic.clickButton(driver, "//button[normalize-space()=\"start test\"]", Duration.ofSeconds(3));
        }
        startTest st = new startTest(driver);
        checkalert ca = new checkalert(driver);
        Thread startthread = new Thread(st);   
        Thread alertthread = new Thread(ca);
  
        startthread.start();
        alertthread.start();    
        
        Boolean check = true;
        while (check) {
            if(startthread.isInterrupted())
            {
                alertthread.interrupt();
                check = false;
            }
        }
        
        // start(driver);
    }
        
    // public static void start(WebDriver driver) throws InterruptedException{
    //     Actions actions = new Actions(driver);
    //     Thread.sleep(2000);
    //     List<WebElement> elements = driver.findElements(By.xpath("//td[@class=\"ant-table-cell question-type\"]"));
    //     int i = 0;
    //     System.out.println(elements.size());
    //     while(i<elements.size()){
    //         WebElement[] updatedarray = updateElements(driver);
    //         String questype = updatedarray[i].getText();
    //         if(questype.equals("MCQ"))
    //         {
    //             System.out.println("Mcq found");
    //             Basic.clickButton(driver, "(//td[@class='ant-table-cell question-actions'])[" + (i+1) + "]//a", Duration.ofSeconds(10));
    //             attemptmcq(driver, 2);
    //         }
    //         else if (questype.equals("Coding")) {
    //             System.out.println("Coding found");
    //             Thread.sleep(1000);
    //             Basic.clickButton(driver, "(//td[@class='ant-table-cell question-actions'])[" + (i+1) + "]//a", Duration.ofSeconds(10));
    //             attemptcoding(driver,actions);
    //         }
    //         else if (questype.equals("Subjective")) {
    //             System.out.println("Subjective found");
                
    //             Basic.clickButton(driver, "(//td[@class='ant-table-cell question-actions'])[" + (i+1) + "]//a", Duration.ofSeconds(10));
    //             attemptsubjective(driver);
    //         }
    //         else if (questype.equals("Web")) {
    //             System.out.println("Web found");
    //             Basic.clickButton(driver, "(//td[@class='ant-table-cell question-actions'])[" + (i+1) + "]//a", Duration.ofSeconds(10));
    //             attemptweb(driver, actions);
    //         }
    //         else if(questype.equals("MQ")) {
    //             System.out.println("MQ found");
    //             Basic.clickButton(driver, "(//td[@class='ant-table-cell question-actions'])[" + (i+1) + "]//a", Duration.ofSeconds(10));
    //             attemptMQ(driver);
    //         }
    //         else{
    //             takescreenshot.shot(driver, "queNotFound");
    //         }

    //         i++;
    //     }
      
    //    Basic.clickButton(driver, "//button[normalize-space()=\"Submit Test\"]", Duration.ofSeconds(2));
    //    Basic.clickButton(driver, "//button[normalize-space()=\"yes\"]", Duration.ofSeconds(2));

    //    submitfeedback(driver);
    // }

   

   


    

     public static String generateRandomMobileNumber() {
        Random random = new Random();
        StringBuilder mobileNumber = new StringBuilder();

        mobileNumber.append(String.format("%03d", random.nextInt(900) + 100)); 
        mobileNumber.append(String.format("%03d", random.nextInt(900) + 100)); 
        mobileNumber.append(String.format("%04d", random.nextInt(10000)));     

        return mobileNumber.toString();
    }

}

class startTest implements Runnable{
    WebDriver driver;

    public startTest(WebDriver driver){
        this.driver= driver;
    }
    

    @Override
    public void run() {
      Actions actions = new Actions(driver);
        try 
        {
            Thread.sleep(2000);
            List<WebElement> elements = driver.findElements(By.xpath("//td[@class=\"ant-table-cell question-type\"]"));
            int i = 0;
            System.out.println(elements.size());
            while(i<elements.size())
            {
                WebElement[] updatedarray = updateElements(driver);
                String questype = updatedarray[i].getText();
                if(questype.equals("MCQ"))
                {
                    System.out.println("Mcq found");
                    Basic.clickButton(driver, "(//td[@class='ant-table-cell question-actions'])[" + (i+1) + "]//a", Duration.ofSeconds(10));
                    attemptmcq(driver, 2);
                }
                else if (questype.equals("Coding")) {
                    System.out.println("Coding found");
                    Thread.sleep(1000);
                    Basic.clickButton(driver, "(//td[@class='ant-table-cell question-actions'])[" + (i+1) + "]//a", Duration.ofSeconds(10));
                    attemptcoding(driver,actions);
                }
                else if (questype.equals("Subjective")) {
                    System.out.println("Subjective found");
                    
                    Basic.clickButton(driver, "(//td[@class='ant-table-cell question-actions'])[" + (i+1) + "]//a", Duration.ofSeconds(10));
                    attemptsubjective(driver);
                }
                else if (questype.equals("Web")) {
                    System.out.println("Web found");
                    Basic.clickButton(driver, "(//td[@class='ant-table-cell question-actions'])[" + (i+1) + "]//a", Duration.ofSeconds(10));
                    attemptweb(driver, actions);
                }
                else if(questype.equals("MQ")) {
                    System.out.println("MQ found");
                    Basic.clickButton(driver, "(//td[@class='ant-table-cell question-actions'])[" + (i+1) + "]//a", Duration.ofSeconds(10));
                    attemptMQ(driver);
                }
                else{
                    takescreenshot.shot(driver, "queNotFound");
                }

               i++;
           }
      
            Basic.clickButton(driver, "//button[normalize-space()=\"Submit Test\"]", Duration.ofSeconds(2));
            Basic.clickButton(driver, "//button[normalize-space()=\"yes\"]", Duration.ofSeconds(2));

            submitfeedback(driver);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
     public static void attemptmcq(WebDriver driver , int option) throws InterruptedException
    {
        Basic.clickButton(driver, "(//label[@class=\"ant-radio-wrapper ant-radio-wrapper-in-form-item\"])[" + option + "]//span[2]", Duration.ofSeconds(10));
        Basic.clickButton(driver, "//div[@class=\"submit-mcq-container\"]//button", Duration.ofSeconds(10));
        Thread.sleep(500);
        WebElement successMsg=Basic.find(driver, "//div[@class='ant-message']", Duration.ofSeconds(10));
        System.out.println(successMsg.getText());
        Basic.clickButton(driver, "//button[@class=\"ant-btn ant-btn-circle ant-btn-text ant-btn-lg ant-btn-icon-only\"]", Duration.ofSeconds(10));
    }
     
     public static void attemptcoding(WebDriver driver, Actions actions ) throws InterruptedException
    {
           
        Thread.sleep(1000);
        WebElement element = Basic.find(driver, "//span[@class='ant-select-selection-item']", Duration.ofSeconds(10));
        if(element.getText().equals("C++"))
        {
              System.out.println("C++");
              for(int i=0;i<3;i++)
              {
                if(i==0){
                   writeCPP("error", driver, actions); 
                }
                else if(i==1){
                   writeCPP("pass", driver, actions); 
                }
                else{
                   writeCPP("fail", driver, actions); 
                }
                Basic.clickButton(driver, "//button[normalize-space()=\"submit\"]", Duration.ofSeconds(10));
                Thread.sleep(1000);
                Basic.clickButton(driver, "//button[normalize-space()=\"stay\"]", Duration.ofSeconds(10));
              }
              Thread.sleep(1000); 
              Basic.clickButton(driver, 
              "//button[@class=\"ant-btn ant-btn-circle ant-btn-text ant-btn-lg ant-btn-icon-only\"]",
              Duration.ofSeconds(10));
        }
        else if(element.getText().equals("C"))
        {
             System.out.println("c");
             for(int i=0;i<3;i++)
             {
                if(i==0){
                   writeC("error",driver,actions); 
                }
                else if(i==1){
                   writeC("pass",driver,actions); 
                }
                else{
                   writeC("fail",driver,actions); 
                }
                
                Basic.clickButton(driver, "//button[normalize-space()=\"submit\"]", Duration.ofSeconds(10));
                Thread.sleep(1000);
                Basic.clickButton(driver, "//button[normalize-space()=\"stay\"]", Duration.ofSeconds(10));

             } 
             
             Thread.sleep(1000);
             Basic.clickButton(driver,
              "//button[@class=\"ant-btn ant-btn-circle ant-btn-text ant-btn-lg ant-btn-icon-only\"]", 
             Duration.ofSeconds(10));
        }
        else if(element.getText().equals("C#"))
        {
             System.out.println("c#");

             for(int i=0;i<3;i++)
             {
                if(i==0){
                   writeCsharp("error",driver,actions); 
                }
                else if(i==1){
                   writeCsharp("pass",driver,actions); 
                }
                else{
                   writeCsharp("fail",driver,actions); 
                }
                
                Basic.clickButton(driver, "//button[normalize-space()=\"submit\"]", Duration.ofSeconds(10));
                Thread.sleep(1000);
                Basic.clickButton(driver, "//button[normalize-space()=\"stay\"]", Duration.ofSeconds(10));

             } 
             Thread.sleep(1000);
             Basic.clickButton(driver,
             "//button[@class=\"ant-btn ant-btn-circle ant-btn-text ant-btn-lg ant-btn-icon-only\"]",
             Duration.ofSeconds(10));
        }
         else if(element.getText().equals("Java"))
        {
             System.out.println("Java");
             
             for(int i=0;i<3;i++)
             {
                if(i==0){
                    System.out.println("calling for error");
                   writeJava("error", driver, actions); 
                }
                else if(i==1){
                    System.out.println("calling for pass");
                   writeJava("pass", driver, actions); 
                }
                else{
                    System.out.println("calling for fail");
                   writeJava("fail", driver, actions); 
                }
                
                Basic.clickButton(driver, "//button[normalize-space()=\"submit\"]", Duration.ofSeconds(10));
                Thread.sleep(1000);
                Basic.clickButton(driver, "//button[normalize-space()=\"stay\"]", Duration.ofSeconds(10));

             }
             Thread.sleep(1000);             
             Basic.clickButton(driver,
              "//button[@class=\"ant-btn ant-btn-circle ant-btn-text ant-btn-lg ant-btn-icon-only\"]",
             Duration.ofSeconds(10));
        }
         else if(element.getText().equals("Python 3"))
        {
           System.out.println("Python 3");
           for(int i=0;i<3;i++)
             {
                if(i==0){
                   writePython("error", driver, actions); 
                }
                else if(i==1){
                   writePython("pass", driver, actions);  
                }
                else{
                   writePython("fail", driver, actions);  
                }
                
                Basic.clickButton(driver, "//button[normalize-space()=\"submit\"]", Duration.ofSeconds(10));
                Thread.sleep(1000);
                Basic.clickButton(driver, "//button[normalize-space()=\"stay\"]", Duration.ofSeconds(10));

             }
            Thread.sleep(1000);
           Basic.clickButton(driver,
            "//button[@class=\"ant-btn ant-btn-circle ant-btn-text ant-btn-lg ant-btn-icon-only\"]",
           Duration.ofSeconds(10));
        }
         else if(element.getText().equals("JavaScript"))
        {
            System.out.println("js");
             for(int i=0;i<3;i++)
             {
                if(i==0){
                   writeJS("error", driver, actions); 
                }
                else if(i==1){
                   writeJS("pass", driver, actions); 
                }
                else{
                   writeJS("fail", driver, actions); 
                }
                
                Basic.clickButton(driver, "//button[normalize-space()=\"submit\"]", Duration.ofSeconds(10));
                Thread.sleep(1000);
                Basic.clickButton(driver, "//button[normalize-space()=\"stay\"]", Duration.ofSeconds(10));

             }
             Thread.sleep(1000);
            Basic.clickButton(driver,
            "//button[@class=\"ant-btn ant-btn-circle ant-btn-text ant-btn-lg ant-btn-icon-only\"]", 
            Duration.ofSeconds(10));
        }
        else if(element.getText().equals("Php"))
        {
              System.out.println("Php");
              for(int i=0;i<3;i++)
              {
                if(i==0){
                   writePhp("error", driver, actions); 
                }
                else if(i==1){
                   writePhp("pass", driver, actions); 
                }
                else{
                   writePhp("fail", driver, actions); 
                }
                
                Basic.clickButton(driver, "//button[normalize-space()=\"submit\"]", Duration.ofSeconds(10));
                Thread.sleep(1000);
                Basic.clickButton(driver, "//button[normalize-space()=\"stay\"]", Duration.ofSeconds(10));
              }
             Thread.sleep(1000);
              Basic.clickButton(driver,
               "//button[@class=\"ant-btn ant-btn-circle ant-btn-text ant-btn-lg ant-btn-icon-only\"]",
              Duration.ofSeconds(10));
        } 
          
    }
     
     public static void attemptsubjective(WebDriver driver) throws InterruptedException{
        Actions actions = new Actions(driver);
        if(Basic.isElementVisible(driver, "//div[@class='ql-editor ql-blank']", Duration.ofSeconds(2)))
        {    
               actions.click(driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")))
               .sendKeys("Subjective answer").perform();        
        }
        else{
            actions.click(driver.findElement(By.xpath("//div[@class='ql-editor']")))
            .keyDown(Keys.SHIFT)
            .sendKeys(Keys.PAGE_UP)
            .keyUp(Keys.SHIFT)
            .sendKeys(Keys.BACK_SPACE)
            .sendKeys("Subjective answer").perform();
        } 
        
        if(Basic.isElementVisible(driver, "//span[@class=\"anticon anticon-upload\"]", Duration.ofSeconds(2))){
            Basic.clickButton(driver, "//button[normalize-space()='Select file to upload']", Duration.ofSeconds(2));
            uploadfile(driver);
        }
        
        Thread.sleep(1000);
        Basic.clickButton(driver, "//div[@class=\"submit-subjective-container\"]//button", Duration.ofSeconds(2));
        Thread.sleep(3000);
        WebElement successMsg=Basic.find(driver, "//div[@class='ant-message']", Duration.ofSeconds(10));
        System.out.println(successMsg.getText());
        Basic.clickButton(driver, "//button[@class=\"ant-btn ant-btn-circle ant-btn-text ant-btn-lg ant-btn-icon-only\"]", Duration.ofSeconds(10));
    } 
    
    public static void attemptMQ(WebDriver driver) throws InterruptedException{
        Thread.sleep(500);
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='ant-form-item-control-input-content']//textarea"));
       
        int i=1;
        Actions actions = new Actions(driver);
        for(WebElement element : elements){
            actions.click(element)
            .keyDown(Keys.CONTROL)
            .sendKeys("a")
            .keyUp(Keys.CONTROL)
            .sendKeys(Keys.BACK_SPACE)
            .sendKeys(Integer.toString(i)).perform();
            i++;
        }
        Basic.clickButton(driver, "//div[@class=\"submit-mq-container\"]//button", Duration.ofSeconds(2));
        Thread.sleep(500);
        WebElement successMsg=Basic.find(driver, "//div[@class='ant-message']", Duration.ofSeconds(10));
        System.out.println(successMsg.getText());
        Basic.clickButton(driver, "//button[@class=\"ant-btn ant-btn-circle ant-btn-text ant-btn-lg ant-btn-icon-only\"]", Duration.ofSeconds(10));

    }
    
    public static void attemptweb(WebDriver driver, Actions actions) throws InterruptedException
    {
       
        actions.click(Basic.find(driver, "(//div[@class=\"ace_content\"])[1]", Duration.ofSeconds(5)))
            .keyDown(Keys.SHIFT)
            .sendKeys(Keys.PAGE_UP)
            .keyUp(Keys.SHIFT)
            .sendKeys(Keys.BACK_SPACE)
            .sendKeys("<p>Hello world",Keys.ENTER)
            .perform(); 
        
        Basic.clickButton(driver, "(//div[@class='ant-tabs-tab'])[1]", Duration.ofSeconds(5));
        actions.click(Basic.find(driver, "(//div[@class=\"ace_content\"])[2]", Duration.ofSeconds(5)))
            .keyDown(Keys.SHIFT)
            .sendKeys(Keys.PAGE_UP)
            .keyUp(Keys.SHIFT)
            .sendKeys(Keys.BACK_SPACE)
            .sendKeys("p{",Keys.ENTER)
            .sendKeys("color:red;",Keys.ENTER)
            .perform();   
        
        Basic.clickButton(driver, "//div[@class='ant-tabs-tab'][2]", Duration.ofSeconds(5));
        actions.click(Basic.find(driver, "(//div[@class=\"ace_content\"])[3]", Duration.ofSeconds(5)))
            .keyDown(Keys.SHIFT)
            .sendKeys(Keys.PAGE_UP)
            .keyUp(Keys.SHIFT)
            .sendKeys(Keys.BACK_SPACE)
            .sendKeys("let txt = document.getElementsByTagName(\"p\")[0]",Keys.ENTER)
            .sendKeys("txt.addEventListener(\"click\", ()=>{txt.innerText = \"Welcome\"})")
            .perform();
        
        Thread.sleep(500);
        Basic.clickButton(driver, "//button[normalize-space()='submit']", Duration.ofSeconds(2));  
        Thread.sleep(3000);
        WebElement successMsg=Basic.find(driver, "//div[@class='ant-message']", Duration.ofSeconds(10));
        System.out.println(successMsg.getText());
        Basic.clickButton(driver, "//button[@class=\"ant-btn ant-btn-circle ant-btn-text ant-btn-lg ant-btn-icon-only\"]", Duration.ofSeconds(10));  
    
    }

    public static void submitfeedback(WebDriver driver) throws InterruptedException{ 
        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        actions.moveToElement(driver.findElement(By.xpath("//textarea")))
        .sendKeys("ore wa Monkey.D.Luffy kaizokuō ni ore wa naru!").perform();
        Basic.clickButton(driver, "//button[normalize-space()=\"Submit\"]", Duration.ofSeconds(2));
        Thread.sleep(3000);
    }

    public static WebElement[] updateElements(WebDriver driver) throws InterruptedException{
        Thread.sleep(1000);
        List<WebElement> elements = driver.findElements(By.xpath("//td[@class=\"ant-table-cell question-type\"]"));
        WebElement[] updatedarr = elements.toArray(new WebElement[0]);
        return updatedarr;
    }

    public static void writeC(String type,WebDriver driver, Actions actions) throws InterruptedException
    {   
        Thread.sleep(1000);
        if(type.equals("error"))
        {
               System.out.println("Writing error");
               actions.click(Basic.find(driver, "//div[@class='ace_content']", Duration.ofSeconds(5)))
               .keyDown(Keys.SHIFT)
               .sendKeys(Keys.PAGE_UP)
               .keyUp(Keys.SHIFT)
               .sendKeys(Keys.BACK_SPACE)
               .sendKeys("int a , b;")
               .sendKeys("scanf( \" %d %d \", &a ,&b)")
               .sendKeys("printf(\" %d \", a+b);")
               .perform(); 
              
        }
        else if(type.equals("pass"))
        {
           System.out.println("Writing pass");
           actions.click(Basic.find(driver, "//div[@class='ace_content']", Duration.ofSeconds(5)))
           .keyDown(Keys.SHIFT)
           .sendKeys(Keys.PAGE_UP)
           .keyUp(Keys.SHIFT)
           .sendKeys(Keys.BACK_SPACE)
           .sendKeys("int a , b;")
           .sendKeys("scanf( \" %d %d \", &a ,&b);")
           .sendKeys("printf(\" %d \", a+b);")
           .perform();
          
        }
        else
        {
            System.out.println("Writing fail");
            actions.click(Basic.find(driver, "//div[@class='ace_content']", Duration.ofSeconds(5)))
           .keyDown(Keys.SHIFT)
           .sendKeys(Keys.PAGE_UP)
           .keyUp(Keys.SHIFT)
           .sendKeys(Keys.BACK_SPACE)
           .sendKeys("int a , b;")
           .sendKeys("scanf( \" %d %d \", &a ,&b);")
           .sendKeys("printf(\" %d \", a+a);")
           .perform(); 
           
        }
        Thread.sleep(1000);
    }

   public static void writeCPP(String type,WebDriver driver, Actions actions) throws InterruptedException
    {   
        Thread.sleep(500);
        if(type.equals("error"))
        {
               System.out.println("Writing error");
               actions.click(Basic.find(driver, "//div[@class='question-attempt-pane']", Duration.ofSeconds(5)))
               .keyDown(Keys.SHIFT)
               .sendKeys(Keys.PAGE_UP)
               .keyUp(Keys.SHIFT)
               .sendKeys(Keys.BACK_SPACE)
               .sendKeys("int a , b;")
               .sendKeys("scanf( \" %d %d \", &a ,&b)",Keys.ENTER)
               .sendKeys("printf(\" %d \", a+b);")
               .perform(); 
        }
        else if(type.equals("pass"))
        {
           System.out.println("Writing pass");
           Thread.sleep(1000);
           actions.click(Basic.find(driver, "//div[@class='question-attempt-pane']", Duration.ofSeconds(5)))
           .keyDown(Keys.SHIFT)
           .sendKeys(Keys.PAGE_UP)
           .keyUp(Keys.SHIFT)
           .sendKeys(Keys.BACK_SPACE)
           .sendKeys("int a,b;")
           .sendKeys("cin>>a>>b;")
           .sendKeys("cout<<a+b;")
           .perform(); 
        }
        else
        {
            System.out.println("Writing fail");
            Thread.sleep(1000);
            actions.click(Basic.find(driver, "//div[@class='question-attempt-pane']", Duration.ofSeconds(5)))
           .keyDown(Keys.SHIFT)
           .sendKeys(Keys.PAGE_UP)
           .keyUp(Keys.SHIFT)
           .sendKeys(Keys.BACK_SPACE)
           .sendKeys("int a,b;")
           .sendKeys("cin>>a>>b;")
           .sendKeys("cout<<a+a;")
           .perform(); 
        }
        Thread.sleep(1000);
    }
    
    public static void writeCsharp(String type,WebDriver driver, Actions actions) throws InterruptedException
    {
        Thread.sleep(500);
        if(type.equals("error"))
        {
               actions.click(Basic.find(driver, "//div[@class='question-attempt-pane']", Duration.ofSeconds(5)))
               .keyDown(Keys.SHIFT)
               .sendKeys(Keys.PAGE_UP)
               .keyUp(Keys.SHIFT)
               .sendKeys(Keys.BACK_SPACE)

               .sendKeys("int a = Convert.ToInt32(Console.ReadLine());")
               .sendKeys("int b = Convert.ToInt32(Console.ReadLine());",Keys.ENTER)
               .sendKeys("Console.WriteLine(a+q);")
               .perform(); 
        }
        else if(type.equals("pass"))
        {
           actions.click(Basic.find(driver, "//div[@class='question-attempt-pane']", Duration.ofSeconds(5)))
           .keyDown(Keys.SHIFT)
           .sendKeys(Keys.PAGE_UP)
           .keyUp(Keys.SHIFT)
           .sendKeys(Keys.BACK_SPACE)
           .sendKeys("int a = Convert.ToInt32(Console.ReadLine());")
           .sendKeys("int b = Convert.ToInt32(Console.ReadLine());")
           .sendKeys("Console.WriteLine(a+b);")
           .perform();  
        }
        else
        {
           actions.click(Basic.find(driver, "//div[@class='question-attempt-pane']", Duration.ofSeconds(5)))
               .keyDown(Keys.SHIFT)
               .sendKeys(Keys.PAGE_UP)
               .keyUp(Keys.SHIFT)
               .sendKeys(Keys.BACK_SPACE)

               .sendKeys("int a = Convert.ToInt32(Console.ReadLine());")
               .sendKeys("int b = Convert.ToInt32(Console.ReadLine());")
               .sendKeys("Console.WriteLine(a+a+b);")
               .perform(); 
        }
        Thread.sleep(1000);
    }

    public static void writeJava(String type,WebDriver driver, Actions actions) throws InterruptedException
    {   
        Thread.sleep(500);
        if(type.equals("error"))
        {
               System.out.println("Writing error");
               actions.click(Basic.find(driver, "//div[@class='question-attempt-pane']", Duration.ofSeconds(5)))
               .keyDown(Keys.SHIFT)
               .sendKeys(Keys.PAGE_UP)
               .keyUp(Keys.SHIFT)
               .sendKeys(Keys.BACK_SPACE)
               .sendKeys("int a , b;")
               .sendKeys("scanf( \" %d %d \", &a ,&b)",Keys.ENTER)
               .sendKeys("printf(\" %d \", a+b);")
               .perform(); 
        }
        else if(type.equals("pass"))
        {
           System.out.println("Writing pass");
           Thread.sleep(1000);
           actions.click(Basic.find(driver, "//div[@class='question-attempt-pane']", Duration.ofSeconds(5)))
           .keyDown(Keys.SHIFT)
           .sendKeys(Keys.PAGE_UP)
           .keyUp(Keys.SHIFT)
           .sendKeys(Keys.BACK_SPACE)
           .sendKeys("int a , b;")
           .sendKeys("Scanner scanner = new Scanner(System.in);")
           .sendKeys("a = scanner.nextInt();")
           .sendKeys("b = scanner.nextInt();")
           .sendKeys("System.out.println(a+b);")
           .perform(); 
        }
        else
        {
            System.out.println("Writing fail");
            Thread.sleep(1000);
            actions.click(Basic.find(driver, "//div[@class='ace_content']", Duration.ofSeconds(5)))
           .keyDown(Keys.SHIFT)
           .sendKeys(Keys.PAGE_UP)
           .keyUp(Keys.SHIFT)
           .sendKeys(Keys.BACK_SPACE)
           .sendKeys("int a,b;")
           .sendKeys("Scanner scanner = new Scanner(System.in);")
           .sendKeys("a = scanner.nextInt();")
           .sendKeys("b = scanner.nextInt();")
           .sendKeys("System.out.println(a+b+a);")
           .perform(); 
        }
        Thread.sleep(1000);
    }
    
    public static void writePython(String type,WebDriver driver, Actions actions) throws InterruptedException
    {
        Thread.sleep(500);
        if(type.equals("error"))
        {
               System.out.println("error");
               actions.click(Basic.find(driver, "//div[@class='question-attempt-pane']", Duration.ofSeconds(5)))
               .keyDown(Keys.SHIFT)
               .sendKeys(Keys.PAGE_UP)
               .keyUp(Keys.SHIFT)
               .sendKeys(Keys.BACK_SPACE)
               .sendKeys("int a , b;",Keys.ENTER)
               .sendKeys("scanf( \" %d %d \", &a ,&b);",Keys.ENTER)
               .sendKeys("printf(\" %d \", a+b);")
               .perform(); 
        }
        else if(type.equals("pass"))
        {
            System.out.println("pass");
           actions.click(Basic.find(driver, "//div[@class='question-attempt-pane']", Duration.ofSeconds(5)))
           .keyDown(Keys.SHIFT)
           .sendKeys(Keys.PAGE_UP)
           .keyUp(Keys.SHIFT)
           .sendKeys(Keys.BACK_SPACE)
           .sendKeys("a = int(input())",Keys.ENTER)
           .sendKeys("b = int(input())",Keys.ENTER)
           .sendKeys("print(a+b)")
           .perform(); 
        }
        else
        {
            System.out.println("fail");
            actions.click(Basic.find(driver, "//div[@class='question-attempt-pane']", Duration.ofSeconds(5)))
           .keyDown(Keys.SHIFT)
           .sendKeys(Keys.PAGE_UP)
           .keyUp(Keys.SHIFT)
           .sendKeys(Keys.BACK_SPACE)
           .sendKeys("a = int(input())",Keys.ENTER)
           .sendKeys("b = int(input())",Keys.ENTER)
           .sendKeys("print(a+b+a)")
           .perform();  
        }
        Thread.sleep(1000);
    }

    public static void writeJS(String type,WebDriver driver, Actions actions) throws InterruptedException
    {
        Thread.sleep(500);
        if(type.equals("error"))
        {
               actions.click(Basic.find(driver, "//div[@class='question-attempt-pane']", Duration.ofSeconds(5)))
               .keyDown(Keys.SHIFT)
               .sendKeys(Keys.PAGE_UP)
               .keyUp(Keys.SHIFT)
               .sendKeys(Keys.BACK_SPACE)
               .sendKeys("console.logg(\"javaScript\")",Keys.ENTER)
               .perform(); 
        }
        else if(type.equals("pass"))
        {
           actions.click(Basic.find(driver, "//div[@class='question-attempt-pane']", Duration.ofSeconds(5)))
           .keyDown(Keys.SHIFT)
           .sendKeys(Keys.PAGE_UP)
           .keyUp(Keys.SHIFT)
           .sendKeys(Keys.BACK_SPACE)
           .sendKeys("console.log(\"javaScript\")")
           .perform(); 
        }
        else
        {
            actions.click(Basic.find(driver, "//div[@class='question-attempt-pane']", Duration.ofSeconds(5)))
           .keyDown(Keys.SHIFT)
           .sendKeys(Keys.PAGE_UP)
           .keyUp(Keys.SHIFT)
           .sendKeys(Keys.BACK_SPACE)
           .sendKeys("console.log(\"javasscript\")")
           .perform();  
        }
        Thread.sleep(1000);
    }
    
    public static void writePhp(String type,WebDriver driver, Actions actions) throws InterruptedException
    {
        Thread.sleep(500);
        if(type.equals("error"))
        {
               actions.click(Basic.find(driver, "//div[@class='question-attempt-pane']", Duration.ofSeconds(5)))
               .keyDown(Keys.SHIFT)
               .sendKeys(Keys.PAGE_UP)
               .keyUp(Keys.SHIFT)
               .sendKeys(Keys.BACK_SPACE)
               .sendKeys("a= intval(readline()",Keys.ENTER)
               .sendKeys("b = intval(readline())",Keys.ENTER)
               .sendKeys("echo \" a+b \" ?>",Keys.ENTER)
               .perform(); 
        }
        else if(type.equals("pass"))
        {
           actions.click(Basic.find(driver, "//div[@class='question-attempt-pane']", Duration.ofSeconds(5)))
           .keyDown(Keys.SHIFT)
           .sendKeys(Keys.PAGE_UP)
           .keyUp(Keys.SHIFT)
           .sendKeys(Keys.BACK_SPACE)
           .sendKeys("$a= intval(fgets(STDIN));",Keys.ENTER)
           .sendKeys("$b = intval(fgets(STDIN));",Keys.ENTER)
           .sendKeys("echo \" $a+$b \" ","?>",Keys.ENTER)
           .perform(); 
        }
        else
        {
            actions.click(Basic.find(driver, "//div[@class='question-attempt-pane']", Duration.ofSeconds(5)))
           .keyDown(Keys.SHIFT)
           .sendKeys(Keys.PAGE_UP)
           .keyUp(Keys.SHIFT)
           .sendKeys(Keys.BACK_SPACE)
           .sendKeys("$a= intval(fgets(STDIN));",Keys.ENTER)
           .sendKeys("$b = intval(fgets(STDIN));",Keys.ENTER)
           .sendKeys("echo \" $a+$b+$a \" ","?>",Keys.ENTER)
           .perform();  
        }
        Thread.sleep(1000);
    }

    public static void uploadfile(WebDriver driver){
        
           String path="C:\\Users\\payal\\OneDrive\\Documents\\script.au3";
        ProcessBuilder processbuilder = new ProcessBuilder("C:\\Program Files (x86)\\AutoIt3\\AutoIt3.exe", path);
        Process process;
        try {
            process = processbuilder.start();
            process.waitFor();
        } catch (Exception e) {
            System.out.println("Exception in building os process");
            e.printStackTrace();
        }
        
    }
 
}

class checkalert implements Runnable{
    WebDriver driver;
    public checkalert(WebDriver driver){
        this.driver= driver;
    }


    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){

            if(Basic.isElementVisible(driver, "//div[@class=\"ant-message\"]", Duration.ofSeconds(1)))
            {

                if(driver.findElement(By.xpath("//div[@class=\"ant-message\"]")).getText().length()>1){
                    System.out.println("content found in alert");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                     
                        e.printStackTrace();
                    }
                    takescreenshot.shot(driver, "Alert found");
                };
                
            }
            
        }
    }
    
}