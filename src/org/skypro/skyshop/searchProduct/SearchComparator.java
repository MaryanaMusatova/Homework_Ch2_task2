package org.skypro.skyshop.searchProduct;

import java.util.Comparator;

public class SearchComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable s1, Searchable s2) {
        String s1String = s1.getStringRepresentation();
        String s2String = s2.getStringRepresentation();

        int lengthCompare = Integer.compare(s1String.length(), s2String.length());
        return lengthCompare != 0 ? lengthCompare : s1String.compareTo(s2String);
    }
}