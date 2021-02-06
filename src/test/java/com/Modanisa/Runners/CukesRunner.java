package com.Modanisa.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                  "rerun:target/rerun.txt"},
        features = "src/test/resources/Features",
        glue = "com/Modanisa/StepDefinitions",
        dryRun = false,
        tags = "@test"
)
public class CukesRunner {
}
