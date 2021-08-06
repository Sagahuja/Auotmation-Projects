package stepDefinitions;


import org.junit.runner.RunWith;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
public class StepDefinitaion1 {

	@Given("User open the Login Page")
	public void user_open_the_login_page() {
		System.out.println("test");
	}

    @When("^User enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enter_something_and_something(String strArg1, String strArg2) throws Throwable {
    	 System.out.println("test");
    }

    @Then("^Check user is able to login or not$")
    public void check_user_is_able_to_login_or_not() throws Throwable {
    	 System.out.println("test");
    }

    @And("^check further login page things$")
    public void check_further_login_page_things() throws Throwable {
    	 System.out.println("test");
    }

}