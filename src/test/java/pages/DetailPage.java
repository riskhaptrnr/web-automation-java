package pages;

import java.util.HashMap;
import java.util.Map;

public class DetailPage {

    public Map<String, String> elementKey = new HashMap<>();

    public DetailPage() {
        super();
    }

    public String elementDetailPage(String key) {
        elementKey.put("addToCartDetail", addToCartDetail);
        elementKey.put("priceProductDetail", priceProductDetail);
        elementKey.put("cartButtonDetail", cartButtonDetail);
        return elementKey.get(key);
    }

    public String priceProductDetail = "//*[@class='inventory_details_price']";
    public String addToCartDetail = "//*[@id='add-to-cart']";
    public String cartButtonDetail = "//*[@id='shopping_cart_container']";

}
