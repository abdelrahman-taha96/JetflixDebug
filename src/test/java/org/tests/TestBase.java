package org.tests;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;

public class TestBase {
    protected AppiumDriver driver;
    private Process appiumServerProcess;

    @BeforeSuite
    public void startAppiumServer() throws IOException {
        String appiumServerStartCommand = "appium -pa /wd/hub -p 4723 --allow-cors";
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", appiumServerStartCommand);
        appiumServerProcess = builder.start();
    }

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("app", Path.of(System.getProperty("user.dir") + "src/test/resources/app-debug.apk"));
        caps.setCapability("platformName", "emulator-5554");
        caps.setCapability("platformVersion", "13");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("appWaitActivity", "com.yasinkacmaz.jetflix.debug.MainActivity");
        driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @AfterClass
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void stopAppiumServer(){
        if (appiumServerProcess != null) {
            appiumServerProcess.destroy(); // Gracefully terminate the server process
        }
    }
}
