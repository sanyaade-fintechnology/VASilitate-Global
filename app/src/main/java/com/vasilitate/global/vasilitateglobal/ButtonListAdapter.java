package com.vasilitate.global.vasilitateglobal;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Displays the Vapp products in a clickable listview.
 */
public class ButtonListAdapter extends ArrayAdapter<Product> {


    public ButtonListAdapter(Context context, List<Product> cd){
        super(context, 0, cd);

    }

    public class ViewHolder {
        RelativeLayout background;
        TextView idText, smsText;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Product product = getItem(position);

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item_button, parent, false);

            viewHolder.idText = (TextView) convertView.findViewById(R.id.list_item_id);
            viewHolder.smsText = (TextView) convertView.findViewById(R.id.list_item_sms);
            viewHolder.background = (RelativeLayout) convertView.findViewById(R.id.list_item_bkg);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.idText.setText(product.getProductId());
        viewHolder.smsText.setText(product.getRequiredSmsCount() + "");
        try {
            viewHolder.background.setBackgroundColor(Color.parseColor(product.getColor()));
        } catch (Exception e){
            Log.e("BLA", e.toString());
        }

        return convertView;
    }

}

