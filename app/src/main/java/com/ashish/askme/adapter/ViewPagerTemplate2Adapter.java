package com.ashish.askme.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ashish.askme.fragment.BaseFragment;
import com.ashish.askme.fragment.ViewPagerItemFragment;
import com.ashish.askme.model.Item;

import java.util.List;

/**
 * Created by akohlikashish on 20/04/16.
 */
public class ViewPagerTemplate2Adapter extends FragmentStatePagerAdapter {
    List<Item> mList;

    public ViewPagerTemplate2Adapter(FragmentManager fm, List<Item> list) {
        super(fm);
        this.mList = list;
    }

    public ViewPagerTemplate2Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        BaseFragment fragment = ViewPagerItemFragment.newInstance(mList.get(position));
        return fragment;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public float getPageWidth(int position) {
        return 0.5f;
    }
}
