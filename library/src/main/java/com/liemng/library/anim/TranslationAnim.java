package com.liemng.library.anim;

import android.view.View;
import com.liemng.library.anim.LayersHolder.AnimType;

/**
 * Created by limeng on 16-5-13.
 */
public class TranslationAnim {

    private View view;
    private boolean isReverseShift;
    private int viewId;
    private float shiftCoefficient;
    private AnimType animType;

    public TranslationAnim(int viewId, boolean isReverseShift, float shiftCoefficient, AnimType animType){
        this.isReverseShift = isReverseShift;
        this.viewId = viewId;
        this.shiftCoefficient = shiftCoefficient;
        this.animType = animType;
    }

    public AnimType getAnimType() {
        return animType;
    }

    public void setAnimType(AnimType animType) {
        this.animType = animType;
    }

    public float getShiftCoefficient() {
        return shiftCoefficient;
    }

    public void setShiftCoefficient(int shiftCoefficient) {
        this.shiftCoefficient = shiftCoefficient;
    }

    public boolean isReverseShift() {
        return isReverseShift;
    }

    public void setIsReverseShift(boolean isReverseShift) {
        this.isReverseShift = isReverseShift;
    }

    public int getViewId() {
        return viewId;
    }

    public void setViewId(int viewId) {
        this.viewId = viewId;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
