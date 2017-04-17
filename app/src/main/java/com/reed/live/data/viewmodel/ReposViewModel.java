package com.reed.live.data.viewmodel;

import android.util.Log;
import com.reed.live.data.model.Repository;
import com.reed.live.worker.network.NetWork;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by thinkreed on 2017/4/10.
 */

public class ReposViewModel {

  public void getRepos() throws IOException {
    Flowable<List<Repository>> flowable =
        NetWork.INSTANCE.getGithubApi().doGet("users/thinkreed/repos",
            new HashMap<String, String>());
    flowable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<Repository>>() {
      @Override
      public void accept(List<Repository> repositories) throws Exception {
        for (Repository repo : repositories) {
          Log.d("reed", repo.getName());
        }
      }
    });
  }
}
