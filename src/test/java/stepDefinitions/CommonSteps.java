package stepDefinitions;

import io.cucumber.java.en.Given;
import utilities.GetArgumentUtil;
import utilities.WrapperUtil;

import java.io.IOException;

public class CommonSteps extends WrapperUtil {


    @Given("I am on the Amazon.in website")
    public void iAmOnTheAmazonInWebsite() throws IOException {
        navigateToUrl(GetArgumentUtil.getCustomURL());
    }
}
