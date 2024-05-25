package org.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends PageBase{

    private static final By movieNameLocator = AppiumBy.androidUIAutomator("new UiSelector().text(\"Godzilla x Kong: The New Empire\")");
    private static final By movieItemLocator = AppiumBy.xpath("//android.view.View[@content-desc=\"Poster Image of Godzilla x Kong: The New Empire\"]");
    private static final By menuButtonLocator = AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]/android.widget.Button");
    public HomePage(AppiumDriver driver) {
        super(driver);
        // You can add logic to verify if the home page is loaded here
        if (!isElementPresent(movieNameLocator)) {
            throw new RuntimeException("Home page not loaded!");
        }
    }

    public String getFirstMovieName() {
        return driver.findElement(movieNameLocator).getText();
    }

    public void clickFirstMovie() {
        driver.findElement(movieItemLocator).click();
    }

    public void openMenuFilter() {
        if (isElementPresent(menuButtonLocator)) { // Check if menu button exists
            driver.findElement(menuButtonLocator).click();
        } else {
            throw new RuntimeException("Menu button not found!");
        }
    }
    private boolean isPastRelease(String releaseDateString) {
        return true;
    }
    public List<WebElement> getMovieElements() {
        By movieListLocator = AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]");
        return driver.findElements(movieListLocator);
    }
    public String getReleaseDateFromMovieElement(WebElement movieElement) {
        By releaseDateLocator = AppiumBy.xpath("//android.widget.TextView[@text=\"2115-11-18\"]");
        WebElement releaseDateElement = movieElement.findElement(releaseDateLocator);
        return releaseDateElement.getText().trim();
    }
    public void verifyMoviesHaveFutureReleaseDates() throws InterruptedException, ParseException {
        List<WebElement> movies = getMovieElements();
        for (WebElement movie : movies) {
            String releaseDateString = getReleaseDateFromMovieElement(movie);
            if (isPastRelease(releaseDateString)) {
                throw new AssertionError("Found movie with past release date: " + releaseDateString);
            }
        }
    }
}
