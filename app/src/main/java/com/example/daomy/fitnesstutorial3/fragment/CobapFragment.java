package com.example.daomy.fitnesstutorial3.fragment;


import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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
import com.example.daomy.fitnesstutorial3.molde.TypeBaiTap;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 * Created by daomy on 5/6/2017.
 */

public class CobapFragment extends Fragment {
    ListView listView;
    ArrayList<TypeBaiTap> list;
    BaiTapListAdapter adapter = null;
    static String type;
    static public CobapFragment newInstance(String t){
        type = t;
        return new CobapFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.baitap_list_activity,container,false);
        listView = (ListView) view.findViewById(R.id.listView);
        list = new ArrayList<>();
        adapter = new BaiTapListAdapter(view.getContext(),R.layout.baitap_item,list);
        listView.setAdapter(adapter);
        // get all data from sqlite
//        Cursor cursor = SplashScreenActivity.sqLiteHelper.getData("SELECT * FROM BAITAP");
        Cursor cursor = MainFragment.sqLiteHelper.getData("SELECT DISTINCT tagh FROM BAITAP WHERE type = '"+type+"'");
        list.clear();
        while (cursor.moveToNext()){
            String tagh = cursor.getString(0);
            String kieu = "";
            byte[] bitMapData=null;
            switch (tagh)
            {
                case "Tay":
                    Resources res = getResources();
                    Drawable drawable = res.getDrawable(R.drawable.tay);
                    Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    bitMapData = stream.toByteArray();
                    kieu = "Các bài tập tay";
                    list.add(new TypeBaiTap(kieu,tagh,bitMapData));
                    break;
                case "Lưng":
                    Resources reslung = getResources();
                    Drawable drawable1 = reslung.getDrawable(R.drawable.lung);
                    Bitmap bitmap1 = ((BitmapDrawable)drawable1).getBitmap();
                    ByteArrayOutputStream stream1 = new ByteArrayOutputStream();
                    bitmap1.compress(Bitmap.CompressFormat.JPEG, 100, stream1);
                    bitMapData = stream1.toByteArray();
                    kieu = "Các bài tập lưng";
                    list.add(new TypeBaiTap(kieu,tagh,bitMapData));
                    break;


            }



//            Log.d("datad",id+ type+ ten+ tage+tagn+tagh+image+info);
        }
        adapter.notifyDataSetChanged();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String kieu = list.get(position).getTagh();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, BaitapChiTietFragment.newInstance(kieu))
                        .addToBackStack(null)
                        .commit();
            }
        });

        return  view;
    }

}
