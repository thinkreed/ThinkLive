package com.reed.live.controllers.activity;

import android.support.v4.app.Fragment;
import com.reed.live.controllers.fragment.LiveFragment;

/**
 * Created by thinkreed on 2017/4/3.
 */

public class LiveActivity extends SingleFragmentActivity {
    @Override protected Fragment getFragment() {
        return LiveFragment.newInstance();
    }
}
