package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = "src/test/resources/features/loginpage.feature",
                glue = {"org.opencart.stepdef"},
                //plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
                plugin = {"pretty",
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                        "html:target/cucumber-reports.html"},
                monochrome = true,
                publish = true)

public class TestRunner extends AbstractTestNGCucumberTests {
    /*@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios(){
        return super.scenarios();
    }*/
}
