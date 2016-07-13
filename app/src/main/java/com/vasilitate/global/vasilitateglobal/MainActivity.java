package com.vasilitate.global.vasilitateglobal;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.vasilitate.vapp.sdk.Vapp;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView buttonList;
    List<Product> data;
    private ButtonListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonList = (ListView) findViewById(R.id.main_list_buttons);
        data = JsonUtils.getJSONProducts(getApplicationContext());
        adapter = new ButtonListAdapter(getApplicationContext(), data);
        buttonList.setAdapter(adapter);

        buttonList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final Product product = data.get(i);
                String confirmMessage = "VAPP! will now send " + product.getRequiredSmsCount() + " SMS texts to complete the purchase." +
                        " Please confirm you wish to proceed.";

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Confirm Payment")
                        .setMessage(confirmMessage)
                        .setNegativeButton(android.R.string.cancel, null)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Initialise payment for product.
                                Vapp.showVappPaymentScreen(MainActivity.this, product, false);
                            }
                        }).show();
            }

        });
    }



}