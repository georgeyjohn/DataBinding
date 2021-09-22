package com.internal.databinding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.internal.databinding.databinding.ItemAcronymBinding
import com.internal.databinding.model.AcronymDetails

class RepoListAdapter : RecyclerView.Adapter<RepoListAdapter.ViewHolder>() {

    var repos: List<AcronymDetails> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAcronymBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = repos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.itemViewModel = repos[position].acronym
    }

    class ViewHolder(val binding: ItemAcronymBinding) : RecyclerView.ViewHolder(binding.root)
}
