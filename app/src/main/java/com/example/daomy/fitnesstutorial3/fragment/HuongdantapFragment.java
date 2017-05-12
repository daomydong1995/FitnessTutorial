package com.example.daomy.fitnesstutorial3.fragment;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.daomy.fitnesstutorial3.R;
import com.example.daomy.fitnesstutorial3.molde.BaiTap;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by daomy on 5/9/2017.
 */

public class HuongdantapFragment extends Fragment {
    static ArrayList<BaiTap> list = null ;
    static int poin = 0;

    TextView textHuongdan;
    GifImageView imgHuongdan;
    Button tagh,tagn,tage;

    static public HuongdantapFragment newInstance(ArrayList<BaiTap> list1 , int p){
        list = list1;
        poin = p;
        return new HuongdantapFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.huongdantap_fragment,container,false);
        imgHuongdan = (GifImageView) view.findViewById(R.id.imgHuongdan);
        tagh = (Button) view.findViewById(R.id.tagh);
        tagn = (Button) view.findViewById(R.id.tagn);
        tage = (Button) view.findViewById(R.id.tage);
        textHuongdan = (TextView) view.findViewById(R.id.txtInfo) ;
        textHuongdan.setText(list.get(poin).getHuongdan());

        tagh.setBackground(view.getResources().getDrawable(R.color.tagH));
        tagn.setBackground(view.getResources().getDrawable(R.color.tagN));
        tage.setBackground(view.getResources().getDrawable(R.color.tagE));

        tagh.setText(list.get(poin).getTagH());
        tagn.setText(list.get(poin).getTagN());
        tage.setText(list.get(poin).getTagE());
        Glide.with(view.getContext())
                .load(list.get(poin).getImage())
                .fitCenter()
                .error(R.drawable.imagenotfound)
                .into(imgHuongdan);
        return view;

    }
}
