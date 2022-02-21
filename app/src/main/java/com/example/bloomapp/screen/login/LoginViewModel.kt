package com.example.bloomapp.screen.login

import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel() : ViewModel() {
    private val _emailAddress: MutableLiveData<String> = MutableLiveData("")
    val emailAddress: MutableLiveData<String> = _emailAddress

    private val _password: MutableLiveData<String> = MutableLiveData("")
    val password: MutableLiveData<String> = _password


    fun onEmailAddressChange(value: String){
        _emailAddress.value = value
    }

    fun onPasswordChange(value: String){
        _password.value = value
    }
}