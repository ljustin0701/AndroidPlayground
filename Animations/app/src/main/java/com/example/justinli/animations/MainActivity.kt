package com.example.justinli.animations

import android.animation.*
import android.graphics.drawable.Animatable
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.ViewPropertyAnimator
import android.view.animation.AccelerateInterpolator
import android.widget.ImageView
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    lateinit var root: ConstraintLayout
    lateinit var arrow: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        root = findViewById(R.id.root)
        arrow = findViewById(R.id.arrow)
    }

    override fun onResume() {
        super.onResume()
//        animateSet()
//        viewPropertyAnimate()
//        bounce()
        checkMark()
    }

    private fun animateSet() {
        val displayMetrics = resources.displayMetrics
        val animateToY = -round(displayMetrics.heightPixels.toFloat())
        val objectAnimator = ObjectAnimator.ofFloat(arrow, "translationY", 0f, animateToY)
        val objectAnimator2 = ObjectAnimator.ofObject(root,
                "backgroundColor",
                ArgbEvaluator(),
                ContextCompat.getColor(this, android.R.color.black),
                ContextCompat.getColor(this, android.R.color.holo_blue_light))

        objectAnimator.interpolator = AccelerateInterpolator()
        objectAnimator.repeatCount = ObjectAnimator.INFINITE
        objectAnimator.repeatMode = ObjectAnimator.REVERSE
        objectAnimator2.repeatCount = ObjectAnimator.INFINITE
        objectAnimator2.repeatMode = ObjectAnimator.REVERSE

        val animSet = AnimatorSet()
        animSet.play(objectAnimator).with(objectAnimator2)
        animSet.duration = 1000
        animSet.start()
    }

    private fun viewPropertyAnimate() {
        val animation: ViewPropertyAnimator = arrow.animate().setDuration(2000).rotation(360f)
        animation.start()
    }

    private fun bounce() {
        val animator: Animator = AnimatorInflater.loadAnimator(this, R.animator.bounce)
        animator.duration = 300

        arrow.setOnClickListener {
            animator.setTarget(it)
            animator.start()
        }
    }

    private fun checkMark() {
        val animatable: Animatable = arrow.drawable as Animatable

        arrow.setOnClickListener {
            animatable.start()
        }
    }

}
