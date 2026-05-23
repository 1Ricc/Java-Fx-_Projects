package model.classifica;

public class ClassificaEntry {
    private String username;
    private int total;

    public ClassificaEntry(String u, int t){
        this.username = u;
        this.total = t;
    }

    public String getUsername(){
        return this.username;
    }
    public int getTotal(){
        return this.total;
    }

    public String toString(){
        return this.username+": "+this.total;
    }
}
