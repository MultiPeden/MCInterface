package com.example.emil.mcinterface;

/**
 * Created by Emil on 30/05/2017.
 */

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class Contacts extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.contacts, container, false);

        String[] contactItems = {"Felix", "Hektor", "Hugo", "Jens", "Niels", "Poul", "Dennis", "Troels", "Kurt", "Tristan", "Torsten", "Jussi", "HP", "Ludvig", "Anders"};

        ListView listView = (ListView) rootView.findViewById(R.id.contactList);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                contactItems
        );

        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            //AlertDialog.Builder adb = new AlertDialog.Builder(
            //        getContext());


            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long rowId) {

                // TODO Auto-generated method stub
                Log.v("TAG", "CLICKED row number: " + rowId);

                AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                builder.setCancelable(true);
                builder.setTitle("Incoming Call");
                builder.setPositiveButton("Accept",new DialogInterface.OnClickListener()
                {

                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Reject",new DialogInterface.OnClickListener()
                {

                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                    }
                });
                AlertDialog alert=builder.create();
                alert.show();
            }


        });

        return rootView;
    }
}
