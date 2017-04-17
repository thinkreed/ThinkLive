package com.reed.live.controllers.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reed.live.data.model.Model;
import com.reed.thinklive.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thinkreed on 2017/4/13.
 */

public class ItemListAdapter extends RecyclerView.Adapter {

  private List<Model> data = new ArrayList<>();

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    Model model = data.get(position);
    ViewHolder viewHolder = (ViewHolder) holder;
    viewHolder.repoDescription.setText(model.getRepository().getDescription());
    viewHolder.repoName.setText(model.getRepository().getName());
  }

  @Override
  public int getItemCount() {
    return data.size();
  }

  public void setData(List<Model> data) {
    this.data = data;
    notifyDataSetChanged();
  }

  static class ViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.repo_name)
    TextView repoName;
    @BindView(R.id.repo_description)
    TextView repoDescription;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
