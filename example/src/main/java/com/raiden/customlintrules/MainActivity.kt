package com.raiden.customlintrules

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    //Test Init
    init{
        Log.i("HELLO", "WORLD")
        Log.i("HELLO", "WORLD")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun testRuleForCatch() {
        //RIGHT
        try {
            Log.i("HELLO", "WORLD")
        } catch (e: Exception) {
            Log.i("HELLO", "WORLD")
        }
        //WRONG
        try {
            Log.i("HELLO", "WORLD")
            Log.i("HELLO", "WORLD")
        } catch (e: Exception) {
            Log.i("HELLO", "WORLD")
            Log.i("HELLO", "WORLD")
        }
    }

    private fun testRuleForForLoop() {
        //RIGHT
        for (i in 0..100) {
            Log.i("HELLO", "WORLD")
        }
        //WRONG
        for (i in 0..100) {
            Log.i("HELLO", "WORLD")
            Log.i("HELLO", "WORLD")
            Log.i("HELLO", "WORLD")
            Log.i("HELLO", "WORLD")
        }
    }

    private fun testRuleForForEachLoop() {
        //RIGHT
        listOf(1, 2, 3).forEach {
            Log.i("HELLO", "WORLD")
        }
        //WRONG
        listOf(1, 2, 3).forEach {
            Log.i("HELLO", "WORLD")
            Log.i("HELLO", "WORLD")
        }
    }
}
