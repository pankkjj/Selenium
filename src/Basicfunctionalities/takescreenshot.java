package Basicfunctionalities;

import java.io.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Config.Config;

public class takescreenshot {
    
    public static void shot(WebDriver driver, String name){
        Long time = System.currentTimeMillis();
        String screenshotPath = Config.screenshotPath;
         TakesScreenshot screenshot = ((TakesScreenshot)driver);
          System.out.println("Taking Screenshoot"+screenshotPath);
            File SrcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(screenshotPath + name + time.toString() + ".png");
            try {
                FileUtils.copyFile(SrcFile, destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
