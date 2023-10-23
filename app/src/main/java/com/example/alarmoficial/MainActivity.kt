package com.example.alarmoficial

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.FirebaseApp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseApp.initializeApp(this);

        val button: Button = findViewById(R.id.button)
        val editText: EditText = findViewById(R.id.editTextNumber)

        button.setOnClickListener{
            var sec = editText.text.toString().toInt()
            var i = Intent(applicationContext, MyBroadcastReceiver::class.java)
            var p1 = PendingIntent.getBroadcast(applicationContext, 111,i,PendingIntent.FLAG_IMMUTABLE)
            var am : AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            am.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis() + (sec*1000),p1)
            Toast.makeText(applicationContext,"O alarme irá tocar em $sec segundos.", Toast.LENGTH_LONG).show()
        }
    }
}