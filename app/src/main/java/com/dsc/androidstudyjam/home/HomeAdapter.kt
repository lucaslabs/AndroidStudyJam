package com.dsc.androidstudyjam.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dsc.androidstudyjam.databinding.HomeItemBinding

class HomeAdapter(
    val items: List<Pair<Int, String>>,
    val itemClickListener: ItemClickListener
) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    interface ItemClickListener {
        fun onItemClick(item: Pair<Int, String>)
    }

    private lateinit var binding: HomeItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        binding = HomeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = items[position]
        binding.tvItem.text = item.second
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(item)
        }
    }

    override fun getItemCount() = items.size

    class HomeViewHolder(binding: HomeItemBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        const val PROFILE = 0
        const val MY_ITEMS = 1
        const val CART = 2
        const val CLOTHES = 3
        const val PRIZE = 4
        const val TRACKING = 5
        const val WALLET = 6
    }
}