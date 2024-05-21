package hook;

import com.google.common.util.concurrent.Uninterruptibles;
import helper.WebdriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import util.ConfigFileReader;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    @Before // Run before scenarios
    public static void setUp() {
        //WebdriverFactory.getDriver(); // Initialize WebDriver
        ConfigFileReader configFileReader= new ConfigFileReader();
        WebdriverFactory.getDriver().get(configFileReader.getApplicationUrl());
        WebdriverFactory.getDriver().manage().window().maximize();
        WebdriverFactory.getDriver().getWindowHandle();
    }

    @After // Run after scenarios
    public void tearDown() throws InterruptedException {
        System.out.println("Close from hooks");
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        WebdriverFactory.quitDriver(); // Quit WebDriver
    }
}
