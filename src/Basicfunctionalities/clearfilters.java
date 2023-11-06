package Basicfunctionalities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class clearfilters {
    public static void clear(WebDriver driver){
        List <WebElement> filters=driver.findElements(By.xpath("(//img[starts-with(@onclick,'tagclear')])"));
        int i=1;
        while(i<=filters.size())
        {
            perform.clickButton(driver, "(//img[starts-with(@onclick,'tagclear')])["+ i + "]", Duration.ofSeconds(10));
            i++;
        }
    }
}
