package model.fans.comparators;

import model.fans.AbstractFan;

import java.util.Comparator;

public class CostFanComparator implements Comparator<AbstractFan> {
    @Override
    public int compare(AbstractFan o1, AbstractFan o2) {
        int ret = o1.getCosto()-o2.getCosto();
        if (ret>0){
            return 1;
        }
        if (ret<0){
            return -1;
        }
        TypeFanComparator tfc = new TypeFanComparator();
        return tfc.compare(o1, o2);
    }

    public int compareDirect(AbstractFan o1, AbstractFan o2) {
        int ret = o1.getCosto()-o2.getCosto();
        if (ret>0){
            return 1;
        }
        if (ret<0){
            return -1;
        }
        return 0;
    }
}
