package com.example.omar.teacherapp;

/**
 * Created by omar on 4/30/2017.
 */

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class AttendanceFragment extends android.app.Fragment {

    private Spinner spinner2;
    private Button btnSubmit;

    public void addListenerOnButton() {
        Log.d("addListenerOnButton", " in");
        spinner2 = (Spinner) getActivity().findViewById(R.id.spinner2);
        btnSubmit = (Button) getActivity().findViewById(R.id.btnSubmit);

        Log.d("addListenerOnButton", " after get");
        btnSubmit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(),
                        "OnClickListener : " +
                                "\nSpinner 2 : "+ String.valueOf(spinner2.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
            }

        });
    }

    public void addItemsOnSpinner2() {

        spinner2 = (Spinner) getActivity().findViewById(R.id.spinner2);
        List<String> list = new ArrayList<String>();
        list.add("session 1");
        list.add("session 2");
        list.add("session 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        getActivity().setContentView(R.layout.activity_main);

        addItemsOnSpinner2();
        addListenerOnButton();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        addItemsOnSpinner2();
//        addListenerOnButton();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.attendance_view, container, false);
    }
}