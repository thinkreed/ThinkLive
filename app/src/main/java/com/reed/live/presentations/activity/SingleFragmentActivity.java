package com.reed.live.presentations.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import com.reed.thinklive.R;

/**
 * Created by thinkreed on 2017/4/3.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragmentManager.beginTransaction().add(R.id.fragment_container, getFragment()).commit();
        }
    }

    protected boolean hasToolBar() {
        return false;
    }

    private int getLayout() {
        return R.layout.activity_without_toolbar;
    }

    protected abstract Fragment getFragment();
}
