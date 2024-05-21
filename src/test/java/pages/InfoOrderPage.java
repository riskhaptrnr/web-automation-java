package pages;

import helper.Action;

import java.util.HashMap;
import java.util.Map;

public class InfoOrderPage extends Action {

    public Map<String, String> elementKey = new HashMap<>();

    public InfoOrderPage() {
        super();
    }

    public String elementInfoOrderPage(String key) {
        elementKey.put("finishButton", finishButton);
        elementKey.put("priceTotal", priceTotal);
        elementKey.put("backToHome", backToHome);
        return elementKey.get(key);
    }

    public String finishButton = "//*[@id='finish']";
    public String priceTotal = "//*[@class='summary_total_label']";
    public String backToHome = "//*[@id='back-to-products']";
}
