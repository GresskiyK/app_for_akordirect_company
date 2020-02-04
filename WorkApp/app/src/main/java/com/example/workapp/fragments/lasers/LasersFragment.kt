package com.example.workapp.fragments.lasers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.workapp.R

class LasersFragment : Fragment() {

    private lateinit var lasersViewModel: LasersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lasersViewModel =
            ViewModelProviders.of(this).get(LasersViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_share, container, false)
        val textView: TextView = root.findViewById(R.id.text_share)
        lasersViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}