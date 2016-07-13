package com.vasilitate.global.vasilitateglobal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView buttonList;


    ArrayList<Product> data;
    private ButtonListAdapter adapter;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonList = (ListView) findViewById(R.id.main_list_buttons);
        gson = new Gson();
        data = JsonUtils.getColorDataList(getApplicationContext());

        adapter = new ButtonListAdapter(getApplicationContext(), data);
        buttonList.setAdapter(adapter);

        buttonList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //TODO: will interact with the SDK here.
                Product product = data.get(i);
                Toast.makeText(getApplicationContext(), data.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}