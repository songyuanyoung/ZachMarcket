package com.example.zhangwenpurdue.zachmarcket;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by zhangwenpurdue on 6/25/2017.
 */

public class Frag_Checkout_Add_address extends Fragment {
    EditText addr_phone, addr_password, addr_newAddress;
    Button update_addr;
    RequestQueue mQueue;
    StringRequest stringRequest;
    private static final String KEY = "extra";
    String payAmount = "0";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle!= null) {
            payAmount = bundle.getString(KEY);
        }
        Toast.makeText(getActivity(), payAmount, Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.update_add_address_layout, container, false);
        addr_phone = (EditText) view.findViewById(R.id.address_username);
        addr_password = (EditText) view.findViewById(R.id.address_password);
        addr_newAddress = (EditText) view.findViewById(R.id.new_address);
        update_addr = (Button) view.findViewById(R.id.add_address);

        update_addr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder userphone = new StringBuilder("&user_phone=");
                StringBuilder password = new StringBuilder("&user_password=");
                StringBuilder newAddress = new StringBuilder("&user_add=");

                StringBuilder url = new StringBuilder("http://rjtmobile.com/ansari/fos/fosapp/fos_update_address.php?");

                userphone.append( addr_phone.getText().toString().trim());
                password.append( addr_password.getText().toString().trim());
                url.append(userphone.toString());
                url.append(password.toString());
                mQueue = Volley.newRequestQueue(getActivity());
                stringRequest = new StringRequest(url.toString(),
                        new Response.Listener<String>() {

                            @Override
                            public void onResponse(String response) {
                                // if(response.trim().contains("Your Delivery Address updated")){
                                if(true){
                                    //openProfile();
                                   // Intent intent = new Intent(getActivity(), PayPalActivity.class);
                                   // intent.putExtra("PayAmount", payAmount.toString());

                                  //  getActivity().startActivity(intent);
                                    //  Frag_Checkout_Payment frag_checkout_payment = Frag_Checkout_Payment.newInstance("Zach");
                                    //    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.activity_check_out,frag_checkout_payment).commit();
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






    public static Frag_Checkout_Add_address newInstance(String extra) {
        Bundle args = new Bundle();
        args.putString(KEY, extra);
        Frag_Checkout_Add_address fragment = new Frag_Checkout_Add_address();
        fragment.setArguments(args);
        return fragment;
    }
}
