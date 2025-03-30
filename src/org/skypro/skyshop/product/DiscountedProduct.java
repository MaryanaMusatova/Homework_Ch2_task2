package org.skypro.skyshop.product;

public  class DiscountedProduct extends Product {

    private int basePrice;
    private int discountPercent;

    public DiscountedProduct(String title, int basePrice, int discountPercent) {

        super(title);
        if (basePrice >= 1) {
            this.basePrice = basePrice;
        } else {
            throw new IllegalArgumentException("Базовая цена продукта должна быть строго больше 0");
        }

        if (discountPercent >= 0 && discountPercent <= 100) {
            this.discountPercent = discountPercent;
        } else {
            throw new IllegalArgumentException("Процент скидки должен быть числом в диапазоне от 0 до 100 включительно");
        }
    }


    public boolean isSpecial() {
        return true;
    }

    @Override
    public int getPrice() {
        return basePrice - (basePrice * discountPercent / 100);
    }

    @Override
    public String toString() {
        return getTitle() + ": цена со скидкой: " + getPrice() +"(скидка " +discountPercent+"% )";
    }



}
