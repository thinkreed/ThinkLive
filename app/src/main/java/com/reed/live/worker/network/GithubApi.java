package com.reed.live.worker.network;

import com.reed.live.data.model.Repository;
import io.reactivex.Flowable;
import java.util.List;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by thinkreed on 2017/4/12.
 */

public interface GithubApi {
  @GET
  Flowable<List<Repository>> doGet(@Url String url,
      @QueryMap Map<String, String> maps);
}
