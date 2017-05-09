package com.example.daomy.fitnesstutorial3.fragment;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.example.daomy.fitnesstutorial3.R;
import com.example.daomy.fitnesstutorial3.activity.SplashScreenActivity;
import com.example.daomy.fitnesstutorial3.adapter.BaiTapListAdapter;
import com.example.daomy.fitnesstutorial3.molde.BaiTap;

import java.util.ArrayList;

/**
 * Created by daomy on 5/6/2017.
 */

public class CobapFragment extends Fragment {
    ListView listView;
    ArrayList<BaiTap> list;
    BaiTapListAdapter adapter = null;
    static public CobapFragment newInstance(){
        return new CobapFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        Log.d("datad","Co fragment");
        View view = inflater.inflate(R.layout.baitap_list_activity,container,false);
        listView = (ListView) view.findViewById(R.id.listView);
        list = new ArrayList<>();
        adapter = new BaiTapListAdapter(view.getContext(),R.layout.baitap_item,list);
        listView.setAdapter(adapter);
        // get all data from sqlite
        Cursor cursor = SplashScreenActivity.sqLiteHelper.getData("SELECT * FROM BAITAP");
        list.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String type = cursor.getString(1);
            String ten = cursor.getString(2);
            String tage =cursor.getString(3);
            String tagn = cursor.getString(4);
            String tagh = cursor.getString(5);
            String info = cursor.getString(6);
            byte[] image = cursor.getBlob(7);
            list.add(new BaiTap(id, type, ten, tage,tagn,tagh,image,info));
            Log.d("datad",id+ type+ ten+ tage+tagn+tagh+image+info);
        }
        adapter.notifyDataSetChanged();
        return  view;
    }

//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.food_list_activity);
//
//        gridView = (GridView) findViewById(R.id.gridView);
//        list = new ArrayList<>();
//        adapter = new FoodListAdapter(this, R.layout.food_items, list);
//        gridView.setAdapter(adapter);
//
//        // get all data from sqlite
//        Cursor cursor = MainActivity.sqLiteHelper.getData("SELECT * FROM FOOD");
//        list.clear();
//        while (cursor.moveToNext()){
//            int id = cursor.getInt(0);
//            String name = cursor.getString(1);
//            String price = cursor.getString(2);
//            byte[] image = cursor.getBlob(3);
//
//            list.add(new Food(name, price, image, id));
//        }
//        adapter.notifyDataSetChanged();
//    }
}
