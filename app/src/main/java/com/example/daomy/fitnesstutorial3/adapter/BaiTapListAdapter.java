package com.example.daomy.fitnesstutorial3.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by Quoc Nguyen on 13-Dec-16.
 */

public class BaiTapListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<TypeBaiTap> baiTaps;

    public BaiTapListAdapter(Context context, int layout, ArrayList<TypeBaiTap> baitapList) {
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
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtType = (TextView) row.findViewById(R.id.txtType);
            holder.imgBaiTap = (ImageView) row.findViewById(R.id.imgBaiTap);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        TypeBaiTap baiTap = baiTaps.get(position);

        holder.txtType.setText(baiTap.getKieu());
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
