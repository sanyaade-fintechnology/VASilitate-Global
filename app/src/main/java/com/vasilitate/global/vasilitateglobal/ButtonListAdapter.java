package com.vasilitate.global.vasilitateglobal;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jamesfoot on 12/07/2016.
 */
public class ButtonListAdapter extends ArrayAdapter<Product> {

    private ArrayList<Product> data;

    public ButtonListAdapter(Context context, ArrayList<Product> cd){
        super(context, 0, cd);
        this.data = cd;
    }

    public class ViewHolder {
        LinearLayout background;
        TextView textView;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Product product = getItem(position);

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item_button, parent, false);

            viewHolder.textView = (TextView) convertView.findViewById(R.id.list_item_txt);
            viewHolder.background = (LinearLayout) convertView.findViewById(R.id.list_item_bkg);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(product.getName());
        try {
            viewHolder.background.setBackgroundColor(Color.parseColor(product.getColor()));
        } catch (Exception e){
            Log.e("BLA", e.toString());
        }

        return convertView;
    }

}

