package com.rakshasindhu.trackingsystem.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.rakshasindhu.trackingsystem.R;

public class SettingFragment extends Fragment {
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        listView = view.findViewById(R.id.listView);
        ArrayAdapter<String> ad = new ArrayAdapter<>(getContext(),
                R.layout.listview, getResources().getStringArray(R.array.setting));
        listView.setAdapter(ad);

        return view;
    }
}
