package com.example.zhangwenpurdue.zachmarcket;

import java.util.ArrayList;

/**
 * Created by zhangwenpurdue on 6/25/2017.
 */

public class OrderList extends ArrayList<OrderItem> {
    private static OrderList ourInstance = null;

    public synchronized static OrderList getInstance() {

        if (ourInstance == null) {
            synchronized (OrderList.class) {
                if (ourInstance == null) {
                    ourInstance = new OrderList();
                }
            }
        }
        return ourInstance;
    }

    private OrderList() {
    }
}


