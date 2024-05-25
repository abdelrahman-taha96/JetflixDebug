package org.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MenuFilterPage extends PageBase{

    private static final By filterMenuLocator = AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]/android.widget.Button");
    private static final By closeButtonLocator = AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.widget.Button");
    private static final By releaseDateFilter = AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.widget.ScrollView[2]/android.view.View[4]/android.widget.RadioButton");
    public MenuFilterPage(AppiumDriver driver) {
        super(driver);
        if (isElementPresent(filterMenuLocator)) {
            // Filter menu is open, proceed
        } else {
            throw new RuntimeException("Filter menu not opened!");
        }
    }

    public void closeFilterMenu() {
        driver.findElement(closeButtonLocator).click();
    }

    public void selectReleaseDateFilter() {
        driver.findElement(releaseDateFilter).click();
    }
}
