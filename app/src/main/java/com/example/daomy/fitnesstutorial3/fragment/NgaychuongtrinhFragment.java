package com.example.daomy.fitnesstutorial3.fragment;

import android.database.Cursor;
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
import com.example.daomy.fitnesstutorial3.adapter.BaitapChiTietAdapter;
import com.example.daomy.fitnesstutorial3.adapter.NgaychuongtrinhAdapter;
import com.example.daomy.fitnesstutorial3.molde.BaiTap;
import com.example.daomy.fitnesstutorial3.molde.ChuongTrinh;

import java.util.ArrayList;

/**
 * Created by daomy on 5/13/2017.
 */

public class NgaychuongtrinhFragment extends Fragment {
    ListView listView;
    ArrayList<ChuongTrinh> list;
    NgaychuongtrinhAdapter adapter = null;

    static int ngayCT = 0;
    static String tenCT = null;

    static public NgaychuongtrinhFragment newInstance(String ten, int ngay) {
        ngayCT = ngay;
        tenCT = ten;
        return new NgaychuongtrinhFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.baitap_list_activity, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        list = new ArrayList<>();
        adapter = new NgaychuongtrinhAdapter(view.getContext(), R.layout.chuongtrinh_item, list);
        listView.setAdapter(adapter);
        // get all data from sqlite
//        Cursor cursor = SplashScreenActivity.sqLiteHelper.getData("SELECT * FROM BAITAP");
        Cursor cursor = MainFragment.sqLiteHelper.getData("SELECT * FROM CHUONGTRINH WHERE TenCT = '" + tenCT + "' AND NgayCT = '"+ngayCT+"'");
        list.clear();
        while (cursor.moveToNext()) {
            int maCT = cursor.getInt(0);
            String tenCT = cursor.getString(1);
            int ngay = cursor.getInt(2);
            String desCT = cursor.getString(3);
            int Id = cursor.getInt(4);
            String time = cursor.getString(5);
            int set = cursor.getInt(6);
            int rep = cursor.getInt(7);
            list.add(new ChuongTrinh(maCT,tenCT,ngay,desCT,Id,time,set,rep));
        }

        adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                FragmentTransaction ft = getFragmentManager().beginTransaction();

            }
        });
        return view;
    }

}
