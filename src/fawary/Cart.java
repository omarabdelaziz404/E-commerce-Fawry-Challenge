package fawary;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    List<CartItem> items = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
        if (product.isExpired()) {
            System.out.println("Error: Cannot add expired product " + product.name);
            return;
        }
        if (quantity > product.quantity) {
            System.out.println("Error: Not enough stock for " + product.name);
            return;
        }
        items.add(new CartItem(product, quantity));
        System.out.println(quantity + "x " + product.name + " added to cart.");
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
