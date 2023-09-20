package com.gl.verizonmobileapppoc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.gl.verizonmobileapppoc.adapter.GroupListAdapter
import com.gl.verizonmobileapppoc.data.group.GroupData
import com.gl.verizonmobileapppoc.fragments.AddDeviceFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), GroupItemClickListener {
    private lateinit var list: ArrayList<GroupData>

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list = ArrayList()
        for (i in 1..10) {
            val data = GroupData()
            data.groupName = "Group $i"
            list.add(data)
        }

        val adapter = GroupListAdapter(list, this)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.adapter = adapter

        val add = findViewById<FloatingActionButton>(R.id.add)
        add.setOnClickListener {
            val data = GroupData()
            data.groupName = "Group ${list.size + 1}"
            list.add(data)
            adapter.notifyDataSetChanged()
        }

    }

    override fun onItemClick(pos: Int) {
        val data = list[pos]
        val fragment = AddDeviceFragment()
        val bundle = Bundle()
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.container, fragment)
            .commit()
        Toast.makeText(this, "${data.groupName}", Toast.LENGTH_SHORT).show()
    }

}