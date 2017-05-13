package com.example.daomy.fitnesstutorial3.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.daomy.fitnesstutorial3.R;
import com.example.daomy.fitnesstutorial3.activity.TuanChuongTrinhActivity;
import com.example.daomy.fitnesstutorial3.adapter.BaiTapListAdapter;
import com.example.daomy.fitnesstutorial3.adapter.ChuongTrinhAdapter;
import com.example.daomy.fitnesstutorial3.molde.ChuongTrinh;
import com.example.daomy.fitnesstutorial3.molde.ListChuongTrinh;
import com.example.daomy.fitnesstutorial3.molde.TypeBaiTap;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 * Created by daomy on 5/10/2017.
 */

public class ChuongTrinhFragment extends Fragment {
    ListView listView;
    ArrayList<ListChuongTrinh> list;
    ChuongTrinhAdapter adapter = null;
    static public ChuongTrinhFragment newInstance(){
        return new ChuongTrinhFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.baitap_list_activity,container,false);
        listView = (ListView) view.findViewById(R.id.listView);
        list = new ArrayList<>();
        adapter = new ChuongTrinhAdapter(view.getContext(),R.layout.chuongtrinh_item,list);
        listView.setAdapter(adapter);
        Cursor cursor = MainFragment.sqLiteHelper.getData("SELECT DISTINCT TenCT, DesCT FROM CHUONGTRINH");
        list.clear();
        byte[] bitMapData=null;
        while (cursor.moveToNext()){
                String TenCT = cursor.getString(0);
                String DesCT = cursor.getString(1);
                Resources reslung = getResources();
                Drawable drawable1 = reslung.getDrawable(R.drawable.logo);
                Bitmap bitmap1 = ((BitmapDrawable)drawable1).getBitmap();
                ByteArrayOutputStream stream1 = new ByteArrayOutputStream();
                bitmap1.compress(Bitmap.CompressFormat.JPEG, 100, stream1);
                bitMapData = stream1.toByteArray();
                list.add(new ListChuongTrinh(TenCT,DesCT,bitMapData));

        }
        adapter.notifyDataSetChanged();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),TuanChuongTrinhActivity.class);
                intent.putExtra("tenCT",list.get(position).getTenCT());
                Log.d("bc1",list.get(position).getTenCT());
                startActivity(intent);
            }
        });

        return  view;
//    }
    }
}
