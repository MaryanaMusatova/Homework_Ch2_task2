package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {


    public static void main(String[] args) {
        Product[] product = new Product[5];
        product[0] = new Product("капуста белокачанная, кг", 34);
        product[1] = new Product("куриное филе,кг", 297);
        product[2] = new Product("хлеб Чиабатта пшеничная, шт", 60);
        product[3] = new Product("крупа гречневая, 800гр", 34);
        product[4] = new Product("картофель, кг", 44);

        ProductBasket basket = new ProductBasket();

        System.out.println("Добавление товара в корзину");
        basket.addProductInBasket(product[0]);
        basket.addProductInBasket(product[1]);
        basket.addProductInBasket(product[2]);
        basket.addProductInBasket(product[4]);

        System.out.println("и печать содержимого корзины с несколькими товарами:");
        basket.printProductBasket();
        System.out.println();

        System.out.println("Получение стоимости корзины с несколькими товарами:");
        System.out.println(basket.sumOfBasket());
        System.out.println();

        System.out.println("Добавление товара \"крупа гречневая, 800гр\" в корзину");
        basket.addProductInBasket(product[3]);

        System.out.println("и печать содержимого корзины с добавленным товаром:");
        basket.printProductBasket();
        System.out.println();

        System.out.println("Добавление товара в заполненную корзину, в которой нет свободного места:");
        basket.addProductInBasket(product[4]);
        System.out.println();

        System.out.println("Получение стоимости корзины с несколькими товарами:");
        System.out.println(basket.sumOfBasket());
        System.out.println();

        System.out.println("Поиск товара \"куриное филе,кг\", который есть в корзине:");
        System.out.println(basket.checkAvailability("куриное филе,кг"));
        System.out.println();

        System.out.println("Поиск товара \"морковь\", которого нет в корзине:");
        System.out.println(basket.checkAvailability("морковь"));
        System.out.println();

        System.out.println("Очистка корзины");
        basket.clearProductBasket();

        System.out.println("и печать содержимого пустой корзины:");
        basket.printProductBasket();
        System.out.println();

        System.out.println("Получение стоимости пустой корзины:");
        System.out.println(basket.sumOfBasket());
        System.out.println();

        System.out.println("Поиск товара по имени \"куриное филе\" в пустой корзине:");
        System.out.println(basket.checkAvailability("куриное филе"));
    }
}