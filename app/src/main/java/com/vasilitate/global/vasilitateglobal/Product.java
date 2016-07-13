package com.vasilitate.global.vasilitateglobal;

import com.vasilitate.vapp.sdk.VappProduct;

/**
 * Created by jamesfoot on 12/07/2016.
 *
 * This contains the product details. Including color. Use the toVappProduct to use with Vapp SDK
 * (Using inheretance messed with gson).
 *
 */
public class Product {

    private String name;
    private String color; //this should now be hexidecimal
    private int smsCount;
    private int maxRepeatCount;
    public static final int UNLIMTED_REPEATS = -1;  // currently using -1 if unlimited.

    public Product(String name, String color, int smsCount, int maxRepeatCount){
        //super(name, smsCount, maxRepeatCount);
        this.name = name;
        this.color = color;
        this.smsCount = smsCount;
        this.maxRepeatCount = maxRepeatCount;
    }

    public VappProduct toVappProduct(){
        return new VappProduct(name, smsCount, maxRepeatCount);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(int smsCount) {
        this.smsCount = smsCount;
    }

    public int getMaxRepeatCount() {
        return maxRepeatCount;
    }

    public void setMaxRepeatCount(int maxRepeatCount) {
        this.maxRepeatCount = maxRepeatCount;
    }

}