package model.titlekinds;

import model.LanguagesEnum;

public class AnimeWithSubTitle extends AnimeTitle {

    private String sublang;

    public AnimeWithSubTitle(String n, int y, LanguagesEnum l, LanguagesEnum sl, int p) {
        super(n, y, l, p);
        this.sublang = sl.name().substring(0,3);
    }

    public String getSubLang(){
        return "sub "+this.sublang;
    }

}
