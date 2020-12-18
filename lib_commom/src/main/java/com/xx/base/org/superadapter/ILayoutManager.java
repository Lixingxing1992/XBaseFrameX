package com.xx.base.org.superadapter;


import androidx.recyclerview.widget.RecyclerView;

/**
 * Methods about layout manager.
 * <p>
 * Created by Lixingxing on 16/1/18.
 */
interface ILayoutManager {
    boolean hasLayoutManager();

    RecyclerView.LayoutManager getLayoutManager();
}
