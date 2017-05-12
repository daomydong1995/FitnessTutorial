package com.example.daomy.fitnesstutorial3.molde;

import java.util.Objects;

/**
 * Created by daomy on 5/6/2017.
 */

public class BaiTap {
    private int id;
    private String type;
    private String ten;
    private String tagE;
    private String tagN;
    private String tagH;
    private byte[] image;
    private String huongdan;

    public BaiTap(int id, String type, String ten, String tagE, String tagN, String tagH, byte[] image, String huongdan) {
        this.id = id;
        this.type = type;
        this.ten = ten;
        this.tagE = tagE;
        this.tagN = tagN;
        this.tagH = tagH;
        this.image = image;
        this.huongdan = huongdan;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTagE() {
        return tagE;
    }

    public void setTagE(String tagE) {
        this.tagE = tagE;
    }

    public String getTagN() {
        return tagN;
    }

    public void setTagN(String tagN) {
        this.tagN = tagN;
    }

    public String getTagH() {
        return tagH;
    }

    public void setTagH(String tagH) {
        this.tagH = tagH;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getHuongdan() {
        return huongdan;
    }

    public void setHuongdan(String huongdan) {
        this.huongdan = huongdan;
    }
}
