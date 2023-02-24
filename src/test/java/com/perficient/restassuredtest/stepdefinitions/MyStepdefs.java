package com.perficient.restassuredtest.stepdefinitions;

import com.perficient.restassuredtest.AbstractServiceTest;
import com.perficient.restassuredtest.resources.DataBuilder;
import com.perficient.restassuredtest.constants.PathParameter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import org.testng.AssertJUnit;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class MyStepdefs extends AbstractServiceTest {
    Response response;
    protected static String place_id;

    DataBuilder db = new DataBuilder();

    @Given("user has the request body")
    public void userHasTheRequestBody() {
        requestSpecification = given().spec(requestSpecification()).body(db.place());
    }

    @When("user sends {string} request with {string} call")
    public void userSendsRequestWithCall(String param, String method) {
        PathParameter pm = PathParameter.valueOf(param);
        responseSpecification = new ResponseSpecBuilder().build();
        if (method.equalsIgnoreCase("POST")) {
            response = requestSpecification.when().post(pm.param());
        } else if (method.equalsIgnoreCase("DELETE")) {
            response = requestSpecification.when().delete(pm.param());
        } else if (method.equalsIgnoreCase("GET")) {
            response = requestSpecification.when().get(pm.param());
        }
    }

    @Then("user see the place is added on the map")
    public void userSeeThePlaceIsAddedOnTheMap() {
        place_id = getJsonPath(response, "place_id");
        assertEquals(200, response.getStatusCode());
        assertTrue(!place_id.isBlank());
    }

    @Given("the request body should be a google schema with {string} {string} {string} fields")
    public void theRequestBodyShouldBeAGoogleSchemaWithFields(String address, String language, String name) {
        requestSpecification = given().spec(requestSpecification().body(db.place(address, language, name)));
    }

    @And("the {string} in response body should be {string}")
    public void theInResponseBodyShouldBe(String key, String value) {
        AssertJUnit.assertEquals(value, getJsonPath(response, key));
    }

    @Given("user has the place id")
    public void userHasThePlaceId() {
        requestSpecification = given().spec(requestSpecification()).queryParam("place_id", place_id);
    }

    @Then("user see place has been deleted")
    public void userSeePlaceHasBeenDeleted() {
        assertEquals(200, response.getStatusCode());
    }

    @Then("user see the place")
    public void userSeeThePlace() {
        assertEquals(200, response.getStatusCode());

    }
}
