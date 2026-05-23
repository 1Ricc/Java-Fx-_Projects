package model.comparators;

import model.titlekinds.Title;

import java.util.Comparator;

public class TitleTypeComparator implements Comparator<Title> {
    @Override
    public int compare(Title o1, Title o2) {
        int result = o1.getType().compareTo(o2.getType());
        if (result == 0){
            return new TitleNameComparator().compare(o1,o2);
        }
        return result;
    }
}
