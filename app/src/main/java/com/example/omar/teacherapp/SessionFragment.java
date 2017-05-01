package com.example.omar.teacherapp;

/**
 * Created by omar on 4/30/2017.
 */

import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SessionFragment extends android.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.session_view, container, false);
    }
}