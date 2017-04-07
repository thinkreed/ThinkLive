package com.reed.live.viewmodel;

import android.content.Intent;
import android.view.View;
import com.reed.live.data.Names;
import com.reed.live.presentations.activity.LiveActivity;
import com.reed.live.presentations.activity.PlayerActivity;

/**
 * Created by thinkreed on 2017/4/5.
 */

public class MainViewModel {

    private Names mNames;

    public MainViewModel() {
        mNames = Names.newBuilder().player("videoplayer").live("live").build();
    }

    public String getLiveName() {
        return mNames.getLive();
    }

    public String getPlayerName() {
        return mNames.getPlayer();
    }

    public View.OnClickListener onClickLive() {
        return new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LiveActivity.class);
                v.getContext().startActivity(intent);
            }
        };
    }

    public View.OnClickListener onClickPlayer() {
        return new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PlayerActivity.class);
                v.getContext().startActivity(intent);
            }
        };
    }
}
