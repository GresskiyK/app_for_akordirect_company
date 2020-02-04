@file:Suppress("DEPRECATION")

package com.example.workapp.fragments.lathes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.workapp.R

class LathersFragment : Fragment() {

    private lateinit var lathersViewModel: LathersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lathersViewModel =
            ViewModelProviders.of(this).get(LathersViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_lather, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        lathersViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}