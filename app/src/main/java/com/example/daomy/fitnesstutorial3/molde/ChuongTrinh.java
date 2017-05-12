package com.example.daomy.fitnesstutorial3.molde;

/**
 * Created by daomy on 5/10/2017.
 */

public class ChuongTrinh {
    private int MaCT;
    private String TenCT;
    private byte[] ImageCT;
    private int NgayCT;
    private String DesCT;
    private int Id;
    private String Time;
    private int SET;
    private int REP;

    public ChuongTrinh(int maCT, String tenCT, byte[] imageCT, int ngayCT, String desCT, int id, String time, int SET, int REP) {
        MaCT = maCT;
        TenCT = tenCT;
        ImageCT = imageCT;
        NgayCT = ngayCT;
        DesCT = desCT;
        Id = id;
        Time = time;
        this.SET = SET;
        this.REP = REP;
    }

    public int getMaCT() {
        return MaCT;
    }

    public void setMaCT(int maCT) {
        MaCT = maCT;
    }

    public String getTenCT() {
        return TenCT;
    }

    public void setTenCT(String tenCT) {
        TenCT = tenCT;
    }

    public byte[] getImageCT() {
        return ImageCT;
    }

    public void setImageCT(byte[] imageCT) {
        ImageCT = imageCT;
    }

    public int getNgayCT() {
        return NgayCT;
    }

    public void setNgayCT(int ngayCT) {
        NgayCT = ngayCT;
    }

    public String getDesCT() {
        return DesCT;
    }

    public void setDesCT(String desCT) {
        DesCT = desCT;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public int getSET() {
        return SET;
    }

    public void setSET(int SET) {
        this.SET = SET;
    }

    public int getREP() {
        return REP;
    }

    public void setREP(int REP) {
        this.REP = REP;
    }
}
