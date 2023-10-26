package com.example.motive.search.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.motive.R
import com.example.motive.databinding.ItemSearchBinding
import com.example.motive.search.model.Geonames
import com.example.motive.search.ui.viewholder.SearchViewHolder

internal class SearchAdapter(
    private val onClick: (geonames: Geonames) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var data: MutableList<Geonames> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding: ItemSearchBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_search,
            parent,
            false
        )
        return SearchViewHolder(binding)
    }

    override fun getItemCount()= data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? SearchViewHolder)?.bind(data.get(position), onClick)
    }

    fun updateList(data: List<Geonames>) {
        val diffCallback = DiffCallback(this.data, data)
        val diff = DiffUtil.calculateDiff(diffCallback)
        this.data.clear()
        this.data.addAll(data)
        diff.dispatchUpdatesTo(this)
    }
}

internal class DiffCallback(
    private val oldList: List<Geonames>,
    private val newList: List<Geonames>
) : DiffUtil.Callback() {
    override fun getOldListSize() =
        oldList.size

    override fun getNewListSize() =
        newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int)=
        oldList[oldItemPosition].geonameId == newList[newItemPosition].geonameId

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].geonameId == newList[newItemPosition].geonameId &&
                oldList[oldItemPosition].toponymName == newList[newItemPosition].toponymName
    }
}