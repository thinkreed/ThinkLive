package com.reed.live.controllers.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.reed.live.utils.Consts;
import com.reed.thinklive.R;
import com.shuyu.gsyvideoplayer.listener.StandardVideoAllCallBack;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

/**
 * Created by thinkreed on 2017/4/4.
 */

public class PlayerFragment extends BaseFragment {
  private StandardGSYVideoPlayer mVideoPlayer;

  public static PlayerFragment newInstance() {
    return new PlayerFragment();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_player, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initPlayer();
  }

  @Override
  public void onResume() {
    super.onResume();
    mVideoPlayer.onVideoResume();
  }

  @Override
  public void onPause() {
    mVideoPlayer.onVideoPause();
    super.onPause();
  }

  @Override
  public void onDestroyView() {
    mVideoPlayer.onVideoReset();
    mVideoPlayer.removeAllViews();
    mVideoPlayer.release();
    super.onDestroyView();
  }

  private void initPlayer() {
    mVideoPlayer.setUp(Consts.VIDEO_URL, false);

    mVideoPlayer.getTitleTextView().setVisibility(View.VISIBLE);
    mVideoPlayer.getTitleTextView().setText(getActivity().getString(R.string.title_test));

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
