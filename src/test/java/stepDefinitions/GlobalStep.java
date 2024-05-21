package stepDefinitions;

import helper.Action;
import helper.DataConstant;
import helper.WebdriverFactory;
import hook.BaseTest;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import util.ConfigFileReader;

import java.io.File;

import static helper.Action.driver;
import static org.openqa.selenium.Keys.ENTER;

public class GlobalStep extends BasePage {

    DataConstant dataConstant = new DataConstant();

    @Given("User open the web")
    public void userOpenTheWeb() {
        System.out.println("Open the Dashboard");
        BaseTest.setUp();
    }

    @And("User can wait loading application for {string} seconds")
    public void userCanWaitLoadingForSeconds(String index) throws InterruptedException {
        int intIndex = Integer.parseInt(index);
        Thread.sleep(intIndex * 1000);
    }


    @When("User click on {string} on page {string}")
    public void tapOn(String element, String page) throws Exception {
        action.click(Action.Direction.XPATH, locatePageElement(element, page));
    }

    @When("User fill {string} input value {string} in {string} page")
    public void userFill(String element, String value, String page) throws Exception {
        action.sendText(Action.Direction.XPATH, locatePageElement(element, page), value);

    }

    @When("User click on text {string}")
    public void tapOnText(String text) throws Exception {
        action.clickByText(text);
    }

    @Then("User will be receive alert message {string}")
    public void verifyMessageAlert(String message) {
        action.verifyTextElement(message);
    }

    @Then("User will be displayed value text {string}")
    public void validateDisplayed(String message) {
        action.verifyTextElement(message);
    }

    @Then("User will be redirected to {string} page")
    public void redirectedToPage(String message) {
        action.verifyTextElement(message);
    }


}

