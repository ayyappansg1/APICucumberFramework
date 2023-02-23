package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import jvmReport.JVMReport;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FeatureFiles", glue = { "stepDefinitions",
"hooks" }, dryRun = false, stepNotifications = true, 
snippets = SnippetType.CAMELCASE, monochrome = true,
tags = "@first", plugin = "json:target/json/report.json")
public class RunnerClass {
	@AfterClass
	public static void reportGenerate() {
		JVMReport.jvmReportGeneration("C:\\Users\\ayyappan.g\\eclipse-workspace\\ApiTestingCucumberFramework\\target\\json\\report.json");
	}
}
