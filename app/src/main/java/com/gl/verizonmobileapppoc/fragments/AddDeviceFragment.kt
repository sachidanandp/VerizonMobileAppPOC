package com.gl.verizonmobileapppoc.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.gl.verizonmobileapppoc.GroupItemClickListener
import com.gl.verizonmobileapppoc.R
import com.gl.verizonmobileapppoc.adapter.DeviceListAdapter
import com.gl.verizonmobileapppoc.data.device.DeviceData
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AddDeviceFragment : Fragment(), GroupItemClickListener {

    private lateinit var list: ArrayList<DeviceData>
    private lateinit var adapter: DeviceListAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_device, container, false)

        val addDevice = view.findViewById<FloatingActionButton>(R.id.add_device)
        addDevice.setOnClickListener {
            val data = DeviceData()
            data.deviceName = "Group ${list.size + 1}"
            list.add(data)
            adapter.notifyDataSetChanged()
        }

        val back = view.findViewById<ConstraintLayout>(R.id.cl_back_container).apply {
            this.setOnClickListener{
                requireActivity().supportFragmentManager.popBackStack()
            }
        }

        list = ArrayList()
        for (i in 1..5) {
            val data = DeviceData()
            data.deviceName = "Device $i"
            list.add(data)
        }

        adapter = DeviceListAdapter(list, this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.adapter = adapter


        return view.rootView
    }

    override fun onItemClick(pos: Int) {
        Toast.makeText(requireActivity(), "${list[pos].deviceName}", Toast.LENGTH_SHORT).show()
    }

}