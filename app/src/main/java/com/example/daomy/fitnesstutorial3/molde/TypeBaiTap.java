package com.example.daomy.fitnesstutorial3.molde;

/**
 * Created by daomy on 5/9/2017.
 */

public class TypeBaiTap {
    private String Kieu;
    private String tagh;
    private byte[] image;

    public TypeBaiTap(String kieu, String t,byte[] image) {
        Kieu = kieu;
        tagh =t ;
        this.image = image;
    }

    public String getKieu() {
        return Kieu;
    }

    public void setKieu(String kieu) {
        Kieu = kieu;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getTagh() {
        return tagh;
    }

    public void setTagh(String tagh) {
        this.tagh = tagh;
    }
}
