package org.skypro.skyshop.searchProduct;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private final Map<String, Searchable> searchObject;

    public SearchEngine() {
        this.searchObject = new TreeMap<>();
    }

    public List<Searchable> search(String searchTerm) {
        List<Searchable> result = new ArrayList<>();
        for (Map.Entry<String, Searchable> entry : searchObject.entrySet()) {
            Searchable searchable = entry.getValue();
            if (searchable.searchTerm().contains(searchTerm)) {
                result.add(searchable);
            }
        }
        return result;
    }

    public void add(Searchable object) {
        if (object == null) {
            throw new IllegalArgumentException("Поисковый запрос не может быть null");
        }
        searchObject.putIfAbsent(object.searchTerm(), object);//или здесь лучше использовать просто put?
    }

    public Searchable getSearchTerm(String search) throws BestResultNotFound {
        if (search == null) {
            throw new IllegalArgumentException("Поисковый запрос не может быть null");
        }

        for (Map.Entry<String, Searchable> entry : searchObject.entrySet()) {
            Searchable searchable = entry.getValue();
            if (searchable != null && searchable.getStringRepresentation().contains(search)) {
                return searchable;
            }
        }

        throw new BestResultNotFound("Для поисковой строки " + search + " не нашлось подходящей статьи");
    }
}


