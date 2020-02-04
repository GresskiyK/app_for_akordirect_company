package com.example.workapp.fragments.bending_machines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BendingViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "bending"
    }
    val text: LiveData<String> = _text
}