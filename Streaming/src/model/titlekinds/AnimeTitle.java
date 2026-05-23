package model.titlekinds;

import model.LanguagesEnum;

public class AnimeTitle extends AbstractTitle{
    public AnimeTitle(String n, int y, LanguagesEnum l, int p) {
        super(n, y, l, p);
    }

    public String getLanguage(){
        return super.getLanguage()+" ("+this.getSubLang()+")";
    }

    public String getSubLang(){
        return "no subs";
    }

}
