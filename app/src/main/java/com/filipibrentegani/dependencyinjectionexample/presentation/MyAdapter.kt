package com.filipibrentegani.dependencyinjectionexample.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.filipibrentegani.dependencyinjectionexample.R
import com.filipibrentegani.dependencyinjectionexample.data.models.RepositoryResponse

class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {
    private val items = arrayListOf<RepositoryResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position, items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(items: List<RepositoryResponse>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}

class MyViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(position: Int, item: RepositoryResponse) {
        itemView.findViewById<TextView>(R.id.textView).text = "${position + 1} - ${item.fullName}"
    }
}