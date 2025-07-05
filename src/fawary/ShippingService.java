package fawary;

import java.util.List;

public class ShippingService {

    public static void shipItems(List<CartItem> items) {
        double totalWeight = 0;
        System.out.println("** Shipment notice **");
        for (CartItem item : items) {
            System.out.printf("%dx %s %.0fg%n", item.quantity, item.product.name, item.product.weight * 1000 * item.quantity);
            totalWeight += item.product.weight * item.quantity;
        }
        System.out.printf("Total package weight %.1fkg%n", totalWeight);
    }
}
