package com.example.daomy.fitnesstutorial3.activity;

import android.support.v4.app.Fragment;
import com.example.daomy.fitnesstutorial3.fragment.MainFragment;

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        MainFragment mainFragment = new MainFragment();
        return mainFragment.newInstance();
    }


}
