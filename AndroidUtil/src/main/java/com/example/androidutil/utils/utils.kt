package com.example.androidutil.utils

import android.view.MotionEvent
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

object AppUtils {


    fun TextView.onDrawableClicked(
        mv: MotionEvent?,
        drawablePosition: DrawablePosition,
        onClick: () -> Unit
    ) {

        if (mv?.action == MotionEvent.ACTION_DOWN) {
            when (drawablePosition) {

                DrawablePosition.RIGHT ->
                    if (mv.rawX >= (right - compoundDrawables[2].bounds.width()))
                        onClick.invoke()

                DrawablePosition.LEFT ->
                    if (mv.rawX <= compoundDrawables[0].bounds.width())
                        onClick.invoke()


//                DrawablePosition.TOP -> {
//                    if (mv.rawY <= (top - compoundDrawables[1].bounds.width())) {
//
//                    }
//                }

            }
        }


    }

    fun ImageView.load(url: String) {
        with(Glide.with(this)) {
            load(url).into(this@load)
        }
    }

    fun ImageView.loadCenterCrop(url: String) {
        with(Glide.with(this)) {
            load(url).circleCrop().into(this@loadCenterCrop)
        }
    }

    fun ImageView.loadRoundCorner(url: String, cornerRadius: Int) {
        with(Glide.with(this)) {
            load(url).transform(RoundedCorners(cornerRadius))
                .into(this@loadRoundCorner)
        }
    }


}

enum class DrawablePosition {
    RIGHT,
    LEFT,
//    TOP,
//    BOTTOM
}

