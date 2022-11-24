package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ={"src\\test\\resources\\features"},
        plugin = {"pretty","html:target/cucumber-html","json:target/json/json-login.json"},
        glue = {"src/test/java/stepDefinitions"}
)
public class TestRunner {
}
