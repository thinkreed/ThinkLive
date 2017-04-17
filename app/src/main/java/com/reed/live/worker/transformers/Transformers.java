package com.reed.live.worker.transformers;

import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by thinkreed on 2017/4/14.
 */

public class Transformers {

  public static <T> FlowableTransformer<T, T> getIOMainTranformer() {
    return tranformer -> tranformer
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }
}
