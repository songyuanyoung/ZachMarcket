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
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by zhangwenpurdue on 6/16/2017.
 */

public class Frag_Sign_Up  extends Fragment implements View.OnClickListener{
    StringBuilder url = new StringBuilder("http://rjtmobile.com/aamir/grocery/MobileApp/grocery_reg.php?");

    public static final String KEY_USERNAME = "&user_name=";
    public static final String KEY_EMAIL = "&user_email=";
    public static final String KEY_PHONE = "&user_phone=";
    public static final String KEY_PASSWORD = "&user_password=";
    public static final String KEY_ADD = "&user_add=";

    TextView tv_login;
    Frag_Sign_In sign_in;

    EditText signup_name;
    EditText signup_email;
    EditText signup_phone;
    EditText signup_password;

    Button btn_register;

//yes
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sign_up_layout, container, false);
        tv_login = (TextView) view.findViewById(R.id.signupLogin);
        tv_login.setOnClickListener(this);

        signup_name = (EditText) view.findViewById(R.id.signupName);
        signup_email = (EditText) view.findViewById(R.id.signupEmail);
        signup_phone = (EditText) view.findViewById(R.id.signupPhone);
        signup_password = (EditText) view.findViewById(R.id.signupPassword);

        btn_register = (Button) view.findViewById(R.id.register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getActivity(),"clicl",Toast.LENGTH_SHORT).show();
               RegisterUsers();
            }
        });
        //ok,
        //I have some problem with the register page, when I used the URl, it just crashed.
        //





        return view;
    }
    private void RegisterUsers() {
        final String user_name = signup_name.getText().toString().trim();
        final String user_email = signup_email.getText().toString().trim();
        final String user_phone = signup_phone.getText().toString().trim();
        final String user_password = signup_password.getText().toString().trim();
        url = new StringBuilder("http://rjtmobile.com/aamir/grocery/MobileApp/grocery_reg.php?");
        url.append(KEY_USERNAME + user_name);
        url.append(KEY_EMAIL + user_email);
        url.append(KEY_PHONE + user_phone);
        url.append(KEY_PASSWORD + user_password);
        url.append(KEY_ADD + "ads");
        Toast.makeText(getActivity(),url.toString(),Toast.LENGTH_LONG).show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getActivity(),response,Toast.LENGTH_LONG).show();
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

    @Override
    public void onClick(View v) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        switch (v.getId())
        {
            case R.id.signupLogin:
                if (sign_in == null)
                {
                    sign_in = new Frag_Sign_In();
                }
                transaction.replace(R.id.replace, sign_in);
                break;
        }
        transaction.addToBackStack(null);
        transaction.commit();

    }
}

