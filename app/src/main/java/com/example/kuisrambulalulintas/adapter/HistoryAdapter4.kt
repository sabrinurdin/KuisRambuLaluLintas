package com.example.kuisrambulalulintas.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity4
import com.example.kuisrambulalulintas.databinding.ItemHistoryBinding

class HistoryAdapter4(
    private var data : List<HistoryEntity4>,
    val onItemCliked : (Int,HistoryEntity4) -> Unit
): RecyclerView.Adapter<HistoryAdapter4.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryAdapter4.ViewHolder {
        val binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryAdapter4.ViewHolder, position: Int) {
        val data = data[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(val binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data : HistoryEntity4){
            binding.name.text = data.name
            binding.tvScore.text = "${data.score.toString()}/20"

            binding.root.setOnClickListener {
                onItemCliked.invoke(bindingAdapterPosition,data)
            }

        }
    }

}