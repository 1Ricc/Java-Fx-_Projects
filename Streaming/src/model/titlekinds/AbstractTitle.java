package model.titlekinds;

import model.LanguagesEnum;

public abstract class AbstractTitle implements Title {

    private String name;
    private int year;
    private String shortYear;
    private LanguagesEnum language;
    private int prezzobase;

    AbstractTitle(String n, int y, LanguagesEnum l, int p){
        this.name = n;
        this.year = y;
        String sy = new String("'"+String.valueOf(y%100));
        this.shortYear = sy;
        this.language = l;
        this.prezzobase = p;
    }
    public String getTitle(){
        return this.name;
    }
    public String getShortTitle(){
        return this.name+" ("+this.shortYear+")";
    }
    public String getLanguage(){
        return this.language.name();
    }
    public String getType(){
        if (this instanceof AnimeTitle){
            return "Anime";
        }
        if (this instanceof FilmTitle){
            return "Film";
        }
        if (this instanceof SeriesTitle){
            return "Serie";
        }
        return null;
    }
    public int getYear(){
        return this.year;
    }

    public String toString(){
        return this.name+" "+this.year+" ";
    }

    public int getPrice(){
        return this.prezzobase;
    }

    protected double getYearDiscount(){
        double ret = 0;
        if( this.year < 2015){
            ret = (double) this.getPrice() * 10/100;
        }
        return ret;
    }
    protected double getSeriesDiscount(int ss){
        return 0;
    }
    public double getDiscountPrice(int ss){
        double ret = this.getPrice();
        double s1 = this.getYearDiscount();
        double s2 = this.getSeriesDiscount(ss);
        ret -= s1;
        ret -= s2;
        return ret;
    }
}
