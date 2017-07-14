package cucumber_runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by agustin on 09/06/2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/cucumber.features",
        glue = {"stepsDef"}
)


public class SdetRunner {
}
