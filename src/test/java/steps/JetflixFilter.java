package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.pages.HomePage;
import org.pages.MenuFilterPage;
import org.pages.MovieDetailsPage;
import org.tests.TestBase;

import java.util.List;

public class JetflixFilter extends TestBase {
    private HomePage homeObject;
    private MovieDetailsPage movieDetailsObject;
    private MenuFilterPage menuFilterObject;

    @Given("^I am on the Jetflix home page$")
    public void navigateToHomePage() {
        homeObject = new HomePage(driver);
    }

    @When("^I open the filter menu$")
    public void openFilterMenu() {
        homeObject.openMenuFilter();
    }

    @When("^I select the release date filter then close the menu$")
    public void selectReleaseDateFilter() {
        menuFilterObject = new MenuFilterPage(driver);
        menuFilterObject.selectReleaseDateFilter();
        menuFilterObject.closeFilterMenu();
    }

    @Then("all movies should have future release dates")
    public void verifyFutureReleaseDates() throws InterruptedException {
        homeObject.verifyMoviesHaveFutureReleaseDates();
    }

}
