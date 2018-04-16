package com.example.zhangwenpurdue.zachmarcket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
public class CheckOut extends AppCompatActivity {
    Frag_Checkout_View_Orders frag_checkout_view_orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        frag_checkout_view_orders = new Frag_Checkout_View_Orders();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_check_out, frag_checkout_view_orders).commit();

    }
}
