package com.reed.live.worker.network;

import com.reed.live.utils.Consts;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public enum NetWork {

  INSTANCE;

  private GithubApi githubApi;

  public GithubApi getGithubApi() {
    if (githubApi == null) {
      Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
          .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
          .baseUrl(Consts.GITHUB_BASE)
          .build();
      githubApi = retrofit.create(GithubApi.class);
    }
    return githubApi;
  }


}
