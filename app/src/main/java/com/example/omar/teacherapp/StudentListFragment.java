package com.example.omar.teacherapp;

/**
 * Created by omar on 4/30/2017.
 */

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentListFragment extends android.app.Fragment {


    MyCustomAdapter dataAdapter = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.student_list_view, container, false);
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//
//        //Generate list View from ArrayList
//        displayListView();
//
//        checkButtonClick();
//
//    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        getActivity().setContentView(R.layout.activity_main);

        displayListView();
        checkButtonClick();
    }

    private void displayListView() {

        //Array list of countries
        ArrayList<Country> countryList = new ArrayList<Country>();
//        Country country = new Country("AFG","Afghanistan",false);
//        countryList.add(country);
//        country = new Country("ALB","Albania",true);
//        countryList.add(country);
//        country = new Country("DZA","Algeria",false);
//        countryList.add(country);
//        country = new Country("ASM","American Samoa",true);
//        countryList.add(country);
//        country = new Country("AND","Andorra",true);
//        countryList.add(country);
//        country = new Country("AGO","Angola",false);
//        countryList.add(country);
//        country = new Country("AIA","Anguilla",false);
//        countryList.add(country);
        Country country = new Country("28-2604","Hariry",true);
        countryList.add(country);
        country = new Country("28-6069","Renad",true);
        countryList.add(country);
        country = new Country("28-1463","Dola",true);
        countryList.add(country);
        country = new Country("ID1","Bad boy 1",false);
        countryList.add(country);
        country = new Country("ID2","Bad boy 2",false);
        countryList.add(country);
        country = new Country("ID3","Bad boy 3",false);
        countryList.add(country);

        //create an ArrayAdaptar from the String Array
        dataAdapter = new MyCustomAdapter(getActivity(),
                R.layout.country_info, countryList);
        ListView listView = (ListView) getActivity().findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Country country = (Country) parent.getItemAtPosition(position);
                Toast.makeText(getActivity().getApplicationContext(),
                        "Clicked on Row: " + country.getName(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    private class MyCustomAdapter extends ArrayAdapter<Country> {

        private ArrayList<Country> countryList;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<Country> countryList) {
            super(context, textViewResourceId, countryList);
            this.countryList = new ArrayList<Country>();
            this.countryList.addAll(countryList);
        }

        private class ViewHolder {
            TextView code;
            CheckBox name;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater)getActivity().getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.country_info, null);

                holder = new ViewHolder();
                holder.code = (TextView) convertView.findViewById(R.id.code);
                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
                convertView.setTag(holder);

                holder.name.setOnClickListener( new View.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v ;
                        Country country = (Country) cb.getTag();
                        Toast.makeText(getActivity().getApplicationContext(),
                                "Clicked on Checkbox: " + cb.getText() +
                                        " is " + cb.isChecked(),
                                Toast.LENGTH_LONG).show();
                        country.setSelected(cb.isChecked());
                    }
                });
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            Country country = countryList.get(position);
            holder.code.setText(" (" +  country.getCode() + ")");
            holder.name.setText(country.getName());
            holder.name.setChecked(country.isSelected());
            holder.name.setTag(country);

            return convertView;

        }

    }

    private void checkButtonClick() {


        Button myButton = (Button) getActivity().findViewById(R.id.findSelected);
        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                StringBuffer responseText = new StringBuffer();
                responseText.append("The following were selected...\n");

                ArrayList<Country> countryList = dataAdapter.countryList;
                for(int i=0;i<countryList.size();i++){
                    Country country = countryList.get(i);
                    if(country.isSelected()){
                        responseText.append("\n" + country.getName());
                    }
                }

                responseText.append("\n\nWhile the following were NOT selected...\n");

                for(int i=0;i<countryList.size();i++){
                    Country country = countryList.get(i);
                    if(!country.isSelected()){
                        responseText.append("\n" + country.getName());
                    }
                }

                Toast.makeText(getActivity().getApplicationContext(),
                        responseText, Toast.LENGTH_LONG).show();

            }
        });

    }

}