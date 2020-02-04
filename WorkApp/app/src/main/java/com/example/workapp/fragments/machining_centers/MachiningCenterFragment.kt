package com.example.workapp.fragments.machining_centers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.workapp.R

class MachiningCenterFragment : Fragment() {

    private lateinit var machiningCenterViewModel: MachiningCenterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        machiningCenterViewModel =
            ViewModelProviders.of(this).get(MachiningCenterViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_machining_center, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        machiningCenterViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}