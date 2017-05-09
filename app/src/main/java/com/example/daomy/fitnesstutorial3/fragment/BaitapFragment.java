package com.example.daomy.fitnesstutorial3.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.daomy.fitnesstutorial3.R;

/**
 * Created by daomy on 5/6/2017.
 */

public class BaitapFragment extends Fragment {
    Button btnCobap,btnCardio,btnYoga,btnHome;

    static public BaitapFragment newInstance(){
        return new BaitapFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.baitap_fragment,container,false);
        btnCobap = (Button) view.findViewById(R.id.btnCobap) ;
        btnCobap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, CobapFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }

}
