package com.example.daomy.fitnesstutorial3.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.daomy.fitnesstutorial3.R;
import com.example.daomy.fitnesstutorial3.activity.ChuongTrinhBaiTapChiTietActivity;
import com.example.daomy.fitnesstutorial3.adapter.NgaychuongtrinhAdapter;
import com.example.daomy.fitnesstutorial3.molde.ChuongTrinh;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by daomy on 5/13/2017.
 */

public class NgaychuongtrinhFragment extends Fragment {
    ListView listView;
    ArrayList<ChuongTrinh> listCT;
    NgaychuongtrinhAdapter adapter = null;
    AppBarLayout apppa;

    private int ngayCT = 0;
    private String tenCT = null;

    public static NgaychuongtrinhFragment newInstance(String ten, int ngay) {
        Bundle bundle = new Bundle();
        bundle.putString("TEN", ten);
        bundle.putInt("NGAY", ngay);
        NgaychuongtrinhFragment fragment = new NgaychuongtrinhFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.baitap_list_activity, container, false);
        apppa = (AppBarLayout) view.findViewById(R.id.apppa);
        tenCT = getArguments().getString("TEN");
        ngayCT = getArguments().getInt("NGAY");
        listView = (ListView) view.findViewById(R.id.listView);
        listCT = new ArrayList<>();
        adapter = new NgaychuongtrinhAdapter(view.getContext(), R.layout.chuongtrinh_item, listCT);
        listView.setAdapter(adapter);
        // get all data from sqlite
//        Cursor cursor = SplashScreenActivity.sqLiteHelper.getData("SELECT * FROM BAITAP");
        Log.d("ngayCT","onCreateView "+ngayCT);
        Cursor cursor = MainFragment.sqLiteHelper.getData("SELECT * FROM CHUONGTRINH WHERE TenCT = '" + tenCT + "' AND NgayCT = '"+ngayCT+"'");
        listCT.clear();
        while (cursor.moveToNext()) {
            int maCT = cursor.getInt(0);
            String tenCT = cursor.getString(1);
            int ngay = cursor.getInt(2);
            String desCT = cursor.getString(3);
            int Id = cursor.getInt(4);
            int time = cursor.getInt(5);
            int set = cursor.getInt(6);
            int rep = cursor.getInt(7);
            Cursor cursor2 = MainFragment.sqLiteHelper.getData("SELECT ten,image,info FROM BAITAP WHERE Id = '"+Id+"'");
            byte[] img = null;
            String ten = "";
            while (cursor2.moveToNext()) {
                ten = cursor2.getString(0);
                img = cursor2.getBlob(1);
            }

            listCT.add(new ChuongTrinh(maCT,tenCT,ngay,desCT,Id,time,set,rep,img,ten));

        }

        adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(getActivity(),ChuongTrinhBaiTapChiTietActivity.newInstance(listCT));
//                intent.putExtra("tenCT",list.get(position).getTenCT());
//                intent.putExtra("List",listCT)
                intent.putExtra("length",listCT.size());
//                intent.putExtra("lisctCT",listCT);
                intent.putExtra("poi",position);
                startActivity(intent);
            }
        });
        return view;
    }

}
