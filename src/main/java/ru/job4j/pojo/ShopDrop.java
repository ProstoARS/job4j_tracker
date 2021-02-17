package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        Product temp = null;
        for (int i = index; i < products.length; i++) {
            if (i + 1 < products.length) {
                temp = products[i + 1];
            } else {
                temp = null;
            }
            products[i] = temp;
        }
        return products;
    }
}
