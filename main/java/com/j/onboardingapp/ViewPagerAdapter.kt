package com.j.onboardingapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class ViewPagerAdapter(val context:Context) :PagerAdapter(){

    var layoutInflater:LayoutInflater?=null

    // arrays of image,head,description
    val imgArray = arrayOf(
        R.drawable.car,
        R.drawable.appreciate,
        R.drawable.gifts,
        R.drawable.remainder
    )

    val headArray=arrayOf(
        "Heading 1",
        "Heading 2",
        "Heading 3",
        "Heading 4"
    )

    val arrayDescription= arrayOf(
        "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...",
        "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...",
        "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...",
        "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."
        )
    override fun getCount(): Int {
        return headArray.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view ===`object` as RelativeLayout

    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
        val view=layoutInflater !!.inflate(R.layout.slider,container,false)

        val img=view.findViewById<ImageView>(R.id.image)
        val txt_head=view.findViewById<TextView>(R.id.txt_head)
        val txt_description=view.findViewById<TextView>(R.id.txt_description)

        img.setImageResource(imgArray[position])
        txt_head.text=headArray[position]
        txt_description.text=arrayDescription[position]

        container.addView(view)
        return view
    }

    override fun destroyItem(container:ViewGroup,position:Int,`object`:Any) {
        container.removeView(`object` as RelativeLayout)
    }
}