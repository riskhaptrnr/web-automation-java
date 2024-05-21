package pages;

import helper.Action;

import java.util.HashMap;
import java.util.Map;

public class HomePage extends Action {
    public Map<String, String> elementKey = new HashMap<>();

    public HomePage() {
        super();
    }

    public String elementHomePage(String key) {
        elementKey.put("addToCart", addToCart);
        elementKey.put("cartButton", cartButton);
        elementKey.put("optionButton", optionButton);
        elementKey.put("logoutButton", logoutButton);
        return elementKey.get(key);
    }

    public String addToCart = "//*[@id='add-to-cart-sauce-labs-backpack']";
    public String cartButton = "//*[@id='shopping_cart_container']";
    public String optionButton = "//*[@id='react-burger-menu-btn']";
    public String logoutButton = "//*[@id='logout_sidebar_link']";
}
