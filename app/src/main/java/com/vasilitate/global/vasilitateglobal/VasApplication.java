package com.vasilitate.global.vasilitateglobal;

import android.app.Application;
import android.widget.Toast;

import com.vasilitate.vapp.sdk.Vapp;
import com.vasilitate.vapp.sdk.VappProduct;

import java.util.ArrayList;

/**
 * This app reads Vapp products from a JSON file named vapp_products, and creates a list of products that can be clicked to order that product using Vapp.
 * vapp_products is stored in the assets file and holds the color as a hexidecimal as well as the product id, cost and maximum number of orders.
 */

public class VasApplication extends Application {

    private static final String VAPP_SDK_KEY = "C1EE9CB28A54C87C2194";
    private static final boolean TEST_MODE = false;       // Test Mode
    private static final boolean CANCELLABLE_PRODUCTS = true; // Cancellable Products?


    @Override
    public void onCreate() {
        super.onCreate();
        ArrayList<VappProduct> vappProducts = JsonUtils.getVappProducts(getApplicationContext());

        if(TEST_MODE)
            Toast.makeText(getApplicationContext(), "This app is in test mode", Toast.LENGTH_SHORT).show();

        try {
            // initialise VAPP! with the products
            Vapp.initialise(getApplicationContext(),
                    vappProducts,
                    null, //No subscriptions here.
                    TEST_MODE,
                    CANCELLABLE_PRODUCTS,
                    VAPP_SDK_KEY);

        } catch( Exception e ) {
            Toast.makeText( this, "Vapp Exception: " + e.getMessage(), Toast.LENGTH_LONG ).show();
        }

    }
}
