package com.example.workapp.fragments.punch_press

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.workapp.R

class PunchFragment : Fragment() {

    private lateinit var punchViewModel: PunchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        punchViewModel =
            ViewModelProviders.of(this).get(PunchViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        punchViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}