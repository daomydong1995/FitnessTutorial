package com.example.daomy.fitnesstutorial3.fragment;

import android.app.ProgressDialog;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.daomy.fitnesstutorial3.R;
import com.example.daomy.fitnesstutorial3.database.Database;
import com.example.daomy.fitnesstutorial3.database.SQLiteHelper;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by daomy on 5/6/2017.
 */

public class MainFragment extends Fragment implements View.OnClickListener {
    private ProgressDialog pDialog;
    public static SQLiteHelper sqLiteHelper;
    Button btnbaitap, btnchuongtrinh, btnbangtracalo;
    final String DATABASE_NAME="Baitap.sqlite";
    SQLiteDatabase database;

    public MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        sqLiteHelper = new SQLiteHelper(view.getContext(), "Baitap.sqlite", null, 1);
        btnbaitap = (Button) view.findViewById(R.id.btnbaitap);
        btnchuongtrinh = (Button) view.findViewById(R.id.btnchuongtrinh);
        btnbangtracalo = (Button) view.findViewById(R.id.btnbangtracalo);

        database = Database.initDatabase(getActivity(),DATABASE_NAME);
        addControls();
        addEvents();
        return view;
    }


    private void addControls() {

        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage(getResources().getString(R.string.checking_account));
        pDialog.setCancelable(false);


    }

    private void addEvents() {

        btnbaitap.setOnClickListener(this);
        btnchuongtrinh.setOnClickListener(this);
        btnbangtracalo.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int viewID = v.getId();
        switch (viewID) {
            case R.id.btnbaitap:

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, BaitapFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.btnchuongtrinh:
                FragmentTransaction ft2 = getFragmentManager().beginTransaction();
                ft2.replace(R.id.fragment_container, ChuongTrinhFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.btnbangtracalo:
                break;
        }
    }
}
