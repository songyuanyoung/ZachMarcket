package com.example.zhangwenpurdue.zachmarcket;

/**
 * Created by zhangwenpurdue on 6/25/2017.
 */
public class SubCategory {
    private String GrocerySubCategoryId;
    private String GroceryCategoryId    ;
    private String GrocerySubCategoryName;
    private String GroceryThumb;

    public SubCategory() {
    }

    public String getGrocerySubCategoryId() {
        return GrocerySubCategoryId;
    }

    public void setGrocerySubCategoryId(String grocerySubCategoryId) {
        GrocerySubCategoryId = grocerySubCategoryId;
    }

    public String getGroceryCategoryId() {
        return GroceryCategoryId;
    }

    public void setGroceryCategoryId(String groceryCategoryId) {
        GroceryCategoryId = groceryCategoryId;
    }

    public String getGrocerySubCategoryName() {
        return GrocerySubCategoryName;
    }

    public void setGrocerySubCategoryName(String grocerySubCategoryName) {
        GrocerySubCategoryName = grocerySubCategoryName;
    }

    public String getGroceryThumb() {
        return GroceryThumb;
    }

    public void setGroceryThumb(String groceryThumb) {
        GroceryThumb = groceryThumb;
    }
}

