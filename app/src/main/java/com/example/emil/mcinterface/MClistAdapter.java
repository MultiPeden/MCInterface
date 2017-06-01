package com.example.emil.mcinterface;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ptr_m on 01/06/2017.
 */

public class MClistAdapter extends BaseAdapter {

    private String[] strings;
    private LayoutInflater inflater;

    public MClistAdapter(Activity activity, String[] strings) {
        this.strings = strings;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

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
        TextView text = (TextView) vi.findViewById(R.id.row_text); //votes
        text.setText(strings[position]);
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



}
