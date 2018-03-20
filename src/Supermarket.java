package supermarket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Supermarket {

    Map<Long, Product> products = new HashMap<>();
    List<Integer> checkout = new ArrayList<>();

    public void addProduct(String productName, int price, long barCode, int specialPrice, int specialAmount) {
        products.put(barCode, new Product(productName,price, specialPrice, specialAmount));
    }

    public double scanProduct(long barCode) {
        Product product = products.get(barCode);{
            if(!products.containsKey(barCode)) {
                throw new IllegalStateException("Product hasn't been registered into the system");
            }
            return product.price;
        }
    }
    public void addToCheckout(long barCode) {
        Product product = products.get(barCode);
        if (products.containsKey(barCode)) {
            checkout.add(product.price);
        }
    }

    public double getCheckout() {
        double sum = 0;
        for (int i = 0; i < checkout.size(); i++) {
            int productPrice = checkout.get(i);
            if (productPrice > 0) {
                sum = sum + productPrice;
            }
        }
        return sum;
    }

    public double specialCheckout(long barCode, int amount) {
        Product product = products.get(barCode);
        if (products.containsKey(barCode)) {
            int wholeDivision = amount / product.specialAmount;
            int remainder = amount % product.specialAmount;
            return product.specialPrice * wholeDivision + remainder * product.price;
        }
        throw new IllegalStateException("Product hasn't been registered in the system!");
    }
}
