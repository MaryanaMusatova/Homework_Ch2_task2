package org.skypro.skyshop.searchProduct;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SearchEngine {
    private final Set<Searchable> searchObject;

    public SearchEngine() {
        this.searchObject = new HashSet<>();
    }

    public Set<Searchable> search(String searchTerm) {
        Set<Searchable> result = new TreeSet<>(new SearchComparator());
        for (Searchable searchable : searchObject) {
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
        searchObject.add(object);
    }

    public Searchable getSearchTerm(String search) throws BestResultNotFound {
        if (search == null) {
            throw new IllegalArgumentException("Поисковый запрос не может быть null");
        }

        for (Searchable searchable : searchObject) {
            if (searchable != null && searchable.getStringRepresentation().contains(search)) {
                return searchable;
            }
        }

        throw new BestResultNotFound("Для поисковой строки " + search + " не нашлось подходящей статьи");
    }
}


