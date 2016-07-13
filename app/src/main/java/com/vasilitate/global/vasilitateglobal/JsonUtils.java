package com.vasilitate.global.vasilitateglobal;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.vasilitate.vapp.sdk.VappProduct;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by jamesfoot on 12/07/2016.
 */
public class JsonUtils {


    private static String readJSONFromFile(Context context){
        String jsonString = "";

        try {
            InputStream is = context.getAssets().open("colors_json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        //Log.e("JU", jsonString);
        return jsonString;
    }



    public static ArrayList<Product> getColorDataList(Context context){
        Gson gson = new Gson();
        Product[] colorArray = gson.fromJson(readJSONFromFile(context), Product[].class);

        ArrayList<Product> data = new ArrayList<>();
        for(int i=0; i<colorArray.length; i++){
            data.add(colorArray[i]);
        }

        return data;
    }

    public static ArrayList<VappProduct> getVappProducts(Context context){
        ArrayList<Product> products = getColorDataList(context);
        ArrayList<VappProduct> vappProducts = new ArrayList<>();

        for(Product p: products){
            vappProducts.add(p.toVappProduct());
        }

        return vappProducts;
    }



}
