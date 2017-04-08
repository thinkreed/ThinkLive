package com.reed.live.viewmodel;

import android.content.Context;
import android.view.View;
import com.reed.live.Consts;
import com.reed.thinklive.R;
import com.shuyu.gsyvideoplayer.listener.StandardVideoAllCallBack;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

/**
 * Created by thinkreed on 2017/4/8.
 */

public class PlayerViewModel {
  StandardGSYVideoPlayer mVideoPlayer;
  private Context mContext;

  public PlayerViewModel(StandardGSYVideoPlayer videoPlayer, Context mContext) {
    this.mVideoPlayer = videoPlayer;
    this.mContext = mContext;
  }

  public void onViewCreated() {
    initPlayer();
  }

  public void onResume() {
    mVideoPlayer.onVideoResume();
  }

  public void onPause() {
    mVideoPlayer.onVideoPause();
  }

  public void onDestroyView() {
    mVideoPlayer.onVideoReset();
    mVideoPlayer.removeAllViews();
    mVideoPlayer.release();
  }

  private void initPlayer() {
    mVideoPlayer.setUp(Consts.VIDEO_URL, false);

    mVideoPlayer.getTitleTextView().setVisibility(View.VISIBLE);
    mVideoPlayer.getTitleTextView().setText(mContext.getString(R.string.title_test));

    mVideoPlayer.setStandardVideoAllCallBack(mVideoAllCallBack);

    mVideoPlayer.startPlayLogic();
  }

  private StandardVideoAllCallBack mVideoAllCallBack = new StandardVideoAllCallBack() {
    @Override
    public void onClickStartThumb(String url, Object... objects) {

    }

    @Override
    public void onClickBlank(String url, Object... objects) {

    }

    @Override
    public void onClickBlankFullscreen(String url, Object... objects) {

    }

    @Override
    public void onPrepared(String url, Object... objects) {

    }

    @Override
    public void onClickStartIcon(String url, Object... objects) {

    }

    @Override
    public void onClickStartError(String url, Object... objects) {

    }

    @Override
    public void onClickStop(String url, Object... objects) {

    }

    @Override
    public void onClickStopFullscreen(String url, Object... objects) {

    }

    @Override
    public void onClickResume(String url, Object... objects) {

    }

    @Override
    public void onClickResumeFullscreen(String url, Object... objects) {

    }

    @Override
    public void onClickSeekbar(String url, Object... objects) {

    }

    @Override
    public void onClickSeekbarFullscreen(String url, Object... objects) {

    }

    @Override
    public void onAutoComplete(String url, Object... objects) {

    }

    @Override
    public void onEnterFullscreen(String url, Object... objects) {

    }

    @Override
    public void onQuitFullscreen(String url, Object... objects) {

    }

    @Override
    public void onQuitSmallWidget(String url, Object... objects) {

    }

    @Override
    public void onEnterSmallWidget(String url, Object... objects) {

    }

    @Override
    public void onTouchScreenSeekVolume(String url, Object... objects) {

    }

    @Override
    public void onTouchScreenSeekPosition(String url, Object... objects) {

    }

    @Override
    public void onTouchScreenSeekLight(String url, Object... objects) {

    }

    @Override
    public void onPlayError(String url, Object... objects) {

    }
  };

}
