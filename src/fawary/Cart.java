package fawary;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    List<CartItem> items = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
        if (product.isExpired()) {
            System.out.println("Error: Cannot add " + product.name + " it's expired ");
            return;
        }
        if (quantity > product.quantity) {
            System.out.println("Error: Not enough " + product.name + " in stock");
            return;
        }
        items.add(new CartItem(product, quantity));
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
