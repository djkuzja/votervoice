package net.votervoice.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "json:target/cucumber.json",
                "html:target/default-cucumber-reports"
        },
        features = "src/test/resources/feature/",
        glue = "net/votervoice/step_definitions",
//        tags = "@wip",
        dryRun = false
)
public class CukesRunner {
}
