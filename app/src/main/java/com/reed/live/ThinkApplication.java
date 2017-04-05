package com.reed.live;

import android.app.Application;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by thinkreed on 2017/4/2.
 */

public class ThinkApplication extends Application {

    @Override public void onCreate() {
        super.onCreate();
        initializeLeakCanary();
    }

    private void initializeLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
