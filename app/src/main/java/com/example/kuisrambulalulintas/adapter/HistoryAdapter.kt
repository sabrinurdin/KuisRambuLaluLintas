package com.example.kuisrambulalulintas.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity
import com.example.kuisrambulalulintas.databinding.ItemHistoryBinding

class HistoryAdapter(
    private var data : List<HistoryEntity>,
    val onItemCliked : (Int,HistoryEntity) -> Unit
): RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryAdapter.ViewHolder {
        val binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryAdapter.ViewHolder, position: Int) {
        val data = data[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(val binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data : HistoryEntity){
            binding.name.text = data.name
            binding.btnEdit.text = data.score.toString()

            binding.root.setOnClickListener {
                onItemCliked.invoke(bindingAdapterPosition,data)
            }

        }
    }

}