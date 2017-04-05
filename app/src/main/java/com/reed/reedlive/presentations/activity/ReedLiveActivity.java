package com.reed.reedlive.presentations.activity;

import android.support.v4.app.Fragment;
import com.reed.reedlive.presentations.fragment.ReedLiveFragment;

/**
 * Created by thinkreed on 2017/4/3.
 */

public class ReedLiveActivity extends SingleFragmentActivity {
    @Override protected Fragment getFragment() {
        return ReedLiveFragment.newInstance();
    }
}
