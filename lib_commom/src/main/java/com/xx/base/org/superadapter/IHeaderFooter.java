package com.xx.base.org.superadapter;

import android.view.View;

/**
 * Methods about header and footer.
 * <p>
 * Created by Lixingxing on 16/1/12.
 */
interface IHeaderFooter {
    View getHeaderView();

    View getFooterView();

    void addHeaderView(View header);

    void addFooterView(View footer);

    boolean removeHeaderView();

    boolean removeFooterView();

    boolean hasHeaderView();

    boolean hasFooterView();

    boolean isHeaderView(int position);

    boolean isFooterView(int position);
}
