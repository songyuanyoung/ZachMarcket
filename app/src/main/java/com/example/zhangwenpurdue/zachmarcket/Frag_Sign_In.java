package com.example.zhangwenpurdue.zachmarcket;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by zhangwenpurdue on 6/16/2017.
 */

public class Frag_Sign_In extends Fragment implements View.OnClickListener {
    TextView tv_signup;
    TextView tv_resetps;
    EditText et_loginPassword;
    EditText et_loginPhone;
    Button btn_signIn;
    RequestQueue mQueue;
    StringRequest stringRequest;


    Frag_Sign_Up sign_up;
    Frag_Reset_Password reset_password;

    StringBuilder url =new StringBuilder( "http://rjtmobile.com/aamir/grocery/MobileApp/grocery_login.php?");



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sign_in_layout, container, false);
        tv_resetps = (TextView) view.findViewById(R.id.loginReset);
        tv_signup = (TextView) view.findViewById(R.id.loginSignup);

        et_loginPhone = (EditText) view.findViewById(R.id.loginPhone);
        et_loginPassword = (EditText) view.findViewById(R.id.loginPassword);
        btn_signIn = (Button) view.findViewById(R.id.loginBtn);

        et_loginPhone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Toast.makeText(getActivity(), "Phone number is not correct", Toast.LENGTH_SHORT);
                    String phone = et_loginPhone.getText().toString().trim();
                    if (phone.length() != 10) {
                        Toast.makeText(getActivity(), "Phone number is not correct", Toast.LENGTH_SHORT);
                        btn_signIn.setEnabled(false);
                    }
                    if (btn_signIn.isEnabled() == false) {
                        btn_signIn.setEnabled(true);
                    }

                }


            }
        });


        tv_resetps.setOnClickListener(this);
        tv_signup.setOnClickListener(this);
        btn_signIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                StringBuilder phone = new StringBuilder("&user_phone=");
                StringBuilder password = new StringBuilder("&user_password=");
                url = new StringBuilder("http://rjtmobile.com/aamir/grocery/MobileApp/grocery_login.php?");

                phone.append( et_loginPhone.getText().toString().trim());
                password.append( et_loginPassword.getText().toString().trim());
                url.append(phone.toString());
                url.append(password.toString());
                mQueue = Volley.newRequestQueue(getActivity());
                stringRequest = new StringRequest(url.toString(),
                        new Response.Listener<String>() {

                            @Override
                            public void onResponse(String response) {
                                if(response.trim().contains("success")){
                                    //openProfile();
                                    Intent intent = new Intent(getActivity(), Grocery.class);
                                    //Toast.makeText(getActivity(),url,Toast.LENGTH_LONG).show();
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(getActivity(),"Fail to login",Toast.LENGTH_LONG).show();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();
                            }
                        });

                mQueue.add(stringRequest);
            }
        });









        return view;
    }


    @Override
    public void onClick(View v) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        switch (v.getId())
        {
            case R.id.loginSignup:
                if (sign_up == null)
                {
                    sign_up = new Frag_Sign_Up();
                }
                transaction.replace(R.id.replace, sign_up);
                break;
            case R.id.loginReset:
                if (reset_password == null)
                {
                    reset_password = new Frag_Reset_Password();
                }
                transaction.replace(R.id.replace, reset_password);
                break;
        }
        transaction.addToBackStack(null);
        transaction.commit();


    }
}
