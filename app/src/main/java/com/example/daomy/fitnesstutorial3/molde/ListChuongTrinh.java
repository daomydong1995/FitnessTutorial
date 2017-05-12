package com.example.daomy.fitnesstutorial3.molde;

/**
 * Created by daomy on 5/11/2017.
 */

public class ListChuongTrinh {
    private String TenCT;
    private String DesCT;
    private byte[] imageCT;

    public ListChuongTrinh(String tenCT, String desCT, byte[] imageCT) {
        TenCT = tenCT;
        DesCT = desCT;
        this.imageCT = imageCT;
    }

    public String getTenCT() {
        return TenCT;
    }

    public void setTenCT(String tenCT) {
        TenCT = tenCT;
    }

    public String getDesCT() {
        return DesCT;
    }

    public void setDesCT(String desCT) {
        DesCT = desCT;
    }

    public byte[] getImageCT() {
        return imageCT;
    }

    public void setImageCT(byte[] imageCT) {
        this.imageCT = imageCT;
    }
}
