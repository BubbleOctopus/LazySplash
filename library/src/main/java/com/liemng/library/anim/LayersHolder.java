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
			AnimType animType = transformItem.getAnimType();
			switch (animType){
				case TRANSITION:
					float translationXY = (position) * (pageWidth / transformItem.getShiftCoefficient());
					transformItem.getView().setTranslationX(transformItem.isReverseShift() ? -translationXY : translationXY);
					transformItem.getView().setTranslationY(transformItem.isReverseShift() ? -translationXY : translationXY);
					break;
				case TRANSITION_X:
					float translationX = (position) * (pageWidth / transformItem.getShiftCoefficient());
					transformItem.getView().setTranslationX(transformItem.isReverseShift() ? -translationX : translationX);
					break;
				case TRANSITION_Y:
					float translationY = (position) * (pageWidth / transformItem.getShiftCoefficient());
					transformItem.getView().setTranslationY(transformItem.isReverseShift() ? -translationY : translationY);
					break;
				case TRANSITION_Z:
					float translationZ = (position) * (pageWidth / transformItem.getShiftCoefficient());
					transformItem.getView().setTranslationZ(transformItem.isReverseShift() ? -translationZ : translationZ);
					break;
				case ROTATION:
					float rotation = (position) * (pageWidth / transformItem.getShiftCoefficient());
					transformItem.getView().setRotation(transformItem.isReverseShift() ? -rotation : rotation);
					break;
				case ROTATION_X:
					float rotationX = (position) * (pageWidth / transformItem.getShiftCoefficient());
					transformItem.getView().setRotationX(transformItem.isReverseShift() ? -rotationX : rotationX);
					break;
				case ROTATION_Y:
					float rotationY = (position) * (pageWidth / transformItem.getShiftCoefficient());
					transformItem.getView().setRotationY(transformItem.isReverseShift() ? -rotationY : rotationY);
					break;
				default:
					break;
			}
		}
	}

	/**
	 * Add enum anim type.
	 */
	public enum AnimType {
		TRANSITION,
		TRANSITION_X,
		TRANSITION_Y,
		TRANSITION_Z,
		ROTATION,
		ROTATION_X,
		ROTATION_Y
	}
}
