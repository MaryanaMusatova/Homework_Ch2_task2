package org.skypro.skyshop.searchProduct;



public interface Searchable {


    String searchTerm();

    String searchTipContent();

    default String getStringRepresentation() {
        return "Имя объекта: " + searchTerm() + " ;  " + " тип объекта: " + searchTipContent();
    }

}