package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    static int FIX_PRICE = 25;

    public FixPriceProduct(String title, int FIX_PRICE) {
        super(title);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getTitle() + ": фиксированная цена: " + getPrice();
    }


}
