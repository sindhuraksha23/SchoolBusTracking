package com.rakshasindhu.trackingsystem.fragments;

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
import com.rakshasindhu.trackingsystem.R;

public class SignupFragment extends Fragment {

    ViewGroup viewGroup;
    String name, password, mobile, fatherName, driverLicense, address, gender;
    FragmentManager fragmentManager;
    Button toLogin;
    StringBuilder stringBuilder;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_signup, container, false);

        stringBuilder = new StringBuilder("http://rjtmobile.com/aamir/school-mgt/school_bus_driver_app/driver_reg.php?&driver_name=");
        fragmentManager = getFragmentManager();
        toLogin = (Button) viewGroup.findViewById(R.id.toLogin);

        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verified()) {
                    register();
                } else {
                    Toast.makeText(getActivity(), "Please fill all the information", Toast.LENGTH_LONG).show();
                }
            }
        });

        return viewGroup;
    }

    private boolean verified() {

        name = ((EditText) viewGroup.findViewById(R.id.name)).getText().toString().trim();
        password = ((EditText) viewGroup.findViewById(R.id.password)).getText().toString().trim();
        mobile = ((EditText) viewGroup.findViewById(R.id.mobile)).getText().toString().trim();
        fatherName = ((EditText) viewGroup.findViewById(R.id.father_name)).getText().toString().trim();
        driverLicense = ((EditText) viewGroup.findViewById(R.id.driver_license)).getText().toString().trim();
        address = ((EditText) viewGroup.findViewById(R.id.address)).getText().toString().trim();
        gender = ((EditText) viewGroup.findViewById(R.id.gender)).getText().toString().trim();

        if (name == null || password == null || mobile == null || fatherName == null ||
                driverLicense == null || address == null || gender == null || name.length() == 0 ||
                password.length() == 0 || mobile.length() == 0 || fatherName.length() == 0 ||
                driverLicense.length() == 0 || address.length() == 0 || gender.length() == 0) {
            return false;
        } else {
            stringBuilder.append(name + "&driver_password=" + password + "&driver_mobile=" + mobile +
                    "&driver_father_name=" + fatherName + "&driver_dl=" + driverLicense + "&driver_address=" +
                    address + "&driver_gender=" + gender + "&driver_photo=url");
            return true;
        }
    }

    private void register() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, stringBuilder.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.contains("success")) {
                    jumpToLogin();
                    Toast.makeText(getActivity(), "Register Succeed!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), "This mobile already registered", Toast.LENGTH_LONG).show();
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
    }

    public void jumpToLogin() {

        SigninFragment signinFragment = new SigninFragment();
        fragmentManager.beginTransaction().replace(R.id.login_container, signinFragment).addToBackStack(null).commit();
    }
}
