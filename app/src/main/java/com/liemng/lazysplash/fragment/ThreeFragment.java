package com.liemng.lazysplash.fragment;

import com.liemng.lazysplash.R;
import com.liemng.library.anim.TranslationAnim;
import com.liemng.library.fragment.PageFragment;
import com.liemng.library.anim.LayersHolder.AnimType;

/**
 * Created by liemng on 16-5-13.
 */
public class ThreeFragment extends PageFragment {
    private static final String TAG = ThreeFragment.class.getSimpleName();

    @Override
    public int fetchResourceId() {
        return R.layout.three_layout;
    }

    @Override
    public TranslationAnim[] getAnimList() {
        return new TranslationAnim[]{
                new TranslationAnim(R.id.img_three, false, 3, AnimType.ROTATION)
        };
    }
}
