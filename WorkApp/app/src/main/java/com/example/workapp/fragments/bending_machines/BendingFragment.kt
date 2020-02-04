package com.example.workapp.fragments.bending_machines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.workapp.R

class BendingFragment : Fragment() {

    private lateinit var bendingViewModel: BendingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bendingViewModel =
            ViewModelProviders.of(this).get(BendingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_bending, container, false)
        val textView: TextView = root.findViewById(R.id.text_send)
        bendingViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}