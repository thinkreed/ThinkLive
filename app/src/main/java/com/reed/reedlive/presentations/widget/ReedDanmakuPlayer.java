package com.reed.reedlive.presentations.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

/**
 * Created by thinkreed on 2017/4/4.
 */

public class ReedDanmakuPlayer extends StandardGSYVideoPlayer {
    public ReedDanmakuPlayer(Context context, Boolean fullFlag) {
        super(context, fullFlag);
    }

    public ReedDanmakuPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ReedDanmakuPlayer(Context context) {

        super(context);
    }
}
