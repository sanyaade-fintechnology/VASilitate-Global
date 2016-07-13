package com.vasilitate.global.vasilitateglobal;

import android.content.Context;

import com.google.gson.Gson;
import com.vasilitate.vapp.sdk.VappProduct;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class JsonUtils {


    private static String readJSONFromFile(Context context){
        String jsonString = "";

        try {
            InputStream is = context.getAssets().open("vapp_products");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return jsonString;
    }

    public static List<Product> getJSONProducts(Context context){
        Gson gson = new Gson();
        Product[] productsArray = gson.fromJson(readJSONFromFile(context), Product[].class);
        return Arrays.asList(productsArray);
    }



    public static ArrayList<VappProduct> getVappProducts(Context context){
        List<Product> products = getJSONProducts(context);
        ArrayList<VappProduct> vappProducts = new ArrayList<>();

        for(Product p: products){
            vappProducts.add(p);
        }

        return vappProducts;
    }



}
