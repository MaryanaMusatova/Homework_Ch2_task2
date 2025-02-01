package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchProduct.SearchEngine;

import java.util.Arrays;


public class App {


    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        System.out.println("Добавление товара в корзину");
        basket.addProductInBasket(new SimpleProduct("капуста белокачанная, кг", 34));
        basket.addProductInBasket(new SimpleProduct("куриное филе,кг", 297));
        basket.addProductInBasket(new SimpleProduct("хлеб Чиабатта пшеничная, шт", 60));
        basket.addProductInBasket(new FixPriceProduct("картофель, кг", 25));

        System.out.println("и печать содержимого корзины с несколькими товарами:");
        basket.printProductBasket();
        System.out.println();

        System.out.println("Получение стоимости корзины с несколькими товарами:");
        System.out.println(basket.sumOfBasket());
        System.out.println();

        System.out.println("Добавление товара \"крупа гречневая\" в корзину");
        basket.addProductInBasket(new DiscountedProduct("крупа гречневая", 50, 30));

        System.out.println("и печать содержимого корзины с добавленным товаром:");
        basket.printProductBasket();
        System.out.println();

        System.out.println("Специальных товаров: ");
        basket.countingSpecialItems();
        System.out.println();

        System.out.println("Добавление товара в заполненную корзину, в которой нет свободного места:");
        basket.addProductInBasket(new SimpleProduct("куриное филе,кг", 297));
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


        System.out.println();

        System.out.println("ДЗ ПОЛИМОРФИЗМ. ИНТЕРФЕЙСЫ");
        Article article1 = new Article(
                "Статья о капусте белокочанной",
                "Белокочанная капуста — овощная культура, ценный и широко распространённый пищевой продукт"
        );
        Article article2 = new Article(
                "Статья о курином филе",
                "Куриным филе обычно называют белое мясо куриной грудки, очищенное от кожи, хрящей и костей. Куриное филе считается самым диетическим мясом из всей курицы, благодаря наименьшему количеству жиров и пищевых волокон"
        );

        SearchEngine searchEngine = new SearchEngine(5);
        searchEngine.add(new SimpleProduct("капуста белокачанная, кг", 34));
        searchEngine.add(new SimpleProduct("куриное филе,кг", 297));
        searchEngine.add(new FixPriceProduct("картофель, кг", 25));
        searchEngine.add(article1);
        searchEngine.add(article2);

        System.out.println(Arrays.toString(searchEngine.search("овощная культура")));
        System.out.println(Arrays.toString(searchEngine.search("белое")));





    }
}








