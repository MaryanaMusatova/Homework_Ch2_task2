package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private static final int lengthOfProduct = 5;
    private final Product[] basket;

    public ProductBasket() {
        this.basket = new Product[lengthOfProduct];

    }

    public void addProductInBasket(Product product) {
        int flag = 0;
        for (int i = 0; i < lengthOfProduct; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                return;
            } else {
                flag++;
            }
        }
        if (flag >= 5) {
            System.out.println("Невозможно добавить продукт!");
        }
    }


    public int sumOfBasket() {
        int sum = 0;
        for (Product product : basket) {
            if (product != null) sum += product.getPrice();
        }
        return sum;
    }

    public void printProductBasket() {
        int flag = 0;
        for (Product product : basket) {
            if (product != null) System.out.println(product);
            flag++;
        }
        System.out.printf("Итого: %d\n", this.sumOfBasket());

        if (flag == 0) System.out.println("В корзине пусто!");
    }

    public void clearProductBasket() {
        for (int i = 0; i < lengthOfProduct; i++) {
            basket[i] = null;
        }
    }

    public boolean checkAvailability(String title) {
        boolean check = false;
        for (Product p : basket) {
            if (p == null) continue;
            if (title.equals(p.getTitle())) {
                check = true;
                break;
            }
        }
        return check;
    }

    @Override
    public String toString() {
        return Arrays.toString(basket);
    }
}