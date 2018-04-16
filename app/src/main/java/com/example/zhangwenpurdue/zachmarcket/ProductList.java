package com.example.zhangwenpurdue.zachmarcket;

import java.util.ArrayList;

/**
 * Created by zhangwenpurdue on 6/25/2017.
 */

public class ProductList extends ArrayList<Product> {
    private static ProductList ourInstance = null;

    public synchronized static ProductList getInstance() {

        if (ourInstance == null) {
            synchronized (CategoryList.class) {
                if (ourInstance == null) {
                    ourInstance = new ProductList();
                }
            }
        }
        return ourInstance;
    }

    private ProductList() {
    }
}
