package com.example.myapplication.loginapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val userLiveData=MutableLiveData<String>("")
    val passLiveData=MutableLiveData<String>("")

    fun updateUserPass(user:String,pass:String){
        userLiveData.value=user
        passLiveData.value=pass
    }
}