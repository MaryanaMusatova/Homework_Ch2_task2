package org.skypro.skyshop.product;
import org.skypro.skyshop.searchProduct.Searchable;

public abstract class Product implements Searchable {
    private String title;

    public Product(String title) {
        if (title != null && !title.isBlank()) {
            this.title = title;
        } else throw new IllegalArgumentException("Неправильное название продукта");

    }

    public String getTitle() {
        return title;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();


    @Override
    public String searchTerm() {
        return title;
    }

    @Override
    public String searchTipContent() {
        return "PRODUCT";
    }

}
