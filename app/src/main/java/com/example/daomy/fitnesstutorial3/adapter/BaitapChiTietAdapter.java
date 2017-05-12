package com.example.daomy.fitnesstutorial3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.daomy.fitnesstutorial3.R;
import com.example.daomy.fitnesstutorial3.molde.BaiTap;
import com.example.daomy.fitnesstutorial3.molde.TypeBaiTap;

import java.util.ArrayList;

/**
 * Created by daomy on 5/9/2017.
 */

public class BaitapChiTietAdapter extends BaseAdapter {
    private Context context;
    private  int layout;
    private ArrayList<BaiTap> baiTaps;

    public BaitapChiTietAdapter(Context context, int layout, ArrayList<BaiTap> baitapList) {
        this.context = context;
        this.layout = layout;
        this.baiTaps = baitapList;
    }

    @Override
    public int getCount() {
        return baiTaps.size();
    }

    @Override
    public Object getItem(int position) {
        return baiTaps.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imgBaiTap;
        TextView txtType;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        BaitapChiTietAdapter.ViewHolder holder = new BaitapChiTietAdapter.ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtType = (TextView) row.findViewById(R.id.txtType);
            holder.imgBaiTap = (ImageView) row.findViewById(R.id.imgBaiTap);
            row.setTag(holder);
        }
        else {
            holder = (BaitapChiTietAdapter.ViewHolder) row.getTag();
        }

        BaiTap baiTap = baiTaps.get(position);

        holder.txtType.setText(baiTap.getTen());
        byte[] baitapImage = baiTap.getImage();

//        Bitmap bitmap = BitmapFactory.decodeByteArray(baitapImage, 0, baitapImage.length);


        Glide.with(context)
                .load(baitapImage)
                .error(R.drawable.imagenotfound)
                .override(70, 70)
                .into(holder.imgBaiTap);
//        holder.imgBaiTap.setImageBitmap(bitmap);

        return row;
    }
}
