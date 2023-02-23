package hooks;

import java.io.IOException;

import baseClass.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.Utilities;

public class Hooks extends BaseClass{
	String scenarioName;
	public String getScenarioName() {
		return scenarioName;
	}
	@Before
	public void before(Scenario scenario) throws IOException
	{
	}
	@After
	public void after(Scenario scenario) throws IOException
	{

	}
}
