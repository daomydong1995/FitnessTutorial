package com.example.daomy.fitnesstutorial3.fragment;

import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.daomy.fitnesstutorial3.R;
import com.example.daomy.fitnesstutorial3.adapter.BaiTapListAdapter;
import com.example.daomy.fitnesstutorial3.adapter.BaitapChiTietAdapter;
import com.example.daomy.fitnesstutorial3.molde.BaiTap;
import com.example.daomy.fitnesstutorial3.molde.TypeBaiTap;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 * Created by daomy on 5/9/2017.
 */

public class BaitapChiTietFragment extends Fragment {
    ListView listView;
    ArrayList<BaiTap> list;
    BaitapChiTietAdapter adapter = null;
    private String tagh = null;
    static public BaitapChiTietFragment newInstance(String tag){
        Bundle bundle = new Bundle();
        bundle.putString("TAGH", tag);
        BaitapChiTietFragment fragment = new BaitapChiTietFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.baitap_list_activity,container,false);
        tagh = getArguments().getString("TAGH");
        listView = (ListView) view.findViewById(R.id.listView);
        list = new ArrayList<>();
        adapter = new BaitapChiTietAdapter(view.getContext(),R.layout.baitap_item,list);
        listView.setAdapter(adapter);
        // get all data from sqlite
//        Cursor cursor = SplashScreenActivity.sqLiteHelper.getData("SELECT * FROM BAITAP");
        Cursor cursor = MainFragment.sqLiteHelper.getData("SELECT * FROM BAITAP WHERE tagh = '"+tagh+"'");
        Log.d("kieuQuery",tagh);
        list.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String type = cursor.getString(1);
            String ten = cursor.getString(2);
            String tage = cursor.getString(3);
            String tagn = cursor.getString(4);
            String tagh = cursor.getString(5);
            String info = cursor.getString(6);
            byte[] image = cursor.getBlob(7);
            list.add(new BaiTap(id,type,ten,tage,tagn,tagh,image,info));

//            Log.d("datad",id+ type+ ten+ tage+tagn+tagh+image+info);
        }

        adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, HuongdantapFragment.newInstance(list,position))
                        .addToBackStack(null)
                        .commit();
            }
        });
        return  view;
    }
}
