package Config;
import java.io.InputStream;
import java.util.Properties;

public class Config {
     
    public static String testlink;
    public static String testCode;
    public static String driverPath;
    public static String screenshotPath;
    public static String autoitPath;
    public static String scriptPath;
    static{
        try(InputStream input = Config.class.getClassLoader().getResourceAsStream("Config/config.properties")){
           Properties prop = new Properties();
           prop.load(input);
           System.out.println("-------------------------------------------");
           System.out.println(prop);


           testlink = prop.getProperty("testLink", "5454545");
           testCode = prop.getProperty("testCode", "45678");
           driverPath = prop.getProperty("driverpath","gfhgfhg");
           screenshotPath = prop.getProperty("ScreenshotPath","uhhj");
           autoitPath = prop.getProperty("autoitPath","uhhj");
           scriptPath = prop.getProperty("scriptpath", "dsgfrdgf");
           System.out.println(testlink);
        } catch(Exception e){
           System.out.println("-------------------------------------------");
           System.out.println(e);
        }
    }
}
