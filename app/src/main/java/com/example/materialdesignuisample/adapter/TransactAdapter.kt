package com.example.materialdesignuisample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.materialdesignuisample.R
import com.example.materialdesignuisample.data.CryptoCurrent


class TransactAdapter(private val dataSet: ArrayList<CryptoCurrent>) :
    RecyclerView.Adapter<TransactAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textView: TextView
        var imageView: ImageView

        init {
            //Define Click listener for the ViewHolder's View
            textView = view.findViewById<TextView>(R.id.tvTitle)
            imageView = view.findViewById<ImageView>(R.id.imgViewItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.main_page_row_item_two, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = dataSet[position].name

        Glide.with(holder.itemView.context).load(dataSet[position].img).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}