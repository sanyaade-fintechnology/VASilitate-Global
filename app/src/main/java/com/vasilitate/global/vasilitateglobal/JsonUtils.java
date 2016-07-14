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

    private static final String JSON_FILENAME = "vapp_products";

    /*
     * Returns the string of JSON data saved under vapp_products in the assets directory.
     */
    private static String getJSONStringFromFile(Context context){
        String jsonString = "";

        try {
            InputStream is = context.getAssets().open(JSON_FILENAME);
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

    /**
     * Parses the JSON data saved to vapp_products and returns a list of Products.
     */
    public static List<Product> getJSONProducts(Context context){
        Gson gson = new Gson();
        String jsonData = getJSONStringFromFile(context);
        if(jsonData.length() == 0 ) {
            return new ArrayList<Product>();
        } else {
            Product[] productsArray = gson.fromJson(jsonData, Product[].class);
            return Arrays.asList(productsArray);
        }
    }

    /**
     * parses the JSON data saved to vapp_products and returns a list of VappProducts.
    */
    public static ArrayList<VappProduct> getVappProducts(Context context){
        List<Product> products = getJSONProducts(context);
        ArrayList<VappProduct> vappProducts = new ArrayList<>();

        for(Product p: products){
            vappProducts.add(p);
        }

        return vappProducts;
    }



}
