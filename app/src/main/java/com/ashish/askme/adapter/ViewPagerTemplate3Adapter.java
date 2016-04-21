package com.ashish.askme.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ashish.askme.fragment.BaseFragment;
import com.ashish.askme.fragment.ViewPagerItemFragment;
import com.ashish.askme.model.Item;

import java.util.List;

/**
 * Created by akohlikashish on 22/04/16.
 */
public class ViewPagerTemplate3Adapter extends FragmentStatePagerAdapter {
    List<Item> mList;

    public ViewPagerTemplate3Adapter(FragmentManager fm, List<Item> list) {
        super(fm);
        this.mList = list;
    }

    public ViewPagerTemplate3Adapter(FragmentManager fm) {
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

}
