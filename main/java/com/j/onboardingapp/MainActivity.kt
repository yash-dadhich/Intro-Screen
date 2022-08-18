package com.j.onboardingapp

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val springDotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)
//        val button = findViewById<Button>(R.id.btn_continue)
        val skip = findViewById<TextView>(R.id.txt_skip)
        val txt_continue = findViewById<TextView>(R.id.txt_continue)


        val relativeLayout = findViewById<RelativeLayout>(R.id.layout1)
        val animationDrawable = relativeLayout.background as AnimationDrawable
        addAnimation(animationDrawable)

        viewPager = findViewById(R.id.viewpager)
        viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter
        springDotsIndicator.attachTo(viewPager)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if (position == 0) {
                    relativeLayout.setBackgroundResource(R.drawable.gradient_animation123)
                    val animationDrawable = relativeLayout.background as AnimationDrawable
                    addAnimation(animationDrawable)
                    txt_continue.visibility = View.INVISIBLE
                    skip.visibility = View.VISIBLE

                }
                if (position == 1) {
                    relativeLayout.setBackgroundResource(R.drawable.gradient_animation456)
                    val animationDrawable = relativeLayout.background as AnimationDrawable
                    addAnimation(animationDrawable)
                    txt_continue.visibility = View.INVISIBLE
                    skip.visibility = View.VISIBLE

                }
                if (position == 2) {
                    relativeLayout.setBackgroundResource(R.drawable.gradient_animation789)
                    val animationDrawable = relativeLayout.background as AnimationDrawable
                    addAnimation(animationDrawable)
                    txt_continue.visibility = View.INVISIBLE
                    skip.visibility = View.VISIBLE
                }
                if (position == 3) {
                    relativeLayout.setBackgroundResource(R.drawable.gradient_animationabc)
                    val animationDrawable = relativeLayout.background as AnimationDrawable
                    addAnimation(animationDrawable)

                    txt_continue.visibility = View.VISIBLE

                    skip.visibility = View.INVISIBLE
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }


        })
    }
    fun addAnimation(animationDrawable:AnimationDrawable){
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(1000)
        animationDrawable.start()
    }
}
