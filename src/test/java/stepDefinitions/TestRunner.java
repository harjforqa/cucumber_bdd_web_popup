package stepDefinitions;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.BeforeSuite;
import utilities.ConfigReadUtil;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@CucumberOptions(features = "src/test/resources/FeatureFiles"
        , plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        , glue = {"stepDefinitions"}
        , tags = "@e2e"
        , monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

    PrintWriter writer;

    //TestNG annotations
    @BeforeSuite
    public void clearDirectories() throws IOException {

        //clear applog-info.log
        writer = new PrintWriter(System.getProperty("user.dir") + File.separator + ConfigReadUtil.getPropertyValue("applog_infoPath"));
        writer.print("");
        writer.close();

        //clear applog-error.log
        writer = new PrintWriter(System.getProperty("user.dir") + File.separator + ConfigReadUtil.getPropertyValue("applog_errorPath"));
        writer.print("");
        writer.close();

        //clear FailedScreenshots directory
        FileUtils.cleanDirectory(new File(System.getProperty("user.dir") + File.separator + ConfigReadUtil.getPropertyValue("failedScreenshotPath")));
    }
}
