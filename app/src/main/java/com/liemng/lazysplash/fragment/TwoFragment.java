package com.liemng.lazysplash.fragment;

import com.liemng.lazysplash.R;
import com.liemng.library.anim.TranslationAnim;
import com.liemng.library.fragment.PageFragment;

/**
 * Created by liemng on 16-5-13.
 */
public class TwoFragment extends PageFragment {
    private static final String TAG = TwoFragment.class.getSimpleName();

    @Override
    public int fetchResourceId() {
        return R.layout.two_layout;
    }

    @Override
    public TranslationAnim[] getAnimList() {
        return new TranslationAnim[]{
                new TranslationAnim(R.id.img_two, true, 3)
        };
    }

}
