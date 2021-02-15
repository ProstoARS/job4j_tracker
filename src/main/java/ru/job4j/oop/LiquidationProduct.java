package ru.job4j.oop;

public final class LiquidationProduct {
    private Product product;

    public LiquidationProduct(String name, int price) {
        product = new Product(name, price);
    }


    public int discount() {
        return 90;
    }

    public String label() {
        return product.label();
    }

    public Product getProduct() {
        return product;
    }
}

