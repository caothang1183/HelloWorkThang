package com.example.currencyexchangerate.model;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Currency implements Serializable {
    private String type;
    private String imageurl;
    private Bitmap bitmap;
    private String buycash;
    private String buycredit;
    private String sellcash;
    private String sellcredit;

    public Currency(String type, String imageurl, Bitmap bitmap, String buycash, String buycredit, String sellcash, String sellcredit) {
        this.type = type;
        this.imageurl = imageurl;
        this.bitmap = bitmap;
        this.buycash = buycash;
        this.buycredit = buycredit;
        this.sellcash = sellcash;
        this.sellcredit = sellcredit;
    }

    public Currency() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getBuycash() {
        return buycash;
    }

    public void setBuycash(String buycash) {
        this.buycash = buycash;
    }

    public String getBuycredit() {
        return buycredit;
    }

    public void setBuycredit(String buycredit) {
        this.buycredit = buycredit;
    }

    public String getSellcash() {
        return sellcash;
    }

    public void setSellcash(String sellcash) {
        this.sellcash = sellcash;
    }

    public String getSellcredit() {
        return sellcredit;
    }

    public void setSellcredit(String sellcredit) {
        this.sellcredit = sellcredit;
    }
}
