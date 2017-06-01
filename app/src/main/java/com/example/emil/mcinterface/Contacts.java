package com.example.emil.mcinterface;

/**
 * Created by Emil on 30/05/2017.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Contacts extends Fragment {

    public static int rowInd = 0;
    public ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.contacts, container, false);

        String[] contactItems = {"Felix", "Hektor", "Hugo", "Jens", "Niels", "Poul", "Dennis", "Troels", "Kurt", "Tristan", "Torsten", "Jussi", "HP", "Ludvig", "Anders"};

         listView = (ListView) rootView.findViewById(R.id.contactList);
        MClistAdapter adapter = new MClistAdapter(getActivity(), contactItems);
        listView.setAdapter(adapter);


/*
        MClistAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                contactItems
        );

        listView.setAdapter(listViewAdapter);
*/

        // highlight row

//        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

  //      listView.setSelector(android.R.color.darker_gray);

        //listView.setSelection(0);

        Context context = getActivity();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


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

//        listView.setItemChecked(1,true);

        Log.v("Contacts", "Number of rows: " + listView.getAdapter().getCount());
   //     listView = FindViewById<ListView>(Resource.Id.listView1);
     //   listView.Adapter = new HomeScreenAdapter(this, tableItems);


        listView.setSelection(1);
        listView.setItemChecked(1,true);
        adapter.notifyDataSetChanged();
    //    (AppCompatTextView) listView.getAdapter().getView(0,null,null).setTe
     //   listViewAdapter.notifyDataSetChanged();

        return rootView;
    }

/*    @Override
    public void onResume() {
        super.onResume();
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setItemChecked(0, true);
        listView.setSelection(0);
        listView.deferNotifyDataSetChanged();
        if(listView.getChildAt(0)!=null) {
            listView.getChildAt(0).setBackgroundColor(getResources().getColor(R.color.colorAccent));


        }
    }*/
}
