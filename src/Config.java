import java.io.InputStream;
import java.util.Properties;

public class Config {
     
    public static String testlink;
    public static String testCode;
    public static String driverPath;
    public static String screenshotPath;
    static{
        try(InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")){
           Properties prop = new Properties();
           prop.load(input);

           testlink = prop.getProperty("testLink");
           testCode = prop.getProperty("testCode");
           driverPath = prop.getProperty("driverpath");
           screenshotPath = prop.getProperty("ScreenshotPath");
        } catch(Exception e){

        }
    }
}
