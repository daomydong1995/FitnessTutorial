package com.example.daomy.fitnesstutorial3.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daomy.fitnesstutorial3.R;
import com.example.daomy.fitnesstutorial3.adapter.ViewPagerAdapter;
import com.example.daomy.fitnesstutorial3.fragment.MainFragment;
import com.example.daomy.fitnesstutorial3.fragment.NgaychuongtrinhFragment;


/**
 * Created by daomy on 5/12/2017.
 */

public class TuanChuongTrinhActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private String tenCT;
    ViewPager viewPager;

    int Ngay;
    static public TuanChuongTrinhActivity newInstance(){
        return new TuanChuongTrinhActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
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
        Log.d("bc2",""+Ngay);
        for(int i =1 ;i<=Ngay;i++) {
//            else {
                Log.d("ngayCT"," "+i);
                adapter.addFragment(NgaychuongtrinhFragment.newInstance(tenCT,i), "Ngay " + i + "");
//            }
        }
        viewPager.setAdapter(adapter);
    }
}
