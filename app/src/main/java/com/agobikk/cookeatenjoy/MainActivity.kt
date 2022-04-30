package com.agobikk.cookeatenjoy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.agobikk.cookeatenjoy.util.MAIN

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MAIN = this
    }
}