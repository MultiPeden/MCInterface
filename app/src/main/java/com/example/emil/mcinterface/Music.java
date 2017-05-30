package com.example.emil.mcinterface;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Emil on 30/05/2017.
 */

public class Music extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.music, container, false);

        String[] contactItems = {"Justin Bieber - Baby", "Johnny Cash - Walk The Line", "Britney Spears - Toxic"};

        ListView listView = (ListView) rootView.findViewById(R.id.musiclist);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                contactItems
        );

        listView.setAdapter(listViewAdapter);

        return rootView;
    }
}
