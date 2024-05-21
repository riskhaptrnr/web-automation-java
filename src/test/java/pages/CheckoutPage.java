package pages;

import helper.Action;

import java.util.HashMap;
import java.util.Map;

public class CheckoutPage extends Action {
    public Map<String, String> elementKey = new HashMap<>();

    public CheckoutPage() {
        super();
    }

    public String elementCheckoutPage(String key) {
        elementKey.put("continueButton", continueButton);
        elementKey.put("priceProductCheckout", priceProductCheckout);
        elementKey.put("firstname", firstname);
        elementKey.put("lastname", lastname);
        elementKey.put("postalCode", postalCode);
        elementKey.put("checkoutButton", checkoutButton);
        return elementKey.get(key);
    }

    public String continueButton = "//*[@id='continue']";
    public String priceProductCheckout = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]";
    public String firstname = "//*[@id='first-name']";
    public String lastname = "//*[@id='last-name']";
    public String postalCode = "//*[@id='postal-code']";
    public String checkoutButton = "//*[@id='checkout']";

}
