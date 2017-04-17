package com.reed.live.controllers.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reed.live.controllers.adapter.ItemListAdapter;
import com.reed.live.data.event.GetReposEvent;
import com.reed.live.worker.commands.CommandExecutor;
import com.reed.live.worker.commands.FetchRepoCommand;
import com.reed.thinklive.R;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by thinkreed on 2017/4/9.
 */

public class MainFragment extends BaseFragment {

  @BindView(R.id.list) RecyclerView mRecyclerView;
  private ItemListAdapter mAdapter;

  public static MainFragment newInstance() {
    return new MainFragment();
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
    @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_list, container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);
    EventBus.getDefault().register(this);
    mAdapter = new ItemListAdapter();
    mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    mRecyclerView.setAdapter(mAdapter);
    CommandExecutor.executeCommand(new FetchRepoCommand());
  }

  @Override public void onDestroyView() {
    EventBus.getDefault().unregister(this);
    super.onDestroyView();
  }

  @Subscribe(threadMode = ThreadMode.MAIN) public void onGetReposEvent(GetReposEvent event) {
    mAdapter.setData(event.getRepos());
  }
}
