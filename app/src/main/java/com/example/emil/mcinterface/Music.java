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
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Emil on 30/05/2017.
 */

public class Music extends Fragment{

    public static int rowInd = 0;
    public ListView listView;
    public static MClistAdapter adapter;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.contacts, container, false);

        String[] contactItems = {"My playlist", "Driving Playlist", "Relax"};

        listView = (ListView) rootView.findViewById(R.id.contactList);
        adapter = new MClistAdapter(getActivity(), contactItems);
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long rowId) {
                adapter.setMarked(position);
                // TODO Auto-generated method stub
                Log.v("TAG", "CLICKED row number: " + rowId);

                final View view1 = inflater.inflate(R.layout.music_player, null);

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(getContext()).
                                setPositiveButton("Close", new DialogInterface.OnClickListener() {
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

    public static void updateMarked(){

        if (rowInd < adapter.getCount()){
            adapter.setMarked(rowInd);
        }
    }
}
