package com.TopSecret.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                  "rerun:target/rerun.txt"},
        features = "src/test/resources/Features",
        glue = "com/TopSecret/StepDefinitions",
        dryRun = false,
        tags = "@test"
)
public class CukesRunner {
}
