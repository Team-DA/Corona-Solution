package com.golddog.mask_location.ui.activity

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.golddog.mask_location.R
import kotlinx.android.synthetic.main.activity_main.*
import net.daum.mf.map.api.MapView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var isFabOpen = false
    private val fabOpen: Animation by lazy {
        AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.fab_open
        )
    }
    private val fabClose: Animation by lazy {
        AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.fab_close
        )
    }
    private val fabRotateForward by lazy {
        AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.rotate_forward
        )
    }
    private val fabRotateBackward: Animation by lazy {
        AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.rotate_backward
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab_main_main.setOnClickListener(this)
        fab_help_main.setOnClickListener(this)
        fab_1339call_main.setOnClickListener(this)
        fab_corona_manual_main.setOnClickListener(this)
        fab_corona_now_main.setOnClickListener(this)

        val mapView = MapView(this)
        val mapViewContainer = findViewById<ViewGroup>(R.id.map_view)
        mapViewContainer.addView(mapView)
    }

    override fun onClick(view: View?) {
        when (view) {
            fab_main_main -> {
                fabAnim()
                Toast.makeText(this, "fab_1", Toast.LENGTH_LONG).show()
            }
            fab_help_main -> {
                fabAnim()
                Toast.makeText(this, "fab_2", Toast.LENGTH_LONG).show()
            }
            fab_1339call_main -> {
                fabAnim()
                Toast.makeText(this, "fab_3", Toast.LENGTH_LONG).show()
            }
            fab_corona_manual_main -> {
                fabAnim()
                Toast.makeText(this, "fab_4", Toast.LENGTH_LONG).show()
            }
            fab_corona_now_main -> {
                fabAnim()
                Toast.makeText(this, "fab_5", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun fabAnim() {
        if (isFabOpen) {
            fab_main_main.startAnimation(fabRotateBackward)
            fab_help_main.startAnimation(fabClose)
            fab_1339call_main.startAnimation(fabClose)
            fab_corona_manual_main.startAnimation(fabClose)
            fab_corona_now_main.startAnimation(fabClose)
            fab_help_main.isClickable = false
            fab_1339call_main.isClickable = false
            fab_corona_manual_main.isClickable = false
            fab_corona_now_main.isClickable = false
            isFabOpen = false
        } else {
            fab_main_main.startAnimation(fabRotateForward)
            fab_help_main.startAnimation(fabOpen)
            fab_1339call_main.startAnimation(fabOpen)
            fab_corona_manual_main.startAnimation(fabOpen)
            fab_corona_now_main.startAnimation(fabOpen)
            fab_help_main.isClickable = true
            fab_1339call_main.isClickable = true
            fab_corona_manual_main.isClickable = true
            fab_corona_now_main.isClickable = true
            isFabOpen = true
        }
    }
}