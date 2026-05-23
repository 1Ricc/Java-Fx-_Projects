package model.fans.comparators;

import model.fans.AbstractFan;

import java.util.Comparator;

public class TypeFanComparator implements Comparator<AbstractFan> {
    @Override
    public int compare(AbstractFan o1, AbstractFan o2) {
        int ret = AbstractFan.fanToInt(o1) - AbstractFan.fanToInt(o2);
        if (ret == 0){
            CostFanComparator cf = new CostFanComparator();
            return cf.compareDirect(o1,o2);
        }
        return ret;
    }
    public int compareDirect(AbstractFan o1, AbstractFan o2) {
        int ret = AbstractFan.fanToInt(o1) - AbstractFan.fanToInt(o2);
        return ret;
    }
}
