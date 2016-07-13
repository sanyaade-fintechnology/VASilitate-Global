package com.vasilitate.global.vasilitateglobal;

import android.app.Application;
import android.widget.Toast;

import com.vasilitate.vapp.sdk.Vapp;
import com.vasilitate.vapp.sdk.VappProduct;

import java.util.ArrayList;

/**
 * Created by jamesfoot on 12/07/2016.
 */
public class VasApplication extends Application {

    private static final String VAPP_SDK_KEY = "C1EE9CB28A54C87C2194";
    private static final boolean TEST_MODE = false;       // Test Mode
    private static final boolean CANCELLABLE_PRODUCTS = true; // Cancellable Products?


    @Override
    public void onCreate() {
        super.onCreate();
        ArrayList<VappProduct> vappProducts = JsonUtils.getVappProducts(getApplicationContext());

        //TODO: not sure what subscriptions should be.
        ArrayList<VappProduct> subsriptions = new ArrayList<>();

        if(TEST_MODE)
            Toast.makeText(getApplicationContext(), "This app is in test mode", Toast.LENGTH_SHORT).show();

        try {
            // initialise VAPP! with the products
            Vapp.initialise(getApplicationContext(),
                    vappProducts,
                    subsriptions, //Don't need this on the vapp example app. Maybe related to updated sdk?
                    TEST_MODE,
                    CANCELLABLE_PRODUCTS,
                    VAPP_SDK_KEY);

        } catch( Exception e ) {
            //Log.e("VasApplication", e.getMessage());
            Toast.makeText( this, "Vapp Exception: " + e.getMessage(), Toast.LENGTH_LONG ).show();
        }

    }
}
