package com.example.daomy.fitnesstutorial3.fragment;


import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.util.TimeUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.daomy.fitnesstutorial3.R;
import com.example.daomy.fitnesstutorial3.molde.BaiTap;
import com.example.daomy.fitnesstutorial3.molde.ChuongTrinh;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import pl.droidsonroids.gif.GifImageView;


/**
 * Created by daomy on 5/23/2017.
 */

public class ChuongTrinhBaiTapChiTietFragment extends Fragment {
    Button btn1, btn2, btn3, Tagh, Tagn, Tage;
    GifImageView imageHD;
    TextView txtHD, txtTen;
    CountDownTimer demnguoc;
    long time;
    boolean run = false, pau = false;
    int Id;
    ArrayList<ChuongTrinh> listCT = null;
    int poi;

    //    private String tagh = null;
//
    static public ChuongTrinhBaiTapChiTietFragment newInstance(ArrayList<ChuongTrinh> list1, int poi) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("listCT", list1);
        bundle.putInt("poi", poi);
        ChuongTrinhBaiTapChiTietFragment fragment = new ChuongTrinhBaiTapChiTietFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.chuongtrinhbaitapchitiet_fragment, container, false);
        listCT = getArguments().getParcelableArrayList("listCT");
        poi = getArguments().getInt("poi");
        btn1 = (Button) view.findViewById(R.id.btn1);
        btn2 = (Button) view.findViewById(R.id.btn2);
        btn3 = (Button) view.findViewById(R.id.btn3);
        Tagh = (Button) view.findViewById(R.id.tagh);
        Tagn = (Button) view.findViewById(R.id.tagn);
        Tage = (Button) view.findViewById(R.id.tage);
        txtTen = (TextView) view.findViewById(R.id.txtTen);
        imageHD = (GifImageView) view.findViewById(R.id.imgHuongdan);
        txtHD = (TextView) view.findViewById(R.id.txtInfo);
        Id = listCT.get(poi).getId();
        btn1.setText(listCT.get(poi).getTime() + " Phút");

        time = listCT.get(poi).getTime() * 1000 * 60;

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (run) {
                    demnguoc.onFinish();
                    demnguoc.cancel();
                    run = false;
                } else {
                    Log.d("Timer","Start "+time);
                    demnguoc = new CountDownTimer(time, 1000) {
                        long a;

                        @Override
                        public void onTick(long millisUntilFinished) {
                            long m = millisUntilFinished;
                            long gio = TimeUnit.MILLISECONDS.toHours(m);
                            long phut = TimeUnit.MILLISECONDS.toMinutes(m)
                                    - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(m));
                            long giay = TimeUnit.MILLISECONDS.toSeconds(m) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(m));
                            a = m;
                            String giophutgiay = String.format("%02d:%02d:%02d", gio, phut, giay);
                            btn1.setText(giophutgiay);
                        }

                        @Override
                        public void onFinish() {
                            time = a;
                        }
                    };
                    demnguoc.start();
                    run = true;
                }
            }
        });
        btn1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                btn1.setText(listCT.get(poi).getTime() + " Phút");
                demnguoc.onFinish();
                demnguoc.cancel();

                time = listCT.get(poi).getTime() * 1000 * 60;
                Log.d("Timer","Start 0 "+time);
                run = false;
                return true;
            }
        });


        Cursor cursor = MainFragment.sqLiteHelper.getData("SELECT * FROM BAITAP WHERE Id = '" + Id + "'");
        while (cursor.moveToNext()) {
            String ten = cursor.getString(2);
            String tage = cursor.getString(3);
            String tagn = cursor.getString(4);
            String tagh = cursor.getString(5);
            String info = cursor.getString(6);
            byte[] imagebit = cursor.getBlob(7);
            Glide.with(getContext())
                    .load(imagebit)
                    .error(R.drawable.imagenotfound)
                    .into(imageHD);
            Tagh.setText(tagh);
            Tagn.setText(tagn);
            Tage.setText(tage);
            btn2.setText("Hiệp = " + listCT.get(poi).getSET());
            btn3.setText("Lần = " + listCT.get(poi).getREP());
            txtHD.setText(info);
            txtTen.setText(ten);
        }
        return view;
    }

}
