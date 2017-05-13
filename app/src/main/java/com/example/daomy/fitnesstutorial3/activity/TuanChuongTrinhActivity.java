package com.example.daomy.fitnesstutorial3.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.daomy.fitnesstutorial3.R;
import com.example.daomy.fitnesstutorial3.adapter.ViewPagerAdapter;
import com.example.daomy.fitnesstutorial3.fragment.BaitapChiTietFragment;
import com.example.daomy.fitnesstutorial3.fragment.BaitapFragment;
import com.example.daomy.fitnesstutorial3.fragment.CobapFragment;
import com.example.daomy.fitnesstutorial3.fragment.MainFragment;
import com.example.daomy.fitnesstutorial3.fragment.NgaychuongtrinhFragment;
import com.example.daomy.fitnesstutorial3.molde.ListChuongTrinh;

import java.io.ByteArrayOutputStream;

/**
 * Created by daomy on 5/12/2017.
 */

public class TuanChuongTrinhActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private String tenCT;
    ViewPager viewPager;

    int Ngay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        tenCT = intent.getStringExtra("tenCT");
        Cursor cursor = MainFragment.sqLiteHelper.getData("SELECT COUNT(DISTINCT NgayCT) FROM CHUONGTRINH GROUP BY TenCT HAVING TenCT = '"+tenCT+"'");


        setContentView(R.layout.activity_tuan_chuongtrinh);
        tabLayout= (TabLayout) findViewById(R.id.tabsChampionDetail);
        viewPager= (ViewPager) findViewById(R.id.viewpagerChampionDetail);
        tabLayout.setupWithViewPager(viewPager);
        while (cursor.moveToNext()){
                Ngay = cursor.getInt(0);
        }
        setupViewPager(viewPager);
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        CobapFragment cobapFragment = new CobapFragment();
        Log.d("bc2",""+Ngay);
        for(int i =0 ;i<=Ngay;i++) {
            if(i == 0){

            }
            else {
                adapter.addFragment(NgaychuongtrinhFragment.newInstance(tenCT,i), "Ngay " + i + "");
            }
        }
        viewPager.setAdapter(adapter);
    }
}
