package com.oliferov.agriculturalstore.domain

import androidx.lifecycle.LiveData

interface GoodsRepository {

    fun getGoodsList(): LiveData<List<Goods>>

    fun getGoods(article: Int): LiveData<Goods>

    fun loadData()
}