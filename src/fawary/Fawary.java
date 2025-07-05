package fawary;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fawary {

    public static void main(String[] args) {

        final double SHIPPING_RATE_PER_KG = 30;

        Product meat = new Product("Meat", 300, 5, true, LocalDate.now().plusDays(5), true, 0.5);
        Product chicken = new Product("Chicken", 150, 3, true, LocalDate.now().plusDays(2), true, 0.8);
        Product scratchCard = new Product("Mobile Scratch Card", 50, 100, false, null, false, 0);
        Product tv = new Product("TV", 900, 10, false, null, true, 3.5);
        Product mobile = new Product("Mobile", 600, 5, false, null, true, 2.2);
        Product milk = new Product("Milk", 50, 10, true, LocalDate.now().minusDays(2), true, 1.0);
        
        Cart cart = new Cart();
        Customer customer = new Customer("Ahmed", 5000);

        cart.addProduct(milk, 1);
        checkout(customer, cart, SHIPPING_RATE_PER_KG);

    }

    public static void checkout(Customer customer, Cart cart, double shippingRatePerKg) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        }

        double subtotal = 0;
        double totalShippingWeight = 0;
        List<CartItem> itemsToShip = new ArrayList<>();

        for (CartItem item : cart.items) {
            Product p = item.product;

            subtotal += p.price * item.quantity;

            if (p.isShippable) {
                itemsToShip.add(item); // Add the whole CartItem
                totalShippingWeight += p.weight * item.quantity;
            }
        }

        double shippingFee = totalShippingWeight * shippingRatePerKg;
        double totalAmount = subtotal + shippingFee;

        if (totalAmount > customer.balance) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        if (!itemsToShip.isEmpty()) {
            ShippingService.shipItems(itemsToShip);
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.items) {
            System.out.printf("%dx %s %.0f%n", item.quantity, item.product.name, item.product.price * item.quantity);
            item.product.quantity -= item.quantity;
        }
        System.out.println("----------------------");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping: " + shippingFee);
        System.out.println("Amount: " + totalAmount);

        customer.balance -= totalAmount;
        System.out.println("current balance: " + customer.balance);

    }
}
