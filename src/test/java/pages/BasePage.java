package pages;

import helper.Action;

public class BasePage {
    public Action action;
    public LoginPage loginPage;
    public HomePage homePage;
    public CheckoutPage checkoutPage;
    public DetailPage detailPage;
    public InfoOrderPage infoOrderPage;


    public BasePage() {
        action = new Action();
        loginPage = new LoginPage();
        homePage = new HomePage();
        checkoutPage = new CheckoutPage();
        detailPage = new DetailPage();
        infoOrderPage = new InfoOrderPage();
    }

    public String locatePageElement(String element, String page) {
        String res = null;
        switch (page) {
            case "Login":
                res = loginPage.elementLoginPage(element);
                break;
            case "Home":
                res = homePage.elementHomePage(element);
                break;
            case "Checkout":
                res = checkoutPage.elementCheckoutPage(element);
                break;
            case "Detail":
                res = detailPage.elementDetailPage(element);
                break;
            case "Info Order":
                res = infoOrderPage.elementInfoOrderPage(element);
                break;

        }
        return res;
    }
}
