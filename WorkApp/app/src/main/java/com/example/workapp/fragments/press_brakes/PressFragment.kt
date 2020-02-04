package com.example.workapp.fragments.press_brakes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.workapp.R

class PressFragment : Fragment() {

    private lateinit var pressViewModel: PressViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pressViewModel =
            ViewModelProviders.of(this).get(PressViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_press, container, false)
        val textView: TextView = root.findViewById(R.id.text_tools)
        pressViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}