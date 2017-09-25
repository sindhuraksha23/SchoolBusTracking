package com.rakshasindhu.trackingsystem.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.rakshasindhu.trackingsystem.R;


public class HomeFragment extends android.support.v4.app.Fragment {

    ViewGroup viewGroup;
    LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4, linearLayout5;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

        linearLayout1 = viewGroup.findViewById(R.id.ll1);
        linearLayout2 =  viewGroup.findViewById(R.id.ll2);
        linearLayout3 =  viewGroup.findViewById(R.id.ll3);
        linearLayout4 =   viewGroup.findViewById(R.id.ll4);
        linearLayout5 =   viewGroup.findViewById(R.id.ll5);


        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new BusLocationFragment()).addToBackStack(null).commit();
            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new StudentsFragment()).addToBackStack(null).commit();
            }
        });

        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new NotificationFragment()).addToBackStack(null).commit();
            }
        });

        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new SettingFragment()).addToBackStack(null).commit();
            }
        });

        linearLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new HelpFragment()).addToBackStack(null).commit();
            }
        });
        return viewGroup;
    }

}
