package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductBasket {
    Map<String, List<Product>> basket;

    public ProductBasket() {
        this.basket = new HashMap<>();
    }

    public void addProductInBasket(Product product) {

        String title = product.getTitle();
        List<Product> productList = basket.computeIfAbsent(product.getTitle(), k -> new ArrayList<>());
        productList.add(product);
        basket.put(title, productList);
    }

    public int sumOfBasket() {
        int sum = 0;
        for (List<Product> products : basket.values()) {
            for (Product product : products) {
                if (product != null) sum += product.getPrice();
            }
        }
        return sum;
    }

    public void printProductBasket() {
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто!");
            return;
        }

        for (Map.Entry<String, List<Product>> entry : basket.entrySet()) {
            for (Product product : entry.getValue()) {
                if (product != null) {
                    System.out.println(product);
                }
            }
        }
        System.out.printf("Итого: %d\n", this.sumOfBasket());
    }

    public void clearProductBasket() {
        basket.clear();
    }

    public boolean checkAvailability(String title) {
        return basket.containsKey(title) && !basket.get(title).isEmpty();
    }

    public List<Product> countingSpecialItems() {
        int specialCount = 0;
        for (List<Product> products : basket.values()) {
            for (Product product : products) {
                if (product != null && product.isSpecial()) {
                    specialCount++;
                    System.out.println(product.getTitle() + ": " + product.getPrice() + " (Специальный товар)");
                } else if (product != null) {
                    System.out.println(product);
                }
            }
        }
        System.out.println("Специальных товаров: " + specialCount);
        if (specialCount == 0) {
            System.out.println("Специальных товаров нет");
        }
        return List.of();
    }

    public List<Product> deleteProduct(String name) {

        List<Product> deleted = basket.remove(name);

        if (deleted == null || deleted.isEmpty()) {
            System.out.println("Список удаленных продуктов пуст.");
            return List.of();
        } else {
            System.out.println("Удаленные продукты: " + deleted);
            return deleted;
        }
    }
}

