package com.example.omar.teacherapp;

/**
 * Created by omar on 4/30/2017.
 */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SessionInfoFragment extends android.app.Fragment {
    private String name;
    private String countryCode;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        name = getArguments().getString("name");
        countryCode = getArguments().getString("code");
        return inflater.inflate(R.layout.session_info, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        getActivity().setContentView(R.layout.activity_main);

        TextView textView = (TextView) getActivity().findViewById(R.id.code);
        textView.setText(countryCode + " " + name);
    }
}