package com.theoptimumlabs.carmanagment;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by optimum2 on 19/7/19.
 */

public class MangmentAdapter extends BaseAdapter {
    Context context;
    List<String> rowItems;

    public MangmentAdapter(Context context, List<String> items) {
        this.context = context;
        this.rowItems = items;
    }

    /*private view holder class*/
    private class ViewHolder {

        TextView txtMangamentName;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.mangment_list_item, null);
            holder = new ViewHolder();
           holder. txtMangamentName=(TextView)convertView.findViewById(R.id.txtMangamentName);


            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder. txtMangamentName.setText(rowItems.get(position));

        return convertView;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }
}