package com.oliferov.agriculturalstore.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.oliferov.agriculturalstore.databinding.ItemGoodsBinding
import com.oliferov.agriculturalstore.domain.Goods

class GoodsAdapter() : ListAdapter<Goods, GoodsViewHolder>(GoodsDiffCallback) {

    var onGoodsClickListener: OnGoodsClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsViewHolder {
        val binding = ItemGoodsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GoodsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GoodsViewHolder, position: Int) {
        val goods = getItem(position)
        with(holder.binding) {
            with(goods) {
                tvName.text = name
                tvPrice.text = "$price"
                tvArticle.text = "$article"
                Glide.with(root).load(image).into(ivGoods)
                root.setOnClickListener {
                    onGoodsClickListener?.onGoodsClick(this)
                }
            }
        }
    }

    interface OnGoodsClickListener {
        fun onGoodsClick(goods: Goods)
    }
}