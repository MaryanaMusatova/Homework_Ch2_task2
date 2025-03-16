package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.searchProduct.SearchEngine;


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

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(new SimpleProduct("капуста белокачанная, кг", 34));
        searchEngine.add(new SimpleProduct("куриное филе,кг", 297));
        searchEngine.add(new FixPriceProduct("картофель, кг", 25));
        searchEngine.add(article1);
        searchEngine.add(article2);

        System.out.println((searchEngine.search("овощная культура")));
        System.out.println((searchEngine.search("белое")));

        System.out.println();
        System.out.println("ИСКЛЮЧЕНИЯ в Java");

        try {
            Product product1 = new SimpleProduct("Слива", 0);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        System.out.println("Проверка завершена");

        try {
            Product product2 = new DiscountedProduct("Шоколад", 150, 102);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        System.out.println("Проверка завершена");

        try {
            System.out.println("максимальное количество повторов строки(\"яблоко\") = " + searchEngine.getSearchTerm("яблоко"));
        } catch (BestResultNotFound e) {
            e.printStackTrace();
        }

        System.out.println("Проверка завершена");

        try {
            System.out.println("Все подходящие результаты(\"филе\") = " + searchEngine.getSearchTerm("филе"));
        } catch (BestResultNotFound e) {
            e.printStackTrace();
        }

        System.out.println("Проверка завершена");

        System.out.println();
        System.out.println("ДЗ: Java Collections Framework: List");

        basket.addProductInBasket(new SimpleProduct("ананас",185));
        basket.addProductInBasket(new DiscountedProduct("вишня",98,10));
        basket.addProductInBasket(new FixPriceProduct("яблочный сок",25));
        basket.addProductInBasket(new FixPriceProduct("конфеты мерси",25));

        System.out.println("удаление существующего продукта:");
        basket.deleteProduct("ананас");
        basket.deleteProduct("вишня");
        System.out.println("печать содержимого корзины после удаления существующего продукта:");
        basket.printProductBasket();
        System.out.println("удаление несуществующего продукта:");
        basket.deleteProduct("арбуз");
        System.out.println("печать содержимого корзины после удаления несуществующего продукта:");
        basket.printProductBasket();


    }
}
    






