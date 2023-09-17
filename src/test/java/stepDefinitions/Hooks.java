package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.DriverUtil;

import java.io.IOException;

public class Hooks {

    @Before
    public void beforeMethod() throws IOException {
        System.out.println("cucumber before method");
        DriverUtil.invokeDriver();
    }

    @After
    public void afterMethod(Scenario scenario) {

        //take screenshot in case of failure only
        if (scenario.isFailed()) {
            DriverUtil.takeScreenshot(scenario);
        }

        //close browser instances
        DriverUtil.quitDriver();
    }

}
