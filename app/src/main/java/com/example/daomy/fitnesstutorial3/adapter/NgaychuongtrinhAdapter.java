package com.example.daomy.fitnesstutorial3.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.daomy.fitnesstutorial3.R;
import com.example.daomy.fitnesstutorial3.fragment.MainFragment;
import com.example.daomy.fitnesstutorial3.fragment.NgaychuongtrinhFragment;
import com.example.daomy.fitnesstutorial3.molde.ChuongTrinh;
import com.example.daomy.fitnesstutorial3.molde.ListChuongTrinh;

import java.util.ArrayList;

/**
 * Created by daomy on 5/13/2017.
 */

public class NgaychuongtrinhAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<ChuongTrinh> chuongTrinhs;

    public NgaychuongtrinhAdapter(Context context, int layout, ArrayList<ChuongTrinh> chuongTrinhs) {
        this.context = context;
        this.layout = layout;
        this.chuongTrinhs = chuongTrinhs;
    }

    @Override
    public int getCount() {
        return chuongTrinhs.size();
    }

    @Override
    public Object getItem(int position) {
        return chuongTrinhs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        TextView txtTenCT;
        TextView txtDesCT;
        ImageView imgCT;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        NgaychuongtrinhAdapter.ViewHolder holder = new NgaychuongtrinhAdapter.ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtTenCT = (TextView) row.findViewById(R.id.txtTenCT);
            holder.imgCT = (ImageView) row.findViewById(R.id.imgChuongTrinh);
            holder.txtDesCT = (TextView) row.findViewById(R.id.txtDesCT);
            row.setTag(holder);
        }
        else {
            holder = (NgaychuongtrinhAdapter.ViewHolder) row.getTag();
        }

        ChuongTrinh chuongTrinh = chuongTrinhs.get(position);


        Cursor cursor = MainFragment.sqLiteHelper.getData("SELECT ten, image FROM BAITAP WHERE Id = '"+chuongTrinh.getId()+"'");

        if(chuongTrinh.getTime() == null){
            holder.txtDesCT.setText(chuongTrinh.getSET() + "Hiệp |"+chuongTrinh.getREP() + " Lần");
        }
        else {
            holder.txtDesCT.setText(chuongTrinh.getTime()+" Phút");
        }

        byte[] baitapImage = null;

        while (cursor.moveToNext()) {
            holder.txtTenCT.setText(cursor.getString(0));
            baitapImage = cursor.getBlob(1);
        }
//        Bitmap bitmap = BitmapFactory.decodeByteArray(baitapImage, 0, baitapImage.length);


        Glide.with(context)
                .load(baitapImage)
                .error(R.drawable.imagenotfound)
                .override(70, 70)
                .into(holder.imgCT);
//        holder.imgBaiTap.setImageBitmap(bitmap);

        return row;
    }

}
