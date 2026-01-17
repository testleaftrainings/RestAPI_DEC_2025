package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = {"src/test/java/features/servicenow-incidents-refactored.feature:10"},
		          glue = {"step.defs.som"},
		          dryRun = false,
		          plugin = {
		        		  "pretty",
		        		  "html:cucumber-report/result.html",
		        		  "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		          },
		          publish = false,
		          tags = ""
		        )
public class TestNGRunner extends AbstractTestNGCucumberTests {}