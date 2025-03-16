package org.skypro.skyshop.searchProduct;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;


public class SearchEngine {
    List<Searchable> searchObject;

    public SearchEngine() {
        this.searchObject = new ArrayList<>();
    }

    public List<Searchable> search(String searchTerm) {
        List<Searchable> result = new ArrayList<>();
        for (Searchable searchable : searchObject) {
            if (searchable.getStringRepresentation().contains(searchTerm)) {
                result.add(searchable);
            }
        }
        return result;
    }

    public void add(Searchable object) {
        searchObject.add(object);
    }

    public List<Searchable> getSearchTerm(String search) throws BestResultNotFound {

        if (searchObject == null || search == null) {
            throw new IllegalArgumentException("Поисковый запрос не может иметь значения null");
            }

        List<Searchable> results = new ArrayList<>();
        for (Searchable obj : searchObject) {
            if (obj != null && obj.toString().contains(search)) {
                System.out.println("Найдено: " + obj);
                results.add(obj);
            }
        }

        if (results.isEmpty()) {
            throw new BestResultNotFound("Для поисковой строки " + search + " не нашлось подходящей статьи");
            }

        return results;
        }
}


