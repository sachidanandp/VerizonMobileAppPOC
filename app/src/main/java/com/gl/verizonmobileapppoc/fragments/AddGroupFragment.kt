package com.gl.verizonmobileapppoc.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gl.verizonmobileapppoc.R

class AddGroupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =
        return inflater.inflate(R.layout.fragment_add_group, container, false)
    }

}