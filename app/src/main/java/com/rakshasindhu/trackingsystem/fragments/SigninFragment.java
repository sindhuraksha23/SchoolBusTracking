package com.rakshasindhu.trackingsystem.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import com.rakshasindhu.trackingsystem.HomeActivity;
import com.rakshasindhu.trackingsystem.R;

public class SigninFragment extends Fragment {

    ViewGroup viewGroup;
    FragmentManager fragmentManager;
    String phone, password;
    Button toHome;
    StringBuilder stringBuilder;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int testNum = 0;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_signin, container, false);

        fragmentManager = getFragmentManager();
        toHome = viewGroup.findViewById(R.id.toHome);
        stringBuilder = new StringBuilder("http://rjtmobile.com/aamir/school-mgt/school_bus_driver_app/driver_login.php?&driver_password=");
        sharedPreferences = getContext().getSharedPreferences("BusSharedPreference", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verified()) {
                    tryLogin();
                } else {
                    Toast.makeText(getActivity(), "Please fill all the information", Toast.LENGTH_LONG).show();
                }
            }
        });

        setTestNum(100);
        return viewGroup;
    }

    public boolean verified() {

        phone = ((EditText) viewGroup.findViewById(R.id.login_phone)).getText().toString().trim();
        password = ((EditText) viewGroup.findViewById(R.id.login_password)).getText().toString().trim();

        if (phone == null || phone.length() == 0 || password == null || password.length() == 0) {
            return false;
        } else {
            stringBuilder.append(password + "&driver_mobile=" + phone);
            return true;
        }
    }

    public int tryLogin() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, stringBuilder.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.contains("success")) {
                    jumpToHome();
                } else {
                    Toast.makeText(getActivity(), "Phone and password not match", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
        return 1;
    }

    public int jumpToHome() {
        Intent i = new Intent(getActivity(),HomeActivity.class);
        editor.putString("Phone", phone);
        editor.commit();
        Toast.makeText(getActivity(), "Welcome to School Bus Tracking!", Toast.LENGTH_LONG).show();
        startActivity(i);
        return 1;
    }

    public void setTestNum(int i) {
        this.testNum = i;
    }

    public int getTestNum() {
        return testNum;
    }
}
