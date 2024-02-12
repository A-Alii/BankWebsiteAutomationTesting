package TestCases;

import Base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class Config extends TestBase {
    public Config() throws IOException {
        super();
    }

    @BeforeSuite
    public void start(){
        extentReports = new ExtentReports("TestReports\\Report.html" , true);
        extentReports.addSystemInfo("OS","Windows");
        extentReports.addSystemInfo("Owner","Abdallh adly");
        extentReports.addSystemInfo("language","java");


    }

    @AfterSuite
    public void end(){
        extentReports.flush();

    }
}
