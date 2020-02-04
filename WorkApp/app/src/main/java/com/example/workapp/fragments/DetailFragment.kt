package com.example.workapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.workapp.ItemOfGrid
import com.example.workapp.MainActivity
import com.example.workapp.R

class DetailFragment(val item:ItemOfGrid):Fragment() {
    lateinit var textViewDetail:TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.detail_view, container, false)
        textViewDetail=view.findViewById(R.id.textViewDetail)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        textViewDetail.text=item.model
        return view
    }
}