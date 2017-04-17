package com.reed.live.worker.commands;

import com.reed.live.data.event.GetReposEvent;
import com.reed.live.data.model.Model;
import com.reed.live.utils.Consts;
import com.reed.live.worker.network.NetWork;
import com.reed.live.worker.transformers.Transformers;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;

/**
 * Created by thinkreed on 2017/4/14.
 */

public class FetchRepoCommand implements Command {
  @Override
  public void execute() {
    NetWork.INSTANCE.getGithubApi()
        .doGet(Consts.GITHUB_REPOS, new HashMap<String, String>())
        .compose(Transformers.getIOMainTranformer())
        .flatMapIterable(repos -> repos)
        .map(repo -> Model.newBuilder().repository(repo).build())
        .toList()
        .subscribe(models -> EventBus.getDefault().post(new GetReposEvent(models)));
  }
}
