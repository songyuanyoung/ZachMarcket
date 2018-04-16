package com.example.zhangwenpurdue.zachmarcket;

import java.util.ArrayList;

/**
 * Created by zhangwenpurdue on 6/25/2017.
 */

public class SubCategoryList extends ArrayList<SubCategory> {
    private static SubCategoryList ourInstance = null;

    public synchronized static SubCategoryList getInstance() {

        if (ourInstance == null) {
            synchronized (CategoryList.class) {
                if (ourInstance == null) {
                    ourInstance = new SubCategoryList();
                }
            }
        }
        return ourInstance;
    }

    private SubCategoryList() {
    }
}
