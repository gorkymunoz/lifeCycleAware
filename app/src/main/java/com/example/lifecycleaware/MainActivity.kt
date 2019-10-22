package com.example.lifecycleaware

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var model: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model = ViewModelProviders.of(this)
            .get(MainActivityViewModel::class.java)

        val myRandomNumber = model.getNumber()

        myRandomNumber.observe(this,Observer<String>{ number ->
            tvNumber.text = number
            Log.d(TAG, "Random Number Set")
        })

        bRandom.setOnClickListener {
            model.createNumber()
        }
    }

    companion object{
        val TAG : String = MainActivity::class.java.simpleName
    }
}
