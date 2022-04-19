package com.oliferov.agriculturalstore.domain

import androidx.lifecycle.LiveData

interface GoodsRepository {

    fun getGoodsList(): LiveData<List<Goods>>

}