package fawary;

import java.time.LocalDate;

public class Product implements Shippable {

    String name;
    double price;
    int quantity;
    boolean isExpirable;
    LocalDate expiryDate;
    boolean isShippable;
    double weight; // in kg

    public Product(String name, double price, int quantity, boolean isExpirable, LocalDate expiryDate, boolean isShippable, double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isExpirable = isExpirable;
        this.expiryDate = expiryDate;
        this.isShippable = isShippable;
        this.weight = weight;
    }

    public boolean isExpired() {
        if (isExpirable && expiryDate != null) {
            return expiryDate.isBefore(LocalDate.now());
        }
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
