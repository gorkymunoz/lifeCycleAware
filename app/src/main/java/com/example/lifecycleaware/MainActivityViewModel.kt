package com.example.lifecycleaware

import android.util.Log
import androidx.lifecycle.ViewModel
import java.util.*

class MainActivityViewModel: ViewModel(){

    private lateinit var myRandomNumber:String

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG,"Viewmodel destroyed")
    }

    fun getNumber():String{

        Log.d(TAG,"Get number")

        if(!::myRandomNumber.isInitialized){
            this.createNumber()
        }
        return myRandomNumber
    }

    private fun createNumber() {
        Log.d(TAG,"Create number")

        val random = Random()
        myRandomNumber = "Number: ${(random.nextInt(10-1)+1)}"
    }


    companion object{
        val TAG: String = MainActivityViewModel::class.java.simpleName
    }
}