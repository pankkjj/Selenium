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
    public static String mainFilePath;
    public static String mcqFilePath;
    public static String codingFilePath;
    public static String subFilePath;
    public static String webFilePath;
    static{
        try(InputStream input = Config.class.getClassLoader().getResourceAsStream("Config/config.properties")){
           Properties prop = new Properties();
           prop.load(input);

           testlink = prop.getProperty("testLink", "empty");
           testCode = prop.getProperty("testCode", "empty");
           driverPath = prop.getProperty("driverpath","empty");
           screenshotPath = prop.getProperty("ScreenshotPath","empty");
           autoitPath = prop.getProperty("autoitPath","empty");
           scriptPath = prop.getProperty("scriptpath", "empty");
           mainFilePath = prop.getProperty("mainFilePath","empty");
           mcqFilePath = prop.getProperty("mcqFilePath","empty");
           codingFilePath = prop.getProperty("codingFilePath", "empty");
           subFilePath = prop.getProperty("subFilePath", "empty");
           webFilePath = prop.getProperty("webFilePath", "empty");
        } catch(Exception e){
           System.out.println(e);
        }
    }
}
