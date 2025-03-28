package org.skypro.skyshop.product;

import org.skypro.skyshop.searchProduct.Searchable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return titleArticle.equals(article.titleArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleArticle);
    }
}

