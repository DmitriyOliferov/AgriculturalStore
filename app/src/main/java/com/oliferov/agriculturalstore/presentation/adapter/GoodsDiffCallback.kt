package com.oliferov.agriculturalstore.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.oliferov.agriculturalstore.domain.Goods

object GoodsDiffCallback: DiffUtil.ItemCallback<Goods>() {
    override fun areItemsTheSame(oldItem: Goods, newItem: Goods): Boolean {
        return oldItem.article == newItem.article
    }

    override fun areContentsTheSame(oldItem: Goods, newItem: Goods): Boolean {
        return oldItem == newItem
    }
}