package cucumber.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;

public class PreAndPostConditions {
	
	@Before
	public void shouldRunBeforeEachScenarios() {
		System.out.println("Should run before each scenarios");
	}
	
	@After
	public void shouldRunAfterEachScenarios() {
		System.out.println("Should run after each scenarios");
	}
	
	@BeforeStep
	public void shouldRunBeforeEachStepOfScenarios() {
		System.out.println("Should run before each step of scenarios");
	}
	
	@AfterStep
	public void shouldRunAfterEachStepOfScenarios() {
		System.out.println("Should run after each step of scenarios");
	}
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("Before All");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("After All");
	}

}
