package com.example.zhangwenpurdue.zachmarcket;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import static com.example.zhangwenpurdue.zachmarcket.Frag_Sign_Up.KEY_PASSWORD;
import static com.example.zhangwenpurdue.zachmarcket.Frag_Sign_Up.KEY_PHONE;

/**
 * Created by zhangwenpurdue on 6/16/2017.
 */

public class Frag_Reset_Password extends Fragment{
    static StringBuilder url = new StringBuilder("http://rjtmobile.com/aamir/grocery/MobileApp/grocery_reset_pass.php?");
    public static final String KEY_NEW_PASSWORD = "&newpassword=";
    EditText reset_phone;
    EditText old_password;
    EditText new_password;
    Button btn_reset;
    Frag_Sign_In sign_in;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.reset_password_layout, container, false);
        reset_phone = (EditText) view.findViewById(R.id.resetPhone);
        old_password = (EditText) view.findViewById(R.id.resetOldPw);
        new_password = (EditText) view.findViewById(R.id.resetNewPw);
        btn_reset = (Button) view.findViewById(R.id.reset);
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });
        return view;
    }
    private void resetPassword() {
        final String user_phone = reset_phone.getText().toString().trim();
        final String user_old_password = old_password.getText().toString().trim();
        final String user_new_password = new_password.getText().toString().trim();
        url = new StringBuilder("http://rjtmobile.com/aamir/grocery/MobileApp/grocery_reset_pass.php?");


        url.append(KEY_PHONE + user_phone);
        url.append(KEY_PASSWORD + user_old_password);
        url.append(KEY_NEW_PASSWORD + user_new_password);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.contains("password reset successfully")) {
                    Toast.makeText(getActivity(),"Success",Toast.LENGTH_LONG).show();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction transaction = fm.beginTransaction();
                    sign_in = new Frag_Sign_In();
                    transaction.replace(R.id.replace, sign_in);
                    transaction.addToBackStack(null);
                    transaction.commit();
                } else {
                    Toast.makeText(getActivity(),"Faild",Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(),"Error",Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);


    }
}
