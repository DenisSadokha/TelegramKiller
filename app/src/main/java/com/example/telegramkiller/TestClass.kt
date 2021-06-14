package com.example.telegramkiller

import android.os.Bundle
import android.widget.TextView

import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class TestClass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView: TextView = findViewById(R.id.test)
        textView.text = "hello"



    }
}
