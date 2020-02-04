package com.example.workapp.fragments.lasers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LasersViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "lasers"
    }
    val text: LiveData<String> = _text
}