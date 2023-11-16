package com.example.lambgame
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private var lampOn = false
    private var lampNum = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var lamp = findViewById<ImageView>(R.id.lamp1)
        val image = findViewById<ImageView>(R.id.image)
        val button = findViewById<Button>(R.id.btn)
        image.setOnLongClickListener {
            val mediaPlayer = MediaPlayer.create(this, R.raw.broke)
            image.setImageResource(R.drawable.lamp_cr)
            lamp.setImageResource(R.drawable.lamp_cr)
            mediaPlayer.start()
            if (lampNum == 3){
                button.visibility = View.VISIBLE
            }
            lampNum++
            lampOn = false
            when(lampNum)
            {
                1 -> lamp = findViewById(R.id.lamp1)
                2 -> lamp = findViewById(R.id.lamp2)
                3 -> lamp = findViewById(R.id.lamp3)

                else -> lamp = findViewById(R.id.lamp1)
            }
            true
        }
    }
    fun onClickLamp(view:View)
    {
        val mediaPlayer = MediaPlayer.create(this,R.raw.click)
        val imageView = view as ImageView
        var lamp = findViewById<ImageView>(R.id.lamp1)
        when(lampNum)
        {
            1 -> lamp = findViewById(R.id.lamp1)
            2 -> lamp = findViewById(R.id.lamp2)
            3 -> lamp = findViewById(R.id.lamp3)

        }
        if (!lampOn && lampNum != 4)
        {
            imageView.setImageResource(R.drawable.lamp_on)
            lamp.setImageResource(R.drawable.lamp_on)

            lampOn = !lampOn
            mediaPlayer.start()
        }
        else if (lampOn && lampNum != 4)
        {
            imageView.setImageResource(R.drawable.lamp_of)
            lamp.setImageResource(R.drawable.lamp_of)

            lampOn = !lampOn
            mediaPlayer.start()
        }
    }
    fun onBtnClick(view:View)
    {
        val imageView = findViewById<ImageView>(R.id.image)
        val button = view as Button
        imageView.setImageResource(R.drawable.lamp_of)
        findViewById<ImageView>(R.id.lamp1).setImageResource(R.drawable.lamp_of)
        findViewById<ImageView>(R.id.lamp2).setImageResource(R.drawable.lamp_of)
        findViewById<ImageView>(R.id.lamp3).setImageResource(R.drawable.lamp_of)

        lampOn = false
        lampNum = 1
        button.visibility = View.INVISIBLE
    }
}