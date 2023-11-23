package Basicfunctionalities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class takescreenshot {
    
    public static void shot(WebDriver driver){
         TakesScreenshot screenshot = ((TakesScreenshot)driver);
            File SrcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("C:\\Users\\Pankaj Thakur\\eclipse-workspace\\Selenium\\test.png");
            try {
                FileUtils.copyFile(SrcFile, destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
