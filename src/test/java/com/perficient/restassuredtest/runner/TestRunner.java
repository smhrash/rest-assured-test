package com.perficient.restassuredtest.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"com/perficient/restassuredtest/stepdefinitions"},
        plugin = {"pretty", "json:target/cucumber-report.json"},
        tags = "@getPlace"
)
public class TestRunner {
}
