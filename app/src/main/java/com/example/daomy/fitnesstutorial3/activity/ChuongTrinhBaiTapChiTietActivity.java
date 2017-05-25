package com.example.daomy.fitnesstutorial3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.daomy.fitnesstutorial3.R;
import com.example.daomy.fitnesstutorial3.adapter.ViewPagerAdapter;
import com.example.daomy.fitnesstutorial3.fragment.BaitapFragment;
import com.example.daomy.fitnesstutorial3.fragment.ChuongTrinhBaiTapChiTietFragment;
import com.example.daomy.fitnesstutorial3.fragment.NgaychuongtrinhFragment;
import com.example.daomy.fitnesstutorial3.molde.ChuongTrinh;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Objects;

/**
 * Created by daomy on 5/23/2017.
 */

public class ChuongTrinhBaiTapChiTietActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    ViewPager viewPager;
    static ChuongTrinh chuongTrinh = null;
    static ArrayList<ChuongTrinh> listCT = null;
    int poi,lengthList ;
    public static Class<ChuongTrinhBaiTapChiTietActivity> newInstance(ArrayList<ChuongTrinh> list) {
        listCT = list;
        return ChuongTrinhBaiTapChiTietActivity.class;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        lengthList = intent.getIntExtra("length",0);
        poi = intent.getIntExtra("poi",0);

//        listCT =  (ArrayList<ChuongTrinh>)getIntent().getSerializableExtra("lisctCT");
//        chuongTrinh = listCT.get(poi);

//        listCT =   intent.getParcelableArrayListExtra("listCT");
        Log.d("logCT",lengthList+"");
//        ChuongTrinh chuongTrinh = listCT.get(position);
//        Log.d("logCT",listCT.getDesCT()+"  "+chuongTrinh.getREP());
        setContentView(R.layout.activity_chuong_trinh_bai_tap_chi_tiet);
        tabLayout = (TabLayout) findViewById(R.id.tabsChuongTrinhBaiTap);
        viewPager = (ViewPager) findViewById(R.id.viewpagerChuongTrinhBaiTap);
        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);
    }

    public void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        for (int i = 1; i <= lengthList; i++) {
            adapter.addFragment(ChuongTrinhBaiTapChiTietFragment.newInstance(listCT,i-1),i+"");
        }
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(poi);
    }
}