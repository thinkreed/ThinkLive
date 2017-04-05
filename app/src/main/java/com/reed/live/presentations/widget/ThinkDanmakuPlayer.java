package com.reed.live.presentations.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

/**
 * Created by thinkreed on 2017/4/4.
 */

public class ThinkDanmakuPlayer extends StandardGSYVideoPlayer {
    public ThinkDanmakuPlayer(Context context, Boolean fullFlag) {
        super(context, fullFlag);
    }

    public ThinkDanmakuPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ThinkDanmakuPlayer(Context context) {

        super(context);
    }
}
