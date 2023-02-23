package stepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import Endpoints.EndPointsTeams;
import baseClass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import junit.framework.Assert;
import utilities.Utilities;

public class TC_1ComparePageValidation extends BaseClass {
	Response reqTypeWithoutEndpoint ;
@Given("user passing headers {string} as a {string}")
public void userPassingHeadersAsA(String key, String value) {
	initialisation();
}
@When("user passing headers {string} and {string} values as below")
public void userPassingHeadersAndValuesAsBelow(String key1, String key2, io.cucumber.datatable.DataTable dataTable) {
	List<Map<String,String>> list = dataTable.asMaps();
	addHeaders(key1, list.get(0).get(key1), key2, list.get(0).get(key2));
}
@When("user process {string} method")
public void user_process_method(String string) {
	addBaseUri(EndPointsTeams.GETBaseUrl);
	addBasePath(EndPointsTeams.GETTeamList);
	reqTypeWithoutEndpoint = reqTypeWithoutEndpoint(string);
	String bodyasPrettyString = getBodyasPrettyString(reqTypeWithoutEndpoint);
	System.out.println(bodyasPrettyString);
}
@Then("verify that Status code  should be {string} and response should have {string}")
public void verifyThatStatusCodeShouldBeAndResponseShouldHave(String statuscode, String name, io.cucumber.datatable.DataTable dataTable) {
	List<Map<String,String>> asMaps = dataTable.asMaps();
	String teamName = asMaps.get(0).get(name);
	System.out.println(teamName);
	int statusCode = reqTypeWithoutEndpoint.getStatusCode();
	Assert.assertEquals("Validation of Status Codes", Integer.parseInt(statuscode), statusCode);
//	Object jsonPath = jsonPath(reqTypeWithoutEndpoint.asString(), "$.list.[?(@.teamName=='India')].teamName");
	List<Object> jsonPathusingBody = jsonPathParse(reqTypeWithoutEndpoint, "list[?(@.teamName=='India')].teamName");			
	assertThat(jsonPathusingBody).contains(teamName);
}

	
}
