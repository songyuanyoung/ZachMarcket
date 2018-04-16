package com.example.zhangwenpurdue.zachmarcket;

/**
 * Created by zhangwenpurdue on 6/25/2017.
 */

public class Product {
    private String GroceryCategoryId;
    private String GrocerySubCategoryId;
    private String ItemId;
    private String ItemName;
    private String ItemPrice;
    private String ItemThumb;
    private String GrocerySubCategory;

    public String getGrocerySubCategory() {
        return GrocerySubCategory;
    }

    public void setGrocerySubCategory(String grocerySubCategory) {
        GrocerySubCategory = grocerySubCategory;
    }

    public Product() {
    }

    public String getGroceryCategoryId() {
        return GroceryCategoryId;
    }

    public void setGroceryCategoryId(String groceryCategoryId) {
        GroceryCategoryId = groceryCategoryId;
    }

    public String getGrocerySubCategoryId() {
        return GrocerySubCategoryId;
    }

    public void setGrocerySubCategoryId(String grocerySubCategoryId) {
        GrocerySubCategoryId = grocerySubCategoryId;
    }

    public String getItemId() {
        return ItemId;
    }

    public void setItemId(String itemId) {
        ItemId = itemId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(String itemPrice) {
        ItemPrice = itemPrice;
    }

    public String getItemThumb() {
        return ItemThumb;
    }

    public void setItemThumb(String itemThumb) {
        ItemThumb = itemThumb;
    }
}

