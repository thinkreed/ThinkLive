package com.reed.reedlive.presentations.eventhandlers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.reed.thinklive.R;

/**
 * Created by thinkreed on 2017/4/5.
 */

public class ClickEventHandler implements EventHandler {
    @Override public void handleEvent(View view, Bundle bundle) {
        switch (view.getId()) {
            case R.id.button_jump:
                Intent intent = new Intent();
                view.getContext().startActivity(intent);
                break;
            case R.id.button_player:
                break;
        }
    }
}
