package cucumber.stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefs {
    // Home Page:
    @Given("I am on the Amazon home page amazon.com")
    public void i_am_on_the_Amazon_home_page_amazon_com() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I search for “Cucumber Testing”,")
    public void i_search_for_Cucumber_Testing() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should get a result for “The Cucumber Book: Behaviour-Driven Development for Testers and Developers”")
    public void i_should_get_a_result_for_The_Cucumber_Book_Behaviour_Driven_Development_for_Testers_and_Developers() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    // Verify Search Result/Product Page produces correct information:
    @Given("I performed the above search")
    public void i_performed_the_above_search() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I click on the image of the book")
    public void i_click_on_the_image_of_the_book() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should be on a Paperback tab with an “Add to Cart” button")
    public void i_should_be_on_a_Paperback_tab_with_an_Add_to_Cart_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    // Verify Product Page Add-to-Cart functionality:
    @Given("I am on the page above")
    public void i_am_on_the_page_above() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I click “Add to Cart”")
    public void i_click_Add_to_Cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the anonymous shopping cart should have {int} item in it.")
    public void the_anonymous_shopping_cart_should_have_item_in_it(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    // Verify Cart Page contains correct information:
    @Given("I have performed the above actions")
    public void i_have_performed_the_above_actions() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I click on the anonymous shopping cart,")
    public void i_click_on_the_anonymous_shopping_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should see the book listed with a subtotal of ${double}")
    public void i_should_see_the_book_listed_with_a_subtotal_of_$(Double double1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    // Verify Cart Page Delete functionality:
    @Given("I am on the above page")
    public void i_am_on_the_above_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I click on “Delete”")
    public void i_click_on_Delete() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the page should tell me that my Amazon Cart is empty")
    public void the_page_should_tell_me_that_my_Amazon_Cart_is_empty() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    // Verify correct Product Page:
    @When("I click the link for the removed book")
    public void i_click_the_link_for_the_removed_book() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should see an ISBN{int} number of {int}{int}")
    public void i_should_see_an_ISBN_number_of(Integer int1, Integer int2, Integer int3) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}
