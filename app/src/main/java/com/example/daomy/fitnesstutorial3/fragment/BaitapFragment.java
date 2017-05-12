package com.example.daomy.fitnesstutorial3.fragment;


import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.daomy.fitnesstutorial3.R;
import com.example.daomy.fitnesstutorial3.database.Database;
import com.example.daomy.fitnesstutorial3.database.SQLiteHelper;

/**
 * Created by daomy on 5/6/2017.
 */

public class BaitapFragment extends Fragment implements View.OnClickListener {
    Button btnCobap,btnCardio,btnYoga,btnHome;
    String type ;

    boolean check= false;

    static public BaitapFragment newInstance(){
        return new BaitapFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
                View view = inflater.inflate(R.layout.baitap_fragment,container,false);
//        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS BAITAP(Id INTEGER PRIMARY KEY AUTOINCREMENT,type VARCHAR ,ten VARCHAR,tage VARCHAR,tagn VARCHAR,tagh VARCHAR,info VARCHAR,image BLOB )");


        btnCobap = (Button) view.findViewById(R.id.btnCobap) ;
        btnCardio = (Button) view.findViewById(R.id.btnCardio) ;
        btnYoga = (Button) view.findViewById(R.id.btnYoga) ;
        btnHome = (Button) view.findViewById(R.id.btnHome) ;


        btnCobap.setOnClickListener(this);
        btnCardio.setOnClickListener(this);
        btnYoga.setOnClickListener(this);
        btnHome.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnCobap:
                check = true;
                type = "Co";
                btnCobap.setBackgroundColor(Color.WHITE);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, CobapFragment.newInstance(type))
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.btnCardio:
                break;
            case R.id.btnYoga:
                break;
            case R.id.btnHome:
                break;
        }
    }
}
