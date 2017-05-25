package com.example.daomy.fitnesstutorial3.molde;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

/**
 * Created by daomy on 5/6/2017.
 */

public class BaiTap implements Parcelable{
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


    protected BaiTap(Parcel in) {
        id = in.readInt();
        type = in.readString();
        ten = in.readString();
        tagE = in.readString();
        tagN = in.readString();
        tagH = in.readString();
        image = in.createByteArray();
        huongdan = in.readString();
    }

    public static final Creator<BaiTap> CREATOR = new Creator<BaiTap>() {
        @Override
        public BaiTap createFromParcel(Parcel in) {
            return new BaiTap(in);
        }

        @Override
        public BaiTap[] newArray(int size) {
            return new BaiTap[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(type);
        dest.writeString(ten);
        dest.writeString(tagE);
        dest.writeString(tagN);
        dest.writeString(tagH);
        dest.writeByteArray(image);
        dest.writeString(huongdan);
    }
}
