package com.example.emil.mcinterface;

/**
 * Created by Emil on 30/05/2017.
 */

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


public class Contacts extends Fragment {


    public ListView listView;
    public  MClistAdapter adapter;
    AlertDialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.contacts, container, false);

        String[] contactItems = {"Felix", "Hektor", "Hugo", "Jens", "Niels", "Poul", "Dennis", "Troels", "Kurt", "Tristan", "Torsten", "Jussi", "HP", "Ludvig", "Anders"};

        listView = (ListView) rootView.findViewById(R.id.contactList);
        adapter = new MClistAdapter(getActivity(), contactItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long rowId) {


                onSelcetion( (int)rowId );

            }
        });
        Log.v("Contacts", "Number of rows: " + listView.getAdapter().getCount());

       return rootView;
    }




    public  boolean setMarked(int pos){
        if (pos < adapter.getCount() && pos >= 0 &&  adapter.setMarked(pos)  ) {
            return true;
        }
            return false;
    }

    public void onSelcetion(int rowId ){
        if(dialog != null && dialog.isShowing()){
            dialog.dismiss();
        }else {

            Log.v("TAG", "CLICKED row number: " + rowId);
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setCancelable(true);
            builder.setTitle("Incoming Call");
            builder.setPositiveButton("Accept", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.setNegativeButton("Reject", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.create();
            this.dialog = builder.show();
        }

    }

}
