package com.example.emil.mcinterface;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by Emil on 30/05/2017.
 */

public class Navigation extends Fragment {

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.navigation, container, false);

        String[] contactItems = {"Home", "Work", "Summer Cottage", "Parents"};

        ListView listView = (ListView) rootView.findViewById(R.id.locationList);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                contactItems
        );

        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long rowId) {

                // TODO Auto-generated method stub
                Log.v("TAG", "CLICKED row number: " + rowId);

                final View view1 = inflater.inflate(R.layout.navigator, null);

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(getContext()).
                                setPositiveButton("Afslut", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                }).
                                setView(view1);
                 builder.create().show();

            }

        });

        return rootView;
    }
}

