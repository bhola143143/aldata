package com.example.a07demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a07demo.detail.Relative

class ListNameAdapter(private val mList: List<Relative>) :
    RecyclerView.Adapter<ListNameAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_name_data, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = mList[position]
        holder.textView.text = itemsViewModel.userFirstName
        holder.textView1.text = itemsViewModel.userFullName
        holder.textView2.text = itemsViewModel.userRealation
        holder.textView3.text = itemsViewModel.userContact


        val shortName =
            itemsViewModel.userFirstName?.first().toString() + itemsViewModel.userLastName?.first()
                .toString()
        holder.textView.text = shortName


    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val textView: TextView = itemView.findViewById(R.id.txtFirstLast)
        val textView1: TextView = itemView.findViewById(R.id.txtName)
        val textView2: TextView = itemView.findViewById(R.id.txtSpouse)
        val textView3: TextView = itemView.findViewById(R.id.txtNumber)


    }
}