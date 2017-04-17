package com.reed.live.data.event;

import com.reed.live.data.model.Model;
import java.util.List;

/**
 * Created by thinkreed on 2017/4/14.
 */

public class GetReposEvent {
  private List<Model> repos;

  public GetReposEvent(List<Model> repos) {
    this.repos = repos;
  }

  public List<Model> getRepos() {
    return repos;
  }
}
