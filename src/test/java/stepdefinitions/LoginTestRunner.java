package stepdefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
monochrome = true,
plugin = {"pretty", "junit:target/JunitReports/report.xml", "html:target/HTMLReports/report.html"},
glue={"stepdefinitions"},
tags = "@Smoke"
)
public class LoginTestRunner {
}
