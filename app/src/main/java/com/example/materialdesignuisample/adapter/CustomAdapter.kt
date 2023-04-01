package com.example.materialdesignuisample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.materialdesignuisample.R
import com.example.materialdesignuisample.data.Crypto

class CustomAdapter(private val dataSet: ArrayList<Crypto>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textView : TextView

        init {
            //Define Click listener for the ViewHolder's View
            textView = view.findViewById<TextView>(R.id.textViewTitle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.main_page_row_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = dataSet[position].name
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}