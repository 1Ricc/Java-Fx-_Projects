package model.classifica;

import java.util.Comparator;

public class ClassificaEntryComparator implements Comparator<ClassificaEntry> {

    @Override
    public int compare(ClassificaEntry o1, ClassificaEntry o2) {
        if (o1.getTotal() == o2.getTotal()){
            return o1.getUsername().compareTo(o2.getUsername());
        }
        if (o1.getTotal() < o2.getTotal()){
            return 1;
        }
        return -1;
    }
}
