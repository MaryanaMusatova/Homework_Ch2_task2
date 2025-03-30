package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private final Map<String, List<Product>> basket;

    public ProductBasket() {
        this.basket = new HashMap<>();
    }

    public void addProductInBasket(Product product) {

        basket.computeIfAbsent(product.getTitle(), k -> new ArrayList<>()).add(product);
    }

    public int sumOfBasket() {
        return basket.values().stream()
                .flatMap(List::stream)
                .filter(Objects::nonNull)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printProductBasket() {
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто!");
            return;
        }

        basket.values().stream()
                .flatMap(List::stream)
                .filter(Objects::nonNull)
                .forEach(System.out::println);

        System.out.printf("Итого: %d\n", sumOfBasket());
    }

    public void clearProductBasket() {
        basket.clear();
    }

    public boolean checkAvailability(String title) {
        return basket.values().stream().flatMap(Collection::stream)
                .anyMatch(product -> product.getTitle().contains(title));
    }

    public List<Product> countingSpecialItems() {
        long specialCount = basket.values().stream()
                .flatMap(List::stream)
                .filter(Objects::nonNull)
                .peek(product -> {
                    if (product.isSpecial()) {
                        System.out.println(product.getTitle() + ": " + product.getPrice() + " (Специальный товар)");
                    } else {
                        System.out.println(product);
                    }
                })
                .filter(Product::isSpecial)
                .count();

        System.out.println("Специальных товаров: " + specialCount);
        if (specialCount == 0) {
            System.out.println("Специальных товаров нет");
        }

        return Collections.emptyList();
    }

    public List<Product> deleteProduct(String name) {

        return Optional.ofNullable(basket.remove(name))
                .filter(list -> !list.isEmpty())
                .map(deleted -> {
                    System.out.println("Удаленные продукты: " + deleted);
                    return deleted;
                })
                .orElseGet(() -> {
                    System.out.println("Список удаленных продуктов пуст.");
                    return Collections.emptyList();
                });
    }
}