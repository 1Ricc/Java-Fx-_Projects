package model.titlekinds;

public interface Title {
    String getTitle();
    String getShortTitle();
    String getLanguage();
    String getType();
    int getYear();
    int getPrice();
    double getDiscountPrice(int ss);
}
