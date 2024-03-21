package healthcalc.bdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import healthcalc.HealthCalc;
import healthcalc.HealthCalcImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	private HealthCalc calc;
	private float result;
	private boolean exception;
	
	@Given("I have an health calculator")
	public void i_have_an_health_calculator() {
	    calc= new HealthCalcImpl();
	}
	
	//idealWeight
	@When("I compute the ideal weight for negative height {int}")
	public void i_compute_the_ideal_weight_for_negative_height(Integer int1) {
		try {
			calc.idealWeight(int1, 'm');
		}catch(Exception e) {
			exception= true;
		}
	}

	@Then("the system raises an exception")
	public void the_system_raises_an_exception() {
		assertTrue(exception);
	}
	
	@When("I compute the ideal weight for an invalid gender {string}")
	public void i_compute_the_ideal_weight_for_an_invalid_gender(String string) {
		try {
			calc.idealWeight(160, string.toCharArray()[0]);
		}catch(Exception e) {
			exception= true;
		}
	}

	@When("I compute the ideal weight for gender {string} and height {int} and gives a negative result")
	public void i_compute_the_ideal_weight_for_gender_and_height_and_gives_a_negative_result(String string, Integer int1) {
		try {
			calc.idealWeight(int1, string.toCharArray()[0]);
		}catch(Exception e) {
			exception= true;
		}
	}

	@When("I compute the ideal weight for gender {string} and height {int}")
	public void i_compute_the_ideal_weight_for_gender_and_height(String string, Integer int1) throws Exception {
	    result=calc.idealWeight(int1, string.toCharArray()[0]);
	}
	@Then("the system return a feasible result {string}")
	public void the_system_return_a_feasible_result(String string) {
		assertEquals(Float.parseFloat(string), result);
	}
	
	// basal Metabolic Rate
	@When("I compute the basal metabolic rate for an invalid height {int}")
	public void i_compute_the_basal_metabolic_rate_for_an_invalid_height(Integer int1) {
		try {
			calc.basalMetabolicRate(50, int1, 'm', 5);
		}catch(Exception e) {
			exception= true;
		}
	}
	
	@When("I compute the basal metabolic rate for an invalid gender {string}")
	public void i_compute_the_basal_metabolic_rate_for_an_invalid_gender_h(String string) {
		try {
			calc.basalMetabolicRate(50, 160, string.toCharArray()[0], 5);
		}catch(Exception e) {
			exception= true;
		}
	}
	
	@When("I compute the basal metabolic rate for a negative age {int}")
	public void i_compute_the_basal_metabolic_rate_for_a_negative_age(Integer int1) {
		try {
			calc.basalMetabolicRate(50, 160, 'w', int1);
		}catch(Exception e) {
			exception= true;
		}
	}
	
	@When("I compute the basal metabolic rate for an invalid weight {int}")
	public void i_compute_the_basal_metabolic_rate_for_an_invalid_weight(Integer int1) {
		try {
			calc.basalMetabolicRate(int1, 160, 'w', 34);
		}catch(Exception e) {
			exception= true;
		}
	}
	
	@When("I compute the basal metabolic rate of gender {string} with a combination of height {int}, weight {int} and age {int} whose result is a negative weight")
	public void i_compute_the_basal_metabolic_rate_and_result_is_a_negative_weight(String string, Integer int1, Integer int2, Integer int3) {
		try {
			calc.basalMetabolicRate(int2, int1, string.toCharArray()[0], int3);
		}catch(Exception e) {
			exception= true;
		}
	}
	
	@When("I compute the basal metabolic rate for the given valid parameters {int} , {int} , {string} , {int}")
	public void i_compute_the_basal_metabolic_rate_for_the_given_valid_parameters(Integer int1, Integer int2, String string, Integer int3) throws Exception {
		result=calc.basalMetabolicRate(int1, int2, string.toCharArray()[0], int3);
	}
	@Then("the system returns a valid result {string}")
	public void the_system_returns_a_valid_result(String string) {
		assertEquals(Float.parseFloat(string), result);
	}
}
