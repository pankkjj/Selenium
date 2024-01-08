package Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.print.DocFlavor.STRING;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.util.Arrays.Iterator;


public class excelfile {
    
    public static void read()
    {
        try
        {
          File file = new File("C:\\Users\\Pankaj Thakur\\eclipse-workspace\\Selenium\\firstfile.xlsx");
          FileInputStream fis = new FileInputStream(file); 
          XSSFWorkbook wb = new XSSFWorkbook(fis);
          XSSFSheet sheet = wb.getSheetAt(0);
          java.util.Iterator<Row>  itr = sheet.iterator();

          while(itr.hasNext()){
            Row row = itr.next();
            java.util.Iterator<Cell> cellIterator = row.cellIterator();

            while(cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                switch(cell.getCellTypeEnum()){
                
                    case STRING:
                        System.out.print(cell.getStringCellValue()+"\t\t");
                        break;
                    case BLANK:
                        System.out.print("  ");
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue()+"\t\t");  
                        break;
                    default:
                        break;
                     
                }
            }
            System.out.println("");
          }
          wb.close();
          fis.close();

        }
        catch(Exception e){
            System.out.println("File not found Exception");
        }
        
    }
    
    public static void write( String Filename){

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet Sheet = wb.createSheet("Student details");

        Map <String,Object[]> data = new TreeMap<String,Object[]>(){{
         put("1", new Object[]{"Name","age","class"});
         put("2", new Object[]{"Luffy",15,12});
         put("3", new Object[]{"Zoro",15,12});
         put("4", new Object[]{"Sanji",14,12});
        }};

       

        Set<String> keyset = data.keySet();
        int rowcount=0;
        for(String key: keyset){

            Row row = Sheet.createRow(rowcount++);
            Object[] objarr = data.get(key);
            int cellcount = 0;
            for(Object obj : objarr){
                Cell cell = row.createCell(cellcount++);
                if(obj instanceof String){
                    cell.setCellValue((String)obj);
                }
                else if(obj instanceof Integer){
                    cell.setCellValue((Integer)obj);
                }
            }
        }

        try 
        {
            FileOutputStream out = new FileOutputStream(new File(Filename));
            wb.write(out);
            wb.close();
            out.close();
            System.out.println("File Created Successfully");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
     
    }

    public static void merge(){

        XSSFWorkbook mainwb = new XSSFWorkbook();
        XSSFSheet mainwbsheet = mainwb.createSheet();
        File firstfile = new File("C:\\Users\\Pankaj Thakur\\eclipse-workspace\\Selenium\\firstfile.xlsx");
        File secondfile = new File("C:\\Users\\Pankaj Thakur\\eclipse-workspace\\Selenium\\secondfile.xlsx");
        try
        {
          FileInputStream fis1 = new FileInputStream(firstfile);
          XSSFWorkbook firstwb = new XSSFWorkbook(fis1);
          XSSFSheet firstsheet = firstwb.getSheetAt(0);
          
          FileInputStream fis2 = new FileInputStream(secondfile);
          XSSFWorkbook secondwb = new XSSFWorkbook(fis2);
          XSSFSheet secondsheet = secondwb.getSheetAt(0);
          
          java.util.Iterator<Row> itr1 = firstsheet.iterator();
          java.util.Iterator<Row> itr2 = secondsheet.iterator();
          int rowcount=0;
          while(itr1.hasNext() || itr2.hasNext()){
              Row row1 = itr1.next();
              Row row2 = itr2.next();
              Row mainrow = mainwbsheet.createRow(rowcount++);
              java.util.Iterator<Cell> cellitr1 = row1.cellIterator();
              java.util.Iterator<Cell> cellitr2 = row2.cellIterator();
              
              int cellcount=0; 
              while(cellitr1.hasNext() || cellitr2.hasNext()){
                Cell cell1 = cellitr1.next();
                Cell cell2 = cellitr2.next();
                Cell cell3 = mainrow.createCell(cellcount++);
                switch (cell1.getCellTypeEnum()) {
                    case STRING:
                        System.out.println(cell1.getStringCellValue());
                        cell3.setCellValue(cell1.getStringCellValue());
                        break;
                    case NUMERIC:
                        cell3.setCellValue(cell1.getNumericCellValue());
                        break;                     
                    default:
                        break;
                }
                Cell cell4 = mainrow.createCell(cellcount++);
                switch (cell2.getCellTypeEnum()) {
                    case STRING:
                        System.out.println(cell2.getStringCellValue());
                        cell4.setCellValue(cell2.getStringCellValue());
                        break;
                    case NUMERIC:
                        cell4.setCellValue(cell2.getNumericCellValue());
                        break; 
                    default:
                        break;
                }
              }
          }

          FileOutputStream out = new FileOutputStream(new File("Merged.xlsx"));
          mainwb.write(out);
          mainwb.close();
          firstwb.close();
          secondwb.close();

        }
        catch(Exception e){

        }
        
    }

}
