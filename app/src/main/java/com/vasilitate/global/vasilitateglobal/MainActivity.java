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

/**
 * Displays a list of sample Vapp Products, the user can click on any product and be taken to a Vapp Payment screen.
 */
public class MainActivity extends AppCompatActivity {

    private ListView buttonList;
    List<Product> data;
    private ButtonListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set the listview up with the products.
        buttonList = (ListView) findViewById(R.id.main_list_buttons);
        data = JsonUtils.getJSONProducts(getApplicationContext());
        adapter = new ButtonListAdapter(getApplicationContext(), data);
        buttonList.setAdapter(adapter);

        buttonList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final Product product = data.get(i);
                String confirmMessage = getString(R.string.confirm_text_1) + " " + product.getRequiredSmsCount() + " " + getString(R.string.confirm_text_2);

                // builds an alert to ensure the user knows the costs.
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Confirm Payment")
                        .setMessage(confirmMessage)
                        .setNegativeButton(android.R.string.cancel, null)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Initialise payment for product.
                                Vapp.showVappPaymentScreen(MainActivity.this, product, false, 0);
                            }
                        }).show();
            }

        });
    }



}