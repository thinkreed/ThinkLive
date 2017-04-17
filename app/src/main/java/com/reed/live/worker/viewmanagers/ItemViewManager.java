package com.reed.live.worker.viewmanagers;

import android.view.View;
import com.reed.live.data.model.Model;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thinkreed on 2017/4/13.
 */

public class ItemViewManager {
  public View root;
  private List<View> mChildren;

  public ItemViewManager(View root) {
    this.root = root;
  }

  private void init() {
    this.mChildren = new ArrayList<>();
  }

  public void bind(Model model) {
    for (View v : mChildren) {

    }
  }
}
