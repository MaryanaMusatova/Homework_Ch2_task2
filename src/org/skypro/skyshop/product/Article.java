package org.skypro.skyshop.product;

import org.skypro.skyshop.searchProduct.Searchable;

public class Article implements Searchable {

    String titleArticle;
    String textArticle;

    public Article(String titleArticle, String textArticle) {
        this.titleArticle = titleArticle;
        this.textArticle = textArticle;
    }


    @Override
    public String toString() {
        return "Название статьи = " + titleArticle + " , Текст статьи = " + textArticle;
    }

    @Override
    public String searchTerm() {
        return titleArticle + " , " + textArticle;
    }

    @Override
    public String searchTipContent() {
        return "ARTICLE";
    }
}

