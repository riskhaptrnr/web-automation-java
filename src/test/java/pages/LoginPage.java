package pages;

import helper.Action;

import java.util.HashMap;
import java.util.Map;

public class LoginPage extends Action {
    public Map<String, String> elementKey = new HashMap<>();

    public LoginPage() {
        super();
    }

    public String elementLoginPage(String key) {
        elementKey.put("username", username);
        elementKey.put("password", password);
        elementKey.put("loginButton", loginButton);
        return elementKey.get(key);
    }

    public String username = "//*[@id='user-name']";
    public String password = "//*[@id='password']";
    public String loginButton = "//*[@id='login-button']";


}
