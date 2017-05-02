package com.example.omar.teacherapp;

/**
 * Created by omar on 4/30/2017.
 */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import android.app.Fragment;
import android.app.FragmentManager;

public class SessionFragment extends android.app.Fragment {
    private String name;
    private String countryCode;
    private Button btnStart;
    private Button btnEnd;
    private Button btnPause;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        name = getArguments().getString("name");
        countryCode = getArguments().getString("code");
        return inflater.inflate(R.layout.session_view, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        getActivity().setContentView(R.layout.activity_main);

        TextView textView = (TextView) getActivity().findViewById(R.id.session_textView);
        textView.setText(countryCode + " " + name);
        addListenerOnButton();
    }

    public void addListenerOnButton() {
//        Log.d("addListenerOnButton", " in");
        btnStart = (Button) getActivity().findViewById(R.id.btnStart);
        btnPause = (Button) getActivity().findViewById(R.id.btnPause);
        btnEnd = (Button) getActivity().findViewById(R.id.btnEnd);

        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(),
                        "OnClickListener : " +
                                "\nStart Session ",
                        Toast.LENGTH_SHORT).show();
            }

        });
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                RemoteViews remoteViews = new RemoteViews(getActivity().getPackageName(), R.layout.session_view);
//                remoteViews.setTextViewText(R.id.btnPause, "Set button text here");
                String s = String.valueOf(btnPause.getText());
                if(s.equalsIgnoreCase("Pause Session")){
                    btnPause.setText("Resume Session");

                    Toast.makeText(getActivity(),
                            "OnClickListener : " +
                                    "\nPause Session ",
                            Toast.LENGTH_SHORT).show();
                }else{
                    btnPause.setText("Pause Session");

                    Toast.makeText(getActivity(),
                            "OnClickListener : " +
                                    "\nResume Session ",
                            Toast.LENGTH_SHORT).show();
                }

            }

        });
        btnEnd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(),
                        "OnClickListener : " +
                                "\nEnd Session ",
                        Toast.LENGTH_SHORT).show();

                Fragment fragment = new AttendanceFragment();
                FragmentManager fragmentManager = getActivity().getFragmentManager(); // For AppCompat use getSupportFragmentManager
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .commit();
                fragmentManager.beginTransaction()
                        .replace(R.id.student_list_fragment, new Fragment())
                        .commit();

            }

        });
    }

}