package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.pages.HomePage;
import org.pages.MenuFilterPage;
import org.pages.MovieDetailsPage;
import org.testng.Assert;
import org.tests.TestBase;

public class JetflixMovie extends TestBase {

    private HomePage homeObject;
    private MovieDetailsPage movieDetailsObject;
    private MenuFilterPage menuFilterObject;
    String movieName = "Godzilla x Kong: The New Empire";

    @Given("^I am on the Jetflix home page$")
    public void navigateToHomePage(){
        homeObject = new HomePage(driver);
    }

    @When("^I search for the movie \"(.*?)\"$")
    public void getFirstMovieName(){
        homeObject.getFirstMovieName();
    }

    @When("^I select the first movie from the search results$")
    public void selectFirstMovie(){
        homeObject.clickFirstMovie();
    }

    @Then("^I see the movie title \"(.*?)\" on the details page$")
    public void verifyMovieTitle(){
        movieDetailsObject = new MovieDetailsPage(driver);
        String actualTtile = movieDetailsObject.getMovieTitle();
        Assert.assertEquals(actualTtile, movieName);
    }

}
