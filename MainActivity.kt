package com.bbb_idekhail.bbb_animation1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declare variables for ImageView and Buttons
    private lateinit var imageView: ImageView
    private lateinit var blink: Button
    private lateinit var rotate: Button
    private lateinit var fade: Button
    private lateinit var move: Button
    private lateinit var slide: Button
    private lateinit var zoom: Button
    private lateinit var stop: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the ImageView and Buttons using their IDs
        imageView = findViewById(R.id.imageview)
        blink = findViewById(R.id.blink)
        rotate = findViewById(R.id.rotate)
        fade = findViewById(R.id.fade)
        move = findViewById(R.id.move)
        slide = findViewById(R.id.slide)
        zoom = findViewById(R.id.zoom)
        stop = findViewById(R.id.stop)

        val next = findViewById<Button>(R.id.next)
        next.setOnClickListener {
            val i = Intent(this, SecondActivity::class.java)
            startActivity(i)
        }

        // Set up click listeners for each button to start corresponding animations
        createAnimation(blink, R.anim.blink)
        createAnimation(rotate, R.anim.rotate)
        createAnimation(fade, R.anim.fade)
        createAnimation(move, R.anim.move)
        createAnimation(slide, R.anim.slide)
        createAnimation(zoom, R.anim.zoomin)

        // Set up click listener for stop button to clear any ongoing animation
        stop.setOnClickListener {
            imageView.clearAnimation()
        }
    }

    // Function to set up an animation for a given view and animation resource ID
    private fun createAnimation(view: View, animResId: Int) {
        view.setOnClickListener {
            // Load the animation from the specified resource ID
            val animation = AnimationUtils.loadAnimation(this, animResId)
            // Start the animation on the ImageView
            imageView.startAnimation(animation)
        }
    }
    override fun onResume() {
        super.onResume()
        val animation = AnimationUtils.loadAnimation(this, R.anim.slide)
        imageView.startAnimation(animation)

    }
}