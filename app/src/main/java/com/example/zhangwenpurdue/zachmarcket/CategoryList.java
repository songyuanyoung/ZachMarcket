package com.example.zhangwenpurdue.zachmarcket;

import java.util.ArrayList;

/**
 * Created by zhangwenpurdue on 6/25/2017.
 */

public class CategoryList extends ArrayList<Category> {
    private static CategoryList ourInstance = null;

    public synchronized static CategoryList getInstance() {

        if (ourInstance == null) {
            synchronized (CategoryList.class) {
                if (ourInstance == null) {
                    ourInstance = new CategoryList();
                }
            }
        }
        return ourInstance;
    }

    private CategoryList() {
    }
}

