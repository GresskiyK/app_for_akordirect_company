package com.example.workapp.fragments.punch_press

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PunchViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "punch"
    }
    val text: LiveData<String> = _text
}