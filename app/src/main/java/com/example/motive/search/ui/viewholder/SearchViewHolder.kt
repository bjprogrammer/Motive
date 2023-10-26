package com.example.motive.search.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.motive.databinding.ItemSearchBinding
import com.example.motive.search.model.Geonames
import com.example.motive.BR

internal class SearchViewHolder(viewBinding: ItemSearchBinding) : RecyclerView.ViewHolder(viewBinding.root) {
    private val binding = viewBinding

    fun bind(geonames: Geonames?, onClick: (geonames: Geonames) -> Unit) {
        geonames?.let { geoname ->
            binding.apply {
                binding.root.setOnClickListener {
                    onClick.invoke(geoname)
                }
                setVariable(BR.data, geoname)
                executePendingBindings()
            }
        }
    }
}