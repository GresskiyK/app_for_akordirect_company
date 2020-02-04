package com.example.workapp.fragments.press_brakes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PressViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "press"
    }
    val text: LiveData<String> = _text
}