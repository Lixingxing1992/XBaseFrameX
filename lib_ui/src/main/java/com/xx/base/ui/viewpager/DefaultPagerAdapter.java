package com.xx.base.ui.viewpager;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lixingxing on 2019/4/16.
 */
public class DefaultPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;

    public DefaultPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.fragmentList = fragmentList;
    }

    /**
     * 得到每个页面
     */
    @Override
    public Fragment getItem(int arg0) {
        return (fragmentList == null || fragmentList.size() == 0) ? null
                : fragmentList.get(arg0);
    }

    /**
     * 每个页面的title
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

    /**
     * 页面的总个数
     */
    @Override
    public int getCount() {
        return fragmentList == null ? 0 : fragmentList.size();
    }
}
