package com.example.alarmoficial

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AlarmOnActivity : AppCompatActivity() {
    private lateinit var mp: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_on)

        mp = MediaPlayer.create(applicationContext, R.raw.alarm_clock)
        mp.isLooping = true
        mp.start()

        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            mp.stop()
            mp.release()
            finish()
        }
    }
}
