package cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/Amazon.feature"},
        glue = {"com.examples.cucumber"})

public class RunCucumberTest {

}