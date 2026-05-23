package model.comparators;

import model.titlekinds.Title;

import java.util.Comparator;

public class TitleNameComparator implements Comparator<Title> {
    @Override
    public int compare(Title o1, Title o2) {
        int result = o1.getTitle().compareTo(o2.getTitle());
        if (result == 0){
            throw new RuntimeException();
        }
        return result;
    }
}
