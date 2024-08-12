package com.nttdata.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber/cucumber-report.html",
                "json:target/cucumber/cucumber.json"},
        stepNotifications = true,
        features = "src/test/resources/features",
        glue = "com.nttdata",
        tags = "@AllTest"
)
public class RunnerTest {
}
