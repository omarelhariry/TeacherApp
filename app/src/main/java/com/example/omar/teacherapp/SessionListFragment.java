package com.example.omar.teacherapp;

/**
 * Created by omar on 4/30/2017.
 */

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SessionListFragment extends android.app.Fragment {
    private MyCustomAdapter dataAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.session_list_view, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        getActivity().setContentView(R.layout.activity_main);

        displayListView();
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
//            CheckBox name;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater)getActivity().getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.session_info, null);

                holder = new ViewHolder();
                holder.code = (TextView) convertView.findViewById(R.id.code);
//                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
                convertView.setTag(holder);

//                holder.code.setOnClickListener( new View.OnClickListener() {
//                    public void onClick(View v) {

//                        CheckBox cb = (CheckBox) v ;
//                        Country country = (Country) cb.getTag();
//                        Toast.makeText(getActivity().getApplicationContext(),
//                                "Clicked on Checkbox: " + cb.getText() +
//                                        " is " + cb.isChecked(),
//                                Toast.LENGTH_LONG).show();
//                        country.setSelected(cb.isChecked());
//                    }
//                });
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            Country country = countryList.get(position);
            holder.code.setText(country.getName()+" (" +  country.getCode() + ")");
//            holder.name.setText(country.getName());
//            holder.name.setChecked(country.isSelected());
//            holder.name.setTag(country);

            return convertView;

        }

    }

    private void displayListView() {

        //Array list of countries
        final ArrayList<Country> countryList = new ArrayList<Country>();
        Country country = new Country("c6.203 | Security","Sun 2nd",true);
        countryList.add(country);
        country = new Country("c6.104 | IoT","Wed 3rd",true);
        countryList.add(country);
//
//        final ArrayList<String> sessionList = new ArrayList<String>();
//        sessionList.add("hiiiiiiiiiii");
//        sessionList.add("hiiiiiiiiiii");
//        ListAdapter dataAdapter2 = new ArrayAdapter(getActivity(), R.layout.country_info, sessionList) {
//            @Override
//            public boolean areAllItemsEnabled() {
//                return false;
//            }
//
//            @Override
//            public boolean isEnabled(int position) {
//                return false;
//            }
//
//            @Override
//            public void registerDataSetObserver(DataSetObserver observer) {
//
//            }
//
//            @Override
//            public void unregisterDataSetObserver(DataSetObserver observer) {
//
//            }
//
//            @Override
//            public int getCount() {
//                return 0;
//            }
//
//            @Override
//            public Object getItem(int position) {
//                return null;
//            }
//
//            @Override
//            public long getItemId(int position) {
//                return 0;
//            }
//
//            @Override
//            public boolean hasStableIds() {
//                return false;
//            }
////            private ArrayList<String> sessionList;
////
////            @Override
////            public ListAdapter(String s){
////                super();
////                sessionList = s;
////            }
//
//            class ViewHolder2 {
//                TextView code;
//                CheckBox name;
//            }
//
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                ViewHolder2 holder = null;
//                Log.v("ConvertView", String.valueOf(position));
//                Log.d("ConvertView", String.valueOf(position));
//
//                if (convertView == null) {
//                    LayoutInflater vi = (LayoutInflater)getActivity().getSystemService(
//                            Context.LAYOUT_INFLATER_SERVICE);
//                    convertView = vi.inflate(R.layout.country_info, null);
//
//                    holder = new ViewHolder2();
//                    holder.code = (TextView) convertView.findViewById(R.id.code);
//                    holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
//                    convertView.setTag(holder);
//
//                    holder.name.setOnClickListener( new View.OnClickListener() {
//                        public void onClick(View v) {
//                            CheckBox cb = (CheckBox) v ;
//                            Country country = (Country) cb.getTag();
//                            Toast.makeText(getActivity().getApplicationContext(),
//                                    "Clicked on Checkbox: " + cb.getText() +
//                                            " is " + cb.isChecked(),
//                                    Toast.LENGTH_LONG).show();
//                            country.setSelected(cb.isChecked());
//                        }
//                    });
//                }
//                else {
//                    holder = (ViewHolder2) convertView.getTag();
//                }
//
//                String session = sessionList.get(position);
//                holder.code.setText(" (" +  session + ")");
//                holder.name.setText(session);
//                holder.name.setChecked(true);
//                holder.name.setTag(session);
//
//                return convertView;
//
//        }
//
//            @Override
//            public int getItemViewType(int position) {
//                return 0;
//            }
//
//            @Override
//            public int getViewTypeCount() {
//                return 1;
//            }
//
//            @Override
//            public boolean isEmpty() {
//                return false;
//            }
//        };

//        dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.country_info, sessionList);


        dataAdapter = new MyCustomAdapter(getActivity(),
                R.layout.session_info, countryList);
        ListView listView = (ListView) getActivity().findViewById(R.id.session_listView);
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Country country = (Country) parent.getItemAtPosition(position);
                Toast.makeText(getActivity().getApplicationContext(),
                        "Clicked on Row: " + country.getName(),
                        Toast.LENGTH_LONG).show();

                Bundle bundle=new Bundle();
                bundle.putString("name", country.getName());
                bundle.putString("code", country.getCode());
                Fragment fragment = new SessionInfoFragment();
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getFragmentManager(); // For AppCompat use getSupportFragmentManager
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .commit();
                fragment = new SessionFragment();
                fragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .replace(R.id.student_list_fragment, fragment)
                        .commit();
            }
        });

    }

}