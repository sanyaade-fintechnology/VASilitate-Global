package com.vasilitate.global.vasilitateglobal;

import com.vasilitate.vapp.sdk.VappProduct;

/**
 * Created by jamesfoot on 12/07/2016.
 */
public class Product {

    private String name;
    private String color; //this should now be hexidecimal
    private int countSms;
    private int maxRepeatCount;
    public static final int UNLIMTED_REPEATS = -1;  // currently using -1 if unlimited.

    public Product(String name, String color, int smsCount, int maxRepeatCount){
        //super(name, smsCount, maxRepeatCount);
        this.name = name;
        this.color = color;
        this.countSms = smsCount;
        this.maxRepeatCount = maxRepeatCount;
    }

    public VappProduct toVappProduct(){
        return new VappProduct(name, countSms, maxRepeatCount);
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
        return countSms;
    }

    public void setSmsCount(int smsCount) {
        this.countSms = smsCount;
    }

    public int getMaxRepeatCount() {
        return maxRepeatCount;
    }

    public void setMaxRepeatCount(int maxRepeatCount) {
        this.maxRepeatCount = maxRepeatCount;
    }

}