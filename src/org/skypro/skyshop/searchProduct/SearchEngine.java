package org.skypro.skyshop.searchProduct;

import org.skypro.skyshop.exceptions.BestResultNotFound;

public class SearchEngine {
    Searchable[] searchObject;
    int size;

    public SearchEngine(int size) {
        this.size = size;
        searchObject = new Searchable[size];
    }

    public Searchable[] search(String searchTerm) {
        Searchable[] result = new Searchable[5];
        for (int i = 0; i < size; i++) {
            if (searchObject[i].getStringRepresentation().contains(searchTerm)) {
                int count = 0;
                result[count] = searchObject[i];
                if (i == size) {
                    break;
                }
            }
        }
        return result;
    }


    public void add(Searchable object) {
        for (int i = 0; i < size; i++) {
            if (searchObject[i] == null) {
                searchObject[i] = object;
                break;
            }
        }
    }

    public Searchable getSearchTerm(String search) throws BestResultNotFound {
        Searchable searchable = null;
        for (int i = 0; i < searchObject.length; i++) {
            if (searchObject[i].toString().contains(search)) {
                System.out.println(searchObject[i].toString());
                searchable = searchObject[i];
            }
        }
        if (searchable != null) {
            return searchable;
        } else throw new BestResultNotFound("Для поисковой строки " + search + " не нашлось подходящей статьи");
    }
}

