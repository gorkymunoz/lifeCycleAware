package com.example.lifecycleaware

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainActivityViewModel: ViewModel(){

    private lateinit var myRandomNumber: MutableLiveData<String>

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG,"Viewmodel destroyed")
    }

    fun getNumber():MutableLiveData<String>{

        Log.d(TAG,"Get number")

        if(!::myRandomNumber.isInitialized){
            myRandomNumber = MutableLiveData()
            this.createNumber()
        }
        return myRandomNumber
    }

    fun createNumber() {
        Log.d(TAG,"Create number")

        val random = Random()
        myRandomNumber.value = "Number: ${(random.nextInt(10-1)+1)}"
    }


    companion object{
        val TAG: String = MainActivityViewModel::class.java.simpleName
    }
}