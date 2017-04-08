package com.reed.live.viewmodel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
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
import com.reed.thinklive.R;

import static com.shuyu.gsyvideoplayer.GSYVideoPlayer.TAG;

/**
 * Created by thinkreed on 2017/4/8.
 */

public class LiveViewModel {

  private CameraLivingView mCameraLivingView;
  private GestureDetector mGestureDetector;
  private boolean isRecording;
  private int mCurrentBps;
  private VideoConfiguration mVideoConfiguration;
  private RtmpSender mRtmpSender;
  private String url = "rtmp://192.168.1.102/live/livestream";
  private Context mContext;

  public LiveViewModel(CameraLivingView mCameraLivingView, Context mContext) {
    this.mCameraLivingView = mCameraLivingView;
    this.mContext = mContext;
  }

  public void onViewCreated() {
    initLiveView();
  }

  public void onResume() {
    mCameraLivingView.resume();
  }

  public void onPause() {
    mCameraLivingView.pause();
  }

  public void onDestroyView() {
    mCameraLivingView.stop();
    mCameraLivingView.removeAllViews();
    mCameraLivingView.release();
  }

  public class GestureListener extends GestureDetector.SimpleOnGestureListener {
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
      if (e1.getX() - e2.getX() > 100 && Math.abs(velocityX) > 200) {
        // Fling left
        Toast.makeText(mContext, "Fling Left", Toast.LENGTH_SHORT).show();
      } else if (e2.getX() - e1.getX() > 100 && Math.abs(velocityX) > 200) {
        // Fling right
        Toast.makeText(mContext, "Fling Right", Toast.LENGTH_SHORT).show();
      }
      return super.onFling(e1, e2, velocityX, velocityY);
    }
  }

  private RtmpSender.OnSenderListener mSenderListener = new RtmpSender.OnSenderListener() {
    @Override public void onConnecting() {

    }

    @Override public void onConnected() {
      mCameraLivingView.start();
      mCurrentBps = mVideoConfiguration.maxBps;
    }

    @Override public void onDisConnected() {
      Toast.makeText(mContext, "fail to live", Toast.LENGTH_SHORT).show();
      mCameraLivingView.stop();
      isRecording = false;
    }

    @Override public void onPublishFail() {
      Toast.makeText(mContext, "fail to publish stream", Toast.LENGTH_SHORT).show();
      isRecording = false;
    }

    @Override public void onNetGood() {
      if (mCurrentBps + 50 <= mVideoConfiguration.maxBps) {
        SopCastLog.d(TAG, "BPS_CHANGE good up 50");
        int bps = mCurrentBps + 50;
        if (mCameraLivingView != null) {
          boolean result = mCameraLivingView.setVideoBps(bps);
          if (result) {
            mCurrentBps = bps;
          }
        }
      } else {
        SopCastLog.d(TAG, "BPS_CHANGE good good good");
      }
      SopCastLog.d(TAG, "Current Bps: " + mCurrentBps);
    }

    @Override public void onNetBad() {
      if (mCurrentBps - 100 >= mVideoConfiguration.minBps) {
        SopCastLog.d(TAG, "BPS_CHANGE bad down 100");
        int bps = mCurrentBps - 100;
        if (mCameraLivingView != null) {
          boolean result = mCameraLivingView.setVideoBps(bps);
          if (result) {
            mCurrentBps = bps;
          }
        }
      } else {
        SopCastLog.d(TAG, "BPS_CHANGE bad down 100");
      }
      SopCastLog.d(TAG, "Current Bps: " + mCurrentBps);
    }
  };

  private void initLiveView() {
    SopCastLog.isOpen(true);
    mCameraLivingView.init();

    CameraConfiguration.Builder cameraBuilder = new CameraConfiguration.Builder();
    cameraBuilder.setOrientation(CameraConfiguration.Orientation.PORTRAIT)
      .setFacing(CameraConfiguration.Facing.BACK);
    CameraConfiguration cameraConfiguration = cameraBuilder.build();
    mCameraLivingView.setCameraConfiguration(cameraConfiguration);
    //设置预览监听
    mCameraLivingView.setCameraOpenListener(new CameraListener() {
      @Override public void onOpenSuccess() {
        Toast.makeText(mContext, "摄像头开启成功", Toast.LENGTH_LONG).show();
      }

      @Override public void onOpenFail(int error) {
        Toast.makeText(mContext, "摄像头开启失败", Toast.LENGTH_LONG).show();
      }

      @Override public void onCameraChange() {
        Toast.makeText(mContext, "摄像头切换", Toast.LENGTH_LONG).show();
      }
    });

    VideoConfiguration.Builder videoBuilder = new VideoConfiguration.Builder();
    videoBuilder.setSize(640, 360);
    mVideoConfiguration = videoBuilder.build();
    mCameraLivingView.setVideoConfiguration(mVideoConfiguration);
    //设置水印
    Bitmap watermarkImg =
      BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.ic_launcher);
    Watermark watermark =
      new Watermark(watermarkImg, 50, 25, WatermarkPosition.WATERMARK_ORIENTATION_BOTTOM_RIGHT, 8,
        8);
    mCameraLivingView.setWatermark(watermark);

    //初始化flv打包器
    RtmpPacker packer = new RtmpPacker();
    packer.initAudioParams(AudioConfiguration.DEFAULT_FREQUENCY, 16, false);
    mCameraLivingView.setPacker(packer);
    //设置发送器
    mRtmpSender = new RtmpSender();
    mRtmpSender.setAddress(url);
    mRtmpSender.setVideoParams(640, 360);
    mRtmpSender.setAudioParams(AudioConfiguration.DEFAULT_FREQUENCY, 16, false);
    mRtmpSender.setSenderListener(mSenderListener);
    mCameraLivingView.setSender(mRtmpSender);
    //设置手势识别
    mGestureDetector = new GestureDetector(mContext, new GestureListener());
    mCameraLivingView.setOnTouchListener(new View.OnTouchListener() {
      @Override public boolean onTouch(View v, MotionEvent event) {
        mGestureDetector.onTouchEvent(event);
        return false;
      }
    });

    mCameraLivingView.setLivingStartListener(new CameraLivingView.LivingStartListener() {
      @Override public void startError(int error) {
        //直播失败
        Toast.makeText(mContext, "start living fail", Toast.LENGTH_SHORT).show();
        mCameraLivingView.stop();
      }

      @Override public void startSuccess() {
        //直播成功
        Toast.makeText(mContext, "start living", Toast.LENGTH_SHORT).show();
      }
    });

    mRtmpSender.connect();
    isRecording = true;
  }
}
