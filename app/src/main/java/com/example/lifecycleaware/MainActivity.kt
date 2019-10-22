package com.example.lifecycleaware

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG,"Owner onCreate")
        lifecycle.addObserver(MainActivityObserver())
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"Owner onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"Owner onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"Owner onPause")
    }

    companion object{
        val TAG : String = MainActivity::class.java.simpleName
    }
}
