package com.example.zhangwenpurdue.zachmarcket;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by zhangwenpurdue on 6/25/2017.
 */

public class Frag_Checkout_Track_Delivery extends Fragment {
    private static final String KEY = "extra";
    public static Frag_Checkout_Track_Delivery newInstance(String extra) {
        Bundle args = new Bundle();
        args.putString(KEY, extra);
        Frag_Checkout_Track_Delivery fragment = new Frag_Checkout_Track_Delivery();
        fragment.setArguments(args);
        return fragment;
    }
}
