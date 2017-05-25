package com.example.daomy.fitnesstutorial3.molde;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by daomy on 5/10/2017.
 */

public class ChuongTrinh  implements Parcelable{
    private int MaCT;
    private String TenCT;
    private int NgayCT;
    private String DesCT;
    private int Id;
    private int Time;
    private int SET;
    private int REP;
    private byte[] image;
    private String TenBT;

    public ChuongTrinh(int maCT, String tenCT, int ngayCT, String desCT, int id, int time, int SET, int REP,byte[] img,String BT) {
        MaCT = maCT;
        TenCT = tenCT;
        NgayCT = ngayCT;
        DesCT = desCT;
        Id = id;
        Time = time;
        this.SET = SET;
        this.REP = REP;
        image = img;
        TenBT = BT;

    }

    protected ChuongTrinh(Parcel in) {
        MaCT = in.readInt();
        TenCT = in.readString();
        NgayCT = in.readInt();
        DesCT = in.readString();
        Id = in.readInt();
        Time = in.readInt();
        SET = in.readInt();
        REP = in.readInt();
        image = in.createByteArray();
        TenBT = in.readString();
    }

    public static final Creator<ChuongTrinh> CREATOR = new Creator<ChuongTrinh>() {
        @Override
        public ChuongTrinh createFromParcel(Parcel in) {
            return new ChuongTrinh(in);
        }

        @Override
        public ChuongTrinh[] newArray(int size) {
            return new ChuongTrinh[size];
        }
    };

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getTenBT() {
        return TenBT;
    }

    public void setTenBT(String tenBT) {
        TenBT = tenBT;
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

    public int getTime() {
        return Time;
    }

    public void setTime(int time) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(MaCT);
        dest.writeString(TenCT);
        dest.writeInt(NgayCT);
        dest.writeString(DesCT);
        dest.writeInt(Id);
        dest.writeInt(Time);
        dest.writeInt(SET);
        dest.writeInt(REP);
        dest.writeByteArray(image);
        dest.writeString(TenBT);
    }
}
