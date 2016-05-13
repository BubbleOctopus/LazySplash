package com.liemng.library.viewpager;

import android.animation.ArgbEvaluator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liemng.library.R;
import com.liemng.library.adapter.LazyViewPagerAdapter;
import com.liemng.library.fragment.PageFragment;

/**
 * Created by liemng on 16-5-13.
 */
public abstract class LazyViewPagerFragment extends Fragment implements ViewPager.OnPageChangeListener {

    private Context mCtx;
    private ViewPager mViewPager;
    private LazyViewPagerAdapter mLazyViewPagerAdapter;
    private ArgbEvaluator mArgbEvaluator;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCtx = getActivity();
        mArgbEvaluator = new ArgbEvaluator();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.splash_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewPager.setPageTransformer(true, new FragmentTransformer());
        mViewPager.addOnPageChangeListener(this);
        mLazyViewPagerAdapter = new LazyViewPagerAdapter(getChildFragmentManager(),mCtx);
        mLazyViewPagerAdapter.setOnItemCallBackLisener(new LazyViewPagerAdapter.OnLazyPagerAdapterCallBack() {

            @Override
            public PageFragment getItem(int position) {
                return LazyViewPagerFragment.this.getItem(position);
            }

            @Override
            public int getCount() {
                return LazyViewPagerFragment.this.getCount();
            }
        });
        mViewPager.setAdapter(mLazyViewPagerAdapter);
    }

    /**
     * 寻求当前Fragment的size.
     * @return
     */
    public abstract int getCount();

    /**
     * 获取又position指定的Fragment.
     * @param position
     * @return
     */
    public abstract PageFragment getItem(int position);

    /**
     * 获取每个界面所需的颜色.
     * @return
     */
    public abstract int getColor(int position);

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        position %= getCount();
        int nextColorPosition = position + 1;
        if (nextColorPosition >= getCount()) {
            nextColorPosition %= getCount();
        }
        if (position < (mViewPager.getAdapter().getCount() - 1)) {
            mViewPager.setBackgroundColor((Integer) mArgbEvaluator.evaluate(positionOffset, getColor(position), getColor(nextColorPosition)));
        } else if (position == getCount() - 1) {
            mViewPager.setBackgroundColor(getColor(position));
            if (getView() != null) {
                getView().setAlpha(1 - positionOffset);
            }
        }
    }

    @Override
    public void onPageSelected(int position) {
        //--do nothing
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //-do nothing
    }

    private class FragmentTransformer implements ViewPager.PageTransformer {

        public void transformPage(View view, float position) {
            Object obj = view.getTag(R.id.viewpager);
            if (obj instanceof PageFragment) {
                ((PageFragment) obj).transformPage(view, position);
            }
        }
    }
}
