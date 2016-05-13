package com.liemng.library.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liemng.library.R;
import com.liemng.library.anim.LayersHolder;
import com.liemng.library.anim.TranslationAnim;

/**
 * Created by limeng on 16-5-13.
 */
public abstract class PageFragment extends Fragment{
    public static final String TAG = PageFragment.class.getSimpleName();
    protected LayersHolder layersHolder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(fetchResourceId(), container, false);
        layersHolder = new LayersHolder(view, getAnimList());
        view.setTag(R.id.viewpager, this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layersHolder = new LayersHolder(view, getAnimList());
    }

    /**
     * fetch layout id.
     * @return
     */
    public abstract int fetchResourceId();

    public abstract TranslationAnim[] getAnimList();

    /**
     * do anim.
     * @param view
     * @param position
     */
    public void transformPage(View view, float position){
        layersHolder.transformPage(view.getWidth(), position);
    }
}
