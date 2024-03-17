package com.example.kuisrambulalulintas.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity3
import com.example.kuisrambulalulintas.databinding.ItemHistoryBinding

class HistoryAdapter3(
    private var data : List<HistoryEntity3>,
    val onItemCliked : (Int,HistoryEntity3) -> Unit
): RecyclerView.Adapter<HistoryAdapter3.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryAdapter3.ViewHolder {
        val binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryAdapter3.ViewHolder, position: Int) {
        val data = data[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(val binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data : HistoryEntity3){
            binding.name.text = data.name
            binding.tvScore.text = "${data.score.toString()}/15"

            binding.root.setOnClickListener {
                onItemCliked.invoke(bindingAdapterPosition,data)
            }

        }
    }

}