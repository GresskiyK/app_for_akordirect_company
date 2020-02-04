package com.example.workapp.fragments.machining_centers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MachiningCenterViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "machining"
    }
    val text: LiveData<String> = _text
}