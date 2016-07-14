package com.vasilitate.global.vasilitateglobal;

import com.vasilitate.vapp.sdk.VappProduct;

/**
 * Extends VappProduct in order to store the color data.
 *
 */
public class Product extends VappProduct {

    private String color; //Contains the color of the button in a Hexadecimal string.
    public static final int UNLIMITED_REPEATS = -1;  // currently using -1 if unlimited.

    public Product(String id, String color, int smsCount, int maxRepeatCount){
        super(id, smsCount, maxRepeatCount);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}