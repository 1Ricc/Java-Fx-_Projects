package model.comparators;

import model.titlekinds.Title;

import java.util.Comparator;

public class TitleYearComparator implements Comparator<Title> {
    @Override
    public int compare(Title o1, Title o2) {
        int result = Double.compare(o1.getYear(), o2.getYear());
        if (result == 0){
            return new TitleNameComparator().compare(o1,o2);
        }
        return result;
    }
}
