package com.gl.verizonmobileapppoc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gl.verizonmobileapppoc.GroupItemClickListener
import com.gl.verizonmobileapppoc.R
import com.gl.verizonmobileapppoc.data.device.DeviceData

class DeviceListAdapter( private val mList: List<DeviceData>,
private val listener: GroupItemClickListener
) :
RecyclerView.Adapter<DeviceListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.device_card_view_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = mList[position]
        holder.groupName.text = itemsViewModel.deviceName
        holder.words.text = itemsViewModel.deviceName?.first().toString()
        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val groupName: TextView = itemView.findViewById(R.id.group_name)
        val words: TextView = itemView.findViewById(R.id.words)
    }

}