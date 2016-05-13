package com.liemng.library.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.liemng.library.Util;
import com.liemng.library.fragment.PageFragment;

/**
 * Created by liemng on 16-5-13.
 */
public class LazyViewPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = LazyViewPagerAdapter.class.getSimpleName();

    private Context mCtx;

    private int count = 0;


    public LazyViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mCtx = context;
    }

    @Override
    public int getCount() {
        if (null != itemCallBack)
            return itemCallBack.getCount();
        else
            throw new IllegalStateException("must be set callback for LazyViewPagerAdapter");
    }

    @Override
    public Fragment getItem(int position) {
        if (null != itemCallBack)
            return itemCallBack.getItem(position);
        else
            throw new IllegalStateException("must be set callback for LazyViewPagerAdapter");
    }

    /**
     * Set callback to fetch item by PagerFragment subclass.
     */

    private OnLazyPagerAdapterCallBack itemCallBack;

    public void setOnItemCallBackLisener(OnLazyPagerAdapterCallBack itemCallBackListener) {
        if (itemCallBack != itemCallBackListener) {
            this.itemCallBack = itemCallBackListener;
        } else {
            if (Util.DEBUG)
                Log.d(TAG, "Repeat set value for listener, count:" + ++count);
        }

    }

    public interface OnLazyPagerAdapterCallBack {
        PageFragment getItem(int position);
        int getCount();
    }
}
