package Base;

import TestUtils.TestUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//Define our driver here and all test cases will extend this class
public class TestBase {
    protected static WebDriver driver;
    protected static Properties properties;
    public static ExtentReports extentReports;
    public static ExtentTest log;

    public TestBase() throws IOException {
        properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/java/Config/config.properties");
        properties.load(fileInputStream);
    }

    public static void initialization(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
        driver.get(properties.getProperty("url"));

    }

    public static void tearDown(Method method , ITestResult result) throws IOException {
        TestUtils.screenShot(method.getName());
        if(result.getStatus() == ITestResult.SUCCESS){
            log.log(LogStatus.PASS , "Test Pass..");
            log.log(LogStatus.PASS , "<a href = '"+result.getName()+".png" + "'><span class = 'lable info'> SnapShot</span></a>");
        }
        else if(result.getStatus() == ITestResult.FAILURE){
            log.log(LogStatus.FAIL , "Test Failed..");
            log.log(LogStatus.FAIL , "<a href = '"+result.getName()+".png" + "'><span class = 'lable info'> SnapShot</span></a>");
            log.log(LogStatus.FAIL , result.getThrowable());
        }
        else {
            log.log(LogStatus.SKIP , "Test Skipped..");
            log.log(LogStatus.SKIP , "<a href = '"+result.getName()+".png" + "'><span class = 'lable info'> SnapShot</span></a>");
            log.log(LogStatus.SKIP , result.getThrowable());
        }

        driver.quit();
    }
}
