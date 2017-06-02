package com.example.emil.mcinterface;

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


/**
 * Created by Emil on 30/05/2017.
 */

public class Music extends Fragment{

    public ListView listView;
    public  MClistAdapter adapter;
    private LayoutInflater inflater;
    ViewGroup mContainer;
    AlertDialog dialog;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContainer = container;
        View rootView = inflater.inflate(R.layout.contacts, container, false);

        String[] contactItems = {"My playlist", "Driving Playlist", "Relax"};

        listView = (ListView) rootView.findViewById(R.id.contactList);
        adapter = new MClistAdapter(getActivity(), contactItems);
        listView.setAdapter(adapter);
        this.inflater=inflater;



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long rowId) {
                onSelcetion((int) rowId);

            }

        });



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

            final View view1 = inflater.inflate(R.layout.music_player, null);


            AlertDialog.Builder builder =
                    new AlertDialog.Builder(getContext()).
                            setPositiveButton("Close", new DialogInterface.OnClickListener() {
                                public DialogInterface dialog;

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    this.dialog = dialog;
                                    dialog.dismiss();
                                }
                            }).
                            setView(view1);

            builder.create();
            this.dialog = builder.show();
        }

    }

}
