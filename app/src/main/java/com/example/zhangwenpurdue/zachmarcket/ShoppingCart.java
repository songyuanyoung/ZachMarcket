package com.example.zhangwenpurdue.zachmarcket;

import java.util.ArrayList;

/**
 * Created by zhangwenpurdue on 6/25/2017.
 */
public class ShoppingCart {
    private ArrayList<OrderItem> cartItems = new ArrayList<OrderItem>();
    public OrderItem getProducts(int position){
        return cartItems.get(position);
    }
    public void setProducts(OrderItem Products){
        cartItems.add(Products);
    }
    public int getCartsize(){
        return cartItems.size();
    }
    public boolean CheckProductInCart(OrderItem aproduct){
        return cartItems.contains(aproduct);
    }
}