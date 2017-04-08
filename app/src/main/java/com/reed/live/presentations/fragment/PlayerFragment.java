package com.reed.live.presentations.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.reed.live.viewmodel.PlayerViewModel;
import com.reed.thinklive.R;
import com.reed.live.Consts;
import com.reed.thinklive.databinding.FragmentPlayerBinding;
import com.shuyu.gsyvideoplayer.GSYVideoPlayer;
import com.shuyu.gsyvideoplayer.listener.StandardVideoAllCallBack;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

/**
 * Created by thinkreed on 2017/4/4.
 */

public class PlayerFragment extends BaseFragment {
  private PlayerViewModel mViewModel;

  public static PlayerFragment newInstance() {
    return new PlayerFragment();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    FragmentPlayerBinding binding =
        DataBindingUtil.inflate(inflater, R.layout.fragment_player, container, false);
    mViewModel = new PlayerViewModel(binding.videoPlayer, getActivity());
    return binding.getRoot();
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mViewModel.onViewCreated();
  }

  @Override public void onResume() {
    super.onResume();
    mViewModel.onResume();
  }

  @Override public void onPause() {
    mViewModel.onPause();
    super.onPause();
  }

  @Override public void onDestroyView() {
    mViewModel.onDestroyView();
    super.onDestroyView();
  }
}
