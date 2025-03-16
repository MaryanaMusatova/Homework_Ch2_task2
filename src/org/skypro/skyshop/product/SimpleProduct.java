package org.skypro.skyshop.product;


public class SimpleProduct extends Product {
    int priceSimpleProduct;

    public SimpleProduct(String title, int priceSimpleProduct) {
        super(title);

        if (priceSimpleProduct > 1) {
            this.priceSimpleProduct = priceSimpleProduct;
        } else {
            throw new IllegalArgumentException("Цена продукта должна быть строго больше 0");


        }
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
