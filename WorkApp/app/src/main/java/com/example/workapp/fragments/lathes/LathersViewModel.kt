package com.example.workapp.fragments.lathes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LathersViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "lathers"
    }
    val text: LiveData<String> = _text
}