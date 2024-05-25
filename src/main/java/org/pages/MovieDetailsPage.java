package org.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MovieDetailsPage extends PageBase{

    private static final By movieTitleLocator = AppiumBy.xpath("//android.widget.TextView[@text=\"Godzilla x Kong: The New Empire\"]");
    private static final By releaseDateLocator = AppiumBy.xpath("//android.widget.TextView[@text=\"2024-03-27\"]");
    private static final By genreLocator = AppiumBy.xpath("//android.widget.TextView[@text=\"Science Fiction\"]");
    private static final By directorLocator = AppiumBy.xpath("//android.widget.TextView[@text=\"Adam Wingard\"]");
    public MovieDetailsPage(AppiumDriver driver) {
        super(driver);
        // You can add logic to verify if the movie details page is loaded here
        if (!isElementPresent(movieTitleLocator)) {
            throw new RuntimeException("Movie details page not loaded!");
        }
    }

    public String getMovieTitle() {
        return driver.findElement(movieTitleLocator).getText();
    }

    public String getReleaseDate() {
        return driver.findElement(releaseDateLocator).getText();
    }

    public String getGenre() {
        return driver.findElement(genreLocator).getText();
    }

    public String getDirector() {
        return driver.findElement(directorLocator).getText();
    }
}
