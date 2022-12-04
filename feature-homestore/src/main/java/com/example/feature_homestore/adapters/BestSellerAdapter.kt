package com.example.feature_homestore.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.api.models.BestSellers
import com.example.feature_homestore.R
import com.squareup.picasso.Picasso

class BestSellerAdapter: ListAdapter<BestSellers, RecyclerView.ViewHolder>(BestSellersDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.best_seller_item, parent, false)
        return BestSellersItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolder = holder as BestSellersItemViewHolder
        itemViewHolder.bind(getItem(position))
    }

    inner class BestSellersItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val itemImage: ImageView = itemView.findViewById(R.id.iv_item)
        private val oldPrice: TextView = itemView.findViewById(R.id.new_price)
        private val itemName: TextView = itemView.findViewById(R.id.old_price)
        private val newPrice: TextView = itemView.findViewById(R.id.item_name)
        fun bind(bestSellerItem: BestSellers) {
            with(itemView) {
                Picasso.get()
                    .load(bestSellerItem.picture)
                    .into(itemImage)

                oldPrice.text = bestSellerItem.discountPrice.toString()
                newPrice.text = bestSellerItem.priceWithoutDiscount.toString()
                itemName.text = bestSellerItem.title
            }
        }
    }

    class BestSellersDiffCallback : DiffUtil.ItemCallback<BestSellers>() {

        override fun areItemsTheSame(oldItem: BestSellers, newItem: BestSellers): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: BestSellers, newItem: BestSellers): Boolean =
            oldItem == newItem
    }
}