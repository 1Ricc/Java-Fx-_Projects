package model.classifica;

import java.util.Collection;
import java.util.TreeSet;

public class Classifica {
    private TreeSet<ClassificaEntry> ace = new TreeSet<>(new ClassificaEntryComparator());

    public void add(ClassificaEntry ce){
        this.ace.add(ce);
    }

    public Collection<ClassificaEntry> getClassifica(){
        return this.ace;
    }
}
