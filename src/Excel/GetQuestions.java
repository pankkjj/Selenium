package Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import Config.Config;
import Basicfunctionalities.Basic;
import Quizserver.Login;

public class GetQuestions {
    	
   static Map<String, Object[]> McqMap = new TreeMap<String,Object[]>(){{
    put("1",new Object[]{"Name","Score","Keywords","Description","Options"});
   }};

   static Map<String, Object[]> codingMap = new TreeMap<String ,Object[]>(){{
    put("1",new Object[]{"Name", "Score", "Keywords", "Description", "Languages Allowed", "Test Case Name", "Test Case Input", "Test Case Output", "Test Case Score", "Sample Test Case"});
   }};

   static Map<String, Object[]> subjectiveMap = new TreeMap<String,Object[]>(){{
      put("1", new Object[]{"Name", "Score", "Keywords", "Description"});
   }};

   static Map<String,Object[]> webMap = new TreeMap<String, Object[]>(){{
      put("1",new Object[]{"Name", "Score", "Keywords", "Description", "Languages Allowed" , "Test Case Description", "Test Case Evaluator","Test Case Score"});
   }};

   static Integer mcqCount = 2;
   static Integer codingCount = 2;
   static Integer subCount = 2;
   static Integer webCount = 2;
   static String mcqFilePath = Config.mcqFilePath;
   static String mainFilePath = Config.mainFilePath;
   static String codingFilePath = Config.codingFilePath;
   static String subFilePath = Config.subFilePath;
   static String webFilePath = Config.webFilePath;
   
   public static void getQuestions(WebDriver driver,String link) throws InterruptedException{
      driver.get(link);
      Login.login(driver, "pankaj.thakur@codequotient.com", "Holmes@221");

      XSSFWorkbook wb = new XSSFWorkbook();
      XSSFSheet sheet = wb.createSheet("Questions details");
      Map <String, Object[]> data = new LinkedHashMap<String, Object[]>(){{
         put("1", new Object[]{"Question Name", "Question ID", "Question Number","Question type","Question marks"});
      }};
      int count = 2;
      List<WebElement> sections = driver.findElements(By.xpath("//div[@class ='sections']"));
      for(int i=1; i<=sections.size();i++)
      {
         Basic.clickButton(driver, "(//div[contains(@class, 'sections-head')])[" + i +"]", Duration.ofSeconds(5));
         Thread.sleep(500);
         List<WebElement> questionsList = driver.findElements(By.xpath("(//div[@class ='sections'])["+ i + "]//div[@class='row draggable-content-element table-body  ']"));
         
         WebElement[] questions = questionsList.toArray(new WebElement[0]);
         count = setToMap(data, questions, driver, count, i);
         count++;

      }
      
      writeToSheet(data, wb, sheet, mainFilePath);
     
   }

   public static Integer setToMap(Map<String ,Object[]> data, WebElement[] questions, WebDriver driver, Integer count, Integer sectionNumber){
      if(questions.length==0){
         data.put(count.toString(), new Object[]{"na","na","na","na","na"});
         System.out.println("inside if");
      }
      else{
         System.out.println("Number of questions are===" + questions.length+ "  Section number"+sectionNumber);

         for(int i=0;i<questions.length;i++)
         {
          String questionTitle = Basic.find(driver,
          "((//div[@class='sections'])[" +sectionNumber+ "]//div[@class='row draggable-content-element table-body  '])[" + (i+1) +"]//div[contains(@class,'question-title')]",
          Duration.ofSeconds(5)
          ).getText() ;
          
          String questionType = Basic.find(driver,
          "((//div[@class='sections'])[" +sectionNumber+ "]//div[@class='row draggable-content-element table-body  '])[" + (i+1) +"]//div[contains(@class,'q-typee')]",
          Duration.ofSeconds(5)
          ).getText() ;
 
          String questionScore = Basic.find(driver,
          "((//div[@class='sections'])[" +sectionNumber+ "]//div[@class='row draggable-content-element table-body  '])[" + (i+1) +"]//div[contains(@class,'score-info')]",
          Duration.ofSeconds(5)
          ).getText() ;
           
          String questionNumber = Basic.find(driver,
          "((//div[@class='sections'])[" +sectionNumber+ "]//div[@class='row draggable-content-element table-body  '])[" + (i+1) +"]//div[@class=' col-1']",
          Duration.ofSeconds(5)
          ).getText() ;
 
          String questionID = questions[i].getAttribute("id");
          data.put(count.toString(),new Object[]{questionTitle, questionID, questionNumber, questionType, questionScore});
          count++;
        }
      }
     
      return count;
   }
   
   public static void writeToSheet(Map<String,Object[]> data,XSSFWorkbook wb, XSSFSheet sheet, String path){
      Set<String> keyset = data.keySet();
      int rowCount=0;
      for(String key : keyset){
      
         Row row = sheet.createRow(rowCount++);
         Object[] objarr = data.get(key);
         int cellCount=0;
         for(Object obj : objarr){
          
            Cell cell = row.createCell(cellCount++);
            if(obj instanceof Integer){
               cell.setCellValue((Integer) obj);
            }
            else if(obj instanceof String){
               cell.setCellValue((String) obj);
            }
         }
      }
      try 
        {
            FileOutputStream out = new FileOutputStream(new File(path));
            wb.write(out);
            wb.close();
            out.close();
            System.out.println("File Created Successfully");
        } 
        catch (IOException e) {
            System.out.println("Error in Writing File");
        }
   }
	
   
   public static void getQuestionDetails(WebDriver driver, String id) throws InterruptedException
   {
      driver.get("https://cqtestga.com/quest/add/id:"+id);
      String questionName = Basic.find(driver, "//div[@class='edit-question-name']//input", Duration.ofSeconds(5)).getAttribute("value");
      String score = Basic.find(driver, "//div[@class='col-2']//input", Duration.ofSeconds(0)).getAttribute("value");
      String questionType = Basic.find(driver, "//button[@class='btn dropdown-toggle disabled btn-light']", Duration.ofSeconds(5)).getAttribute("title");
      
      String keyword= "";
      List<WebElement> keywordList = driver.findElements(By.xpath("//div[@class='tag-editor-tag']"));
      for (WebElement webElement : keywordList)
      {
         keyword = keyword + webElement.getText()+",";
      }

      String desc = "";
      List<WebElement> descriptionList  = driver.findElements(By.xpath("//div[@class='ql-editor']//p"));
      for (WebElement webElement : descriptionList) {
         desc = desc + webElement.getText();
      }


      switch(questionType){
         case "MCQ":
             String option="";
             String correctOption = "";
             List<WebElement> optionsList = driver.findElements(By.xpath("//div[@class='mcq-option']"));
             Integer i=1;
             Object[] obj = new Object[]{questionName,score,keyword,desc};

            for (WebElement element : optionsList)
            {
                option = Basic.find(driver, "(//div[@class='mcq-option'])[" + i +"]//div[2]", Duration.ofSeconds(5)).getText();
                obj = addValueToArray(obj, option);
                WebElement checkbox = Basic.find(driver, "(//div[@class='mcq-option'])[" + i +"]//div[3]//input", Duration.ofSeconds(5));
                if(checkbox.isSelected()){
                    correctOption = i.toString();
                }
                i++;
             }
             obj = addValueToArray(obj, correctOption);
             McqMap.put(mcqCount.toString(),obj);
             mcqCount++;
             break;
             

         case "Coding":
           String languages = Basic.find(driver, "//button[@data-id='progLang']", Duration.ofSeconds(5)).getAttribute("title");
           Object[] codingObj = new Object[]{questionName,score,keyword,desc,languages};

           Basic.clickButton(driver, "//div[@id='tCases']",  Duration.ofSeconds(5));
           Thread.sleep(2000);
           List <WebElement> elements = driver.findElements(By.xpath("//table[@class='table testcase-showcase-table']//tbody//tr"));
           for(int count=0;count<elements.size();count++){
              Basic.clickButton(driver,"//table[@class='table testcase-showcase-table']//tbody//tr["+ (count+1) +"]//td[@class='actions-col']//span[1]",Duration.ofSeconds(5));
              String tcName = Basic.find(driver, "//input[@id='testCaseName']", Duration.ofSeconds(5)).getDomProperty("value");
              String tcScore = Basic.find(driver, "//input[@id='testCaseScore']", Duration.ofSeconds(5)).getDomProperty("value");
              String tcInput = Basic.find(driver, "//textarea[@id='testcaseInput']", Duration.ofSeconds(5)).getDomProperty("value");
              String tcOutput = Basic.find(driver, "//textarea[@id='testcaseOutput']", Duration.ofSeconds(5)).getDomProperty("value");
              String sampleTc = Basic.find(driver, "//input[@id='sampleTestCaseCheck']", Duration.ofSeconds(5)).isSelected()?"yes":"no";
              Thread.sleep(500);
              Basic.clickButton(driver, "//button[@class='close']", Duration.ofSeconds(5));
              codingObj = addValueToArray(codingObj, tcName);
              codingObj = addValueToArray(codingObj, tcInput);
              codingObj = addValueToArray(codingObj, tcOutput);
              codingObj = addValueToArray(codingObj, tcScore);
              codingObj = addValueToArray(codingObj, sampleTc);

              
           }
           codingMap.put(codingCount.toString(), codingObj);
           codingCount++;
           break; 
           
         case "Subjective":
           subjectiveMap.put(subCount.toString(), new Object[]{questionName,score,keyword,desc});
           subCount++;
           break;  
            
         case "Web":
           Object[] webObj = new Object[]{questionName,score,keyword,desc};
           String lang = "";
           for(int j=1;j<=3;j++)
           {
              WebElement element = Basic.find(driver, "//div[@class='row mt-3']//div[" + j + "]//input",  Duration.ofSeconds(5));
              if(element.isSelected()){
                 lang = lang + Basic.find(driver, "//div[@class='row mt-3']//div[" + j + "]//label", Duration.ofSeconds(5)).getText();
              }
           }
           webObj = addValueToArray(webObj, lang);
           
           List<WebElement> testcases = driver.findElements(By.xpath("//div[@class=\"code-option code-option-loop\"]"));
           String tcDesc = "";
           String tcEvaluator = "";
           String tcScore = "";
           int j=1;
           for(WebElement element : testcases)
           {
             tcDesc = Basic.find(driver,
              "(//div[@class=\"code-option code-option-loop\"])["+ j +"]//div[@class='col-4 input-box input-box-2']",
               Duration.ofSeconds(5)).getText();
             tcEvaluator = Basic.find(driver,
              "(//div[@class=\"code-option code-option-loop\"])["+ j +"]//div[@class='col-4 input-box']",
              Duration.ofSeconds(5)).getText();
             tcScore = Basic.find(driver,
              "(//div[@class=\"code-option code-option-loop\"])["+ j +"]//div[@class='col-1 input-box input-box-3']//input",
               Duration.ofSeconds(5)).getAttribute("value");
             webObj = addValueToArray(webObj, tcDesc);
             webObj = addValueToArray(webObj, tcEvaluator);
             webObj = addValueToArray(webObj, tcScore);
             j++;
           }

           webMap.put(webCount.toString(),webObj);
           webCount++;
           break;
      }
      
       
   }

   public static void readFile(WebDriver driver, String path){
      File file = new File(path);
      
      try
      {
         FileInputStream fis = new FileInputStream(file);
         XSSFWorkbook wb = new XSSFWorkbook(fis);
         XSSFSheet sheet = wb.getSheetAt(0);
         java.util.Iterator<Row> itr = sheet.iterator();
         int rowcount=1;
         while (itr.hasNext()) 
         {
            Row row = itr.next();
            java.util.Iterator<Cell> cellIterator = row.cellIterator(); 
            int i=0;  
            if(rowcount>1){
               while (i<2) {
                  Cell cell = cellIterator.next();
                  if(i==1){
                     switch (cell.getCellType()) {
                        case STRING:
                           getQuestionDetails(driver, cell.getStringCellValue());
                           break;
                     
                        case NUMERIC:
                           System.out.println(cell.getNumericCellValue());
                           break;
                     }
                  }
                  
                  i++;
               }
            }
            rowcount++;
            
         }
         wb.close();

      }catch(Exception e){
         System.out.println(e);
      }
      XSSFWorkbook mcqwb = new XSSFWorkbook();
      XSSFSheet mcqsheet = mcqwb.createSheet("Mcq details");
      writeToSheet(McqMap, mcqwb, mcqsheet, mcqFilePath);

      XSSFWorkbook codingwb = new XSSFWorkbook();
      XSSFSheet codingsheet = codingwb.createSheet("Coding details");
      writeToSheet(codingMap, codingwb, codingsheet, codingFilePath);

      XSSFWorkbook subwb = new XSSFWorkbook();
      XSSFSheet subsheet = subwb.createSheet("Subjective Details");
      writeToSheet(subjectiveMap, subwb, subsheet, subFilePath);
      
      XSSFWorkbook webwb = new XSSFWorkbook();
      XSSFSheet websheet = webwb.createSheet("Web Details");
      writeToSheet(webMap, webwb, websheet, webFilePath);

   }

   private static Object[] addValueToArray(Object[] oldArray, String newValue)
   {
      int oldLength = oldArray.length;
      Object[] newArray = new Object[oldLength + 1];
      System.arraycopy(oldArray, 0, newArray, 0, oldLength);
      newArray[oldLength] = newValue;

      return newArray;
   }
}
