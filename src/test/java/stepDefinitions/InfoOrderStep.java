package stepDefinitions;

import helper.Action;
import helper.DataConstant;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.BasePage;

public class InfoOrderStep extends BasePage {
    int actulTotalPrice, numberPrice2, numberPrice1;
    String getText;
    DataConstant dataConstant = new DataConstant();

    @When("Verify get information checkout {string} on {string} page")
    public void getValue(String element, String page) throws Exception {
        try {
            getText = action.getText(Action.Direction.XPATH, locatePageElement(element, page));
            numberPrice1 = Integer.parseInt(action.splitNumberSpecChar(getText));
            dataConstant.setPriceProduct(numberPrice1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @When("Verify get information detail {string} on {string} page")
    public void getValue2(String element, String page) throws Exception {
        try {
            getText = action.getText(Action.Direction.XPATH, locatePageElement(element, page));
            numberPrice2 = Integer.parseInt(action.splitNumberSpecChar(getText));
            dataConstant.setPriceProduct2(numberPrice2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Then("Verify information price total order {string} on {string} page")
    public void verifyPriceTotal(String element, String page) throws Exception {
        int tax = 320;
        int expectedTotalPrice = dataConstant.getPriceProduct() + dataConstant.getPriceProduct2() + tax;
        try {
            actulTotalPrice = Integer.parseInt(action.splitPriceTotal(action.getText(Action.Direction.XPATH, locatePageElement(element, page))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(expectedTotalPrice, actulTotalPrice);

    }
}
