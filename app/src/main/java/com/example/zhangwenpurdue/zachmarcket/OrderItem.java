package com.example.zhangwenpurdue.zachmarcket;

/**
 * Created by zhangwenpurdue on 6/25/2017.
 */

public class OrderItem {
    private String order_category;
    private String order_name;
    private int order_quantity;
    private int total_order;
    private String order_deliver_add;
    private String order_date;
    private String user_phone;
    private String order_price;
    private String order_thumb;

    public OrderItem() {
    }

    public OrderItem(String order_category, String order_name, int order_quantity, String order_price, String order_deliver_add, String order_date, String user_phone, String order_thumb) {
        this.order_category = order_category;
        this.order_name = order_name;
        this.order_quantity = order_quantity;
        this.order_deliver_add = order_deliver_add;
        this.order_date = order_date;
        this.user_phone = user_phone;
        this.order_price = order_price;
        this.order_thumb = order_thumb;
    }

    public String getOrder_thumb() {
        return order_thumb;
    }

    public void setOrder_thumb(String order_thumb) {
        this.order_thumb = order_thumb;
    }

    public String getOrder_category() {
        return order_category;
    }

    public void setOrder_category(String order_category) {
        this.order_category = order_category;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public int getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(int order_quantity) {
        this.order_quantity = order_quantity;
    }

    public int getTotal_order() {
        return total_order;
    }

    public void setTotal_order(int total_order) {
        this.total_order = getOrder_quantity() * Integer.parseInt(getOrder_price());
    }

    public String getOrder_deliver_add() {
        return order_deliver_add;
    }

    public void setOrder_deliver_add(String order_deliver_add) {
        this.order_deliver_add = order_deliver_add;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getOrder_price() {
        return order_price;
    }

    public void setOrder_price(String order_price) {
        this.order_price = order_price;
    }
}


