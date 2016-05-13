package com.liemng.library.anim;

import android.view.View;

public class LayersHolder {
	TranslationAnim[] transformItems;

	public LayersHolder(View view, TranslationAnim[] transformItems) {
		this.transformItems = transformItems;

		for (TranslationAnim transformItem : transformItems) {
			transformItem.setView(view.findViewById(transformItem.getViewId()));
		}
	}


	public void transformPage(int pageWidth, float position) {
		for (TranslationAnim transformItem : transformItems) {
			float translationX = (position) * (pageWidth / transformItem.getShiftCoefficient());

			transformItem.getView().setTranslationX(transformItem.isReverseShift() ? -translationX : translationX);
		}
	}
}
