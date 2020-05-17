package com.codedix.distantiaui.utils

import android.R
import android.animation.ObjectAnimator
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnCancel
import androidx.core.animation.doOnEnd
import com.codedix.distantiaui.EmptyCallback
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.math.hypot


class ViewUtils {

    companion object {

        fun centerRevealAnimation(view: View, duration: Long, callback: EmptyCallback) {
            val cx = view.width / 2
            val cy = view.height / 2
            val finalRadius = hypot(cx.toDouble(), cy.toDouble()).toFloat()

            val anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, 0f, finalRadius)
            anim.duration = duration
            anim.interpolator = DecelerateInterpolator()

            view.visibility = View.VISIBLE
            anim.start()

            anim.doOnEnd {
                callback.callback()
            }
        }

        fun revealAnimation(view: View, fab: FloatingActionButton, duration: Long, callback: EmptyCallback) {
            val cx = (fab.left + fab.right) / 2
            val cy = (fab.top + fab.bottom) / 2
            val finalRadius = cy.coerceAtLeast(view.height)

            val anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, 60f, finalRadius.toFloat())
            anim.duration = duration
            anim.interpolator = DecelerateInterpolator()

            view.alpha = 1f
            view.visibility = View.VISIBLE
            anim.start()

            anim.doOnEnd {
                System.err.println("end")
                callback.callback()
            }
        }

        fun fadeInAnimation(view: View, duration: Long, callback: EmptyCallback) {
            val fadeIn = AlphaAnimation(0f, 1f)
            fadeIn.interpolator = DecelerateInterpolator()
            fadeIn.duration = duration

            val anim = AnimationSet(false)
            anim.addAnimation(fadeIn)
            view.animation = anim

            view.visibility = View.VISIBLE
            anim.start()

            anim.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(p0: Animation?) {}
                override fun onAnimationRepeat(p0: Animation?) {}
                override fun onAnimationEnd(p0: Animation?) {
                    callback.callback()
                }
            })
        }

        fun fadeOutAnimation(view: View, duration: Long, callback: EmptyCallback) {
            val anim = ObjectAnimator.ofFloat(view, View.ALPHA, 1f, 0f).setDuration(duration)
            anim.start()
            anim.doOnEnd {
                callback.callback()
            }
        }

        fun activeView(view: View) {
            view.isEnabled = true
        }

        fun disactiveView(view: View) {
            view.isEnabled = false
        }
/*
        fun rotateLeftAnimation(view: View, context: Context) {
            val anim = AnimationUtils.loadAnimation(context, R.anim.rotate_left)
            anim.interpolator = AccelerateDecelerateInterpolator()
            view.animation = anim
            anim.start()
        }

        fun rotateRightAnimation(view: View, context: Context) {
            val anim = AnimationUtils.loadAnimation(context, R.anim.rotate_right)
            anim.interpolator = AccelerateDecelerateInterpolator()
            view.animation = anim
            anim.start()
        }

 */
    }
}