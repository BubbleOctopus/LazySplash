package com.liemng.lazysplash;

import android.graphics.Color;
import android.util.Log;

import com.liemng.lazysplash.fragment.OneFragment;
import com.liemng.lazysplash.fragment.ThreeFragment;
import com.liemng.lazysplash.fragment.TwoFragment;
import com.liemng.library.Util;
import com.liemng.library.fragment.PageFragment;
import com.liemng.library.viewpager.LazyViewPagerFragment;

/**
 * Created by liemng on 16-5-13.
 */
public class ViewPagerFragment extends LazyViewPagerFragment {
    private static final String TAG = ViewPagerFragment.class.getSimpleName();

    private static final int PAGE_NUM = 3;

    private static final int PAGE_ONE = 0;
    private static final int PAGE_TWO = 1;
    private static final int PAGE_THREE = 2;

    @Override
    public int getCount() {
        return PAGE_NUM;
    }

    @Override
    public PageFragment getItem(int position) {
        position %= PAGE_NUM;
        PageFragment mPagerFragment = null;
        switch (position){
            case PAGE_ONE:
                mPagerFragment = new OneFragment();
                break;
            case PAGE_TWO:
                mPagerFragment = new TwoFragment();
                break;
            case PAGE_THREE:
                mPagerFragment = new ThreeFragment();
                break;
            default:
                if(Util.DEBUG)
                    Log.d(TAG,"unknow index fetch fragment, position:" + position);
                break;
        }
        return mPagerFragment;
    }

    @Override
    public int getColor(int position) {
        position %= PAGE_NUM;
        int result =0;
        switch (position){
            case PAGE_ONE:
                result = Color.parseColor("#ff0000");
                break;
            case PAGE_TWO:
                result = Color.parseColor("#00ff00");
                break;
            case PAGE_THREE:
                result = Color.parseColor("#0000ff");
                break;
            default:
                result = Color.TRANSPARENT;
                if(Util.DEBUG)
                    Log.d(TAG,"unknow index fetch color, position:" + position);
                break;
        }

        return result;
    }
}
