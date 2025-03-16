package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ProductBasket {
    List<Product> basket;

    public ProductBasket() {
        this.basket = new ArrayList<>();
    }

    public void addProductInBasket(Product product) {
        basket.add(product);
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

        if (flag != 0) {
            System.out.printf("Итого: %d\n", this.sumOfBasket());
        } else {
            System.out.println("В корзине пусто!");
        }
    }

    public void clearProductBasket() {
        basket.clear();
    }

    public boolean checkAvailability(String title) {
        boolean check = false;
        for (Product p : basket) {
            if (p != null && title.equals(p.getTitle())) {
                check = true;
                break;
            }
        }
        return check;
    }

    public List<Product> countingSpecialItems() {
        int specialCount = 0;
        for (Product product : basket) {
            if (product != null && product.isSpecial()) {
                specialCount++;
                System.out.println(product.getTitle() + ": " + product.getPrice() + " (Специальный товар)");
            } else {
                System.out.println(product);
            }
        }
        System.out.println("Специальных товаров: " + specialCount);
        if (specialCount == 0) {
            System.out.println("Специальных товаров нет");
        }
        return List.of();
    }

    public List<Product> deleteProduct(String name) {

        List<Product> deleted = new ArrayList<>();
        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getTitle().equals(name)) {
                deleted.add(product);
                iterator.remove();
            }
        }

        if (deleted.isEmpty()) {
            System.out.println("Список удаленных продуктов пуст.");
        } else {
            System.out.println("Удаленные продукты: " + deleted);
        }
        return deleted;

    }
}
