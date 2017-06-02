package com.example.emil.mcinterface;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by ptr_m on 01/06/2017.
 */

public class MClistAdapter extends BaseAdapter {

    private String[] strings;
    private LayoutInflater inflater;
    private int marked;

    public MClistAdapter(Activity activity, String[] strings) {
        this.strings = strings;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        marked =0;
    }

    @Override
    public int getCount() {
        return strings.length;
    }

    @Override
    public Object getItem(int position) {
        return strings[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        vi = inflater.inflate(R.layout.list_item,null);

        RelativeLayout cont =(RelativeLayout) vi.findViewById(R.id.row);
        TextView text = (TextView) vi.findViewById(R.id.row_text); //votes
        text.setText(strings[position]);
        if(position == marked) {
            cont.setBackgroundColor(Color.parseColor("#000000"));
            text.setTextColor(Color.parseColor("#ffffff"));
        }
        return vi;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void setList(String[] strings) {
        this.strings = strings;
        this.notifyDataSetChanged();
    }



    public boolean setMarked(int position){
        if(position < getCount()){
            marked = position;
            this.notifyDataSetChanged();
            return true;
        }
        return false;
    }


}