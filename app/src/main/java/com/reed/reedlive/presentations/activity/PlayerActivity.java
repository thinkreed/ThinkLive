package com.reed.reedlive.presentations.activity;

import android.support.v4.app.Fragment;
import com.reed.reedlive.presentations.fragment.PlayerFragment;

/**
 * Created by thinkreed on 2017/4/4.
 */

public class PlayerActivity extends SingleFragmentActivity {
    @Override protected Fragment getFragment() {
        return PlayerFragment.newInstance();
    }
}
