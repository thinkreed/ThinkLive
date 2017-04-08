package com.reed.live.presentations.fragment;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.laifeng.sopcastsdk.camera.CameraListener;
import com.laifeng.sopcastsdk.configuration.AudioConfiguration;
import com.laifeng.sopcastsdk.configuration.CameraConfiguration;
import com.laifeng.sopcastsdk.configuration.VideoConfiguration;
import com.laifeng.sopcastsdk.entity.Watermark;
import com.laifeng.sopcastsdk.entity.WatermarkPosition;
import com.laifeng.sopcastsdk.stream.packer.rtmp.RtmpPacker;
import com.laifeng.sopcastsdk.stream.sender.rtmp.RtmpSender;
import com.laifeng.sopcastsdk.ui.CameraLivingView;
import com.laifeng.sopcastsdk.utils.SopCastLog;
import com.reed.live.viewmodel.LiveViewModel;
import com.reed.thinklive.R;
import com.reed.thinklive.databinding.FragmentLiveBinding;

import static com.shuyu.gsyvideoplayer.GSYVideoPlayer.TAG;

/**
 * Created by thinkreed on 2017/4/3.
 */

public class ThinkLiveFragment extends BaseFragment {

  private LiveViewModel mViewModel;

  public static ThinkLiveFragment newInstance() {
    return new ThinkLiveFragment();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    FragmentLiveBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_live,
        container, false);
    mViewModel = new LiveViewModel(binding.livingView, getActivity());
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mViewModel.onViewCreated();
  }

  @Override
  public void onResume() {
    super.onResume();
    mViewModel.onResume();
  }

  @Override
  public void onPause() {
    super.onPause();
    mViewModel.onPause();
  }

  @Override
  public void onDestroy() {
    mViewModel.onDestroyView();
    super.onDestroy();
  }
}
