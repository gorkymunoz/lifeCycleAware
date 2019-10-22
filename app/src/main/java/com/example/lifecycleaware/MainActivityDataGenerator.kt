package com.example.lifecycleaware

import android.util.Log
import androidx.lifecycle.ViewModel
import java.util.*

class MainActivityDataGenerator: ViewModel(){

    private lateinit var myRandomNumber:String

    fun getNumber():String{

        Log.d(TAG,"Get number")

        if(!::myRandomNumber.isInitialized){
            this.createNumber()
        }
        return myRandomNumber
    }

    private fun createNumber() {
        Log.d(TAG,"Get number")

        val random = Random()
        myRandomNumber = "Number: ${(random.nextInt(10-1)+1)}"
    }


    companion object{
        val TAG: String = MainActivityDataGenerator::class.java.simpleName
    }
}