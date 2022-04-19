package com.oliferov.agriculturalstore.data.repository

import androidx.lifecycle.LiveData
import com.oliferov.agriculturalstore.domain.Goods
import com.oliferov.agriculturalstore.domain.GoodsRepository

class GoodsRepositoryImpl() : GoodsRepository {

    override fun getGoodsList(): LiveData<List<Goods>> {

    }

    override fun getGoods(article: Int): LiveData<Goods> {

    }

    override fun loadData() {

    }
}