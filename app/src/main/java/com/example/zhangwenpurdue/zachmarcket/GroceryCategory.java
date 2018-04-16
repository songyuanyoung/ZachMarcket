package com.example.zhangwenpurdue.zachmarcket;

/**
 * Created by zhangwenpurdue on 6/22/2017.
 */

public class GroceryCategory {
    private String ID;
    private String Name;
    private String Thumb;
    public GroceryCategory(){}

    public GroceryCategory(String ID, String name, String thumb) {
        this.ID = ID;
        Name = name;
        Thumb = thumb;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getThumb() {
        return Thumb;
    }

    public void setThumb(String thumb) {
        Thumb = thumb;
    }
}
