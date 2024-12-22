package org.skypro.skyshop.product;


public class SimpleProduct extends Product {
    int priceSimpleProduct;

    public SimpleProduct(String title, int priceSimpleProduct) {
        super(title);

        if (priceSimpleProduct <= 0) {
            System.out.println("Цена продукта должна быть строго больше 0");
        }
        this.priceSimpleProduct = priceSimpleProduct;
    }

    @Override
    public int getPrice() {
        return priceSimpleProduct;
    }

    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getTitle() + ": " + getPrice();
    }
}
