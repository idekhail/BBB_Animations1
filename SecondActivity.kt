package com.bbb_idekhail.bbb_animation1

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var address2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        address2 = findViewById(R.id.address2)
        val username = findViewById<EditText>(R.id.username)
        val zoomIn = findViewById<Button>(R.id.zoomIn)
        val slideR = findViewById<Button>(R.id.slideR)
        val image2 = findViewById<ImageView>(R.id.image2)

        val context = this
        zoomIn.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.zoomin)
            // Start the animation on the ImageView
            image2.startAnimation(animation)
        }

        slideR.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.slideright)
            // Start the animation on the ImageView
            image2.startAnimation(animation)
        }

        username.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                val animation = AnimationUtils.loadAnimation(context, R.anim.zoomin)
                username.startAnimation(animation)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int ) {
            }

        })
    }
    override fun onStart() {
        super.onStart()
        val animation = AnimationUtils.loadAnimation(this, R.anim.blink)
        address2.startAnimation(animation)
    }
}