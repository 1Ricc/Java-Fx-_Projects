package model.titlekinds;

import model.LanguagesEnum;

public class SeriesTitle extends AbstractTitle{

    private int seasons;

    public SeriesTitle(String n, int y, LanguagesEnum l, int s, int p) {
        super(n, y, l, p);
        this.seasons = s;
    }

    public int getSeasons(){
        return seasons;
    }

    public String getType(){
        return "Serie, "+this.seasons+" stagioni";
    }

    protected double getSeriesDiscount(int ss){
        if (ss > 0){
            if (ss == this.seasons){
                return (double) this.getPrice()/2;
            }
            return (double) this.getPrice()/4;
        }
        return 0;
    }
}
