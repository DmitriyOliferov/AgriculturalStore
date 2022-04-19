package com.oliferov.agriculturalstore.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.oliferov.agriculturalstore.data.mapper.GoodsMapper
import com.oliferov.agriculturalstore.data.network.ApiFactory
import com.oliferov.agriculturalstore.domain.Goods
import com.oliferov.agriculturalstore.domain.GoodsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GoodsRepositoryImpl() : GoodsRepository {

    override fun getGoodsList(): LiveData<List<Goods>> {
        val result = MutableLiveData<List<Goods>>()
        ApiFactory.apiService.getAllGoods()
            .map {
                GoodsMapper.mapGoodsDtoListToGoodsList(it)
            }
            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("TEST_OF_LOADING_DATA", "Success: $it")
                result.value = it
            }, {
                Log.d("TEST_OF_LOADING_DATA", "Failure: ${it.message}")
            })
        return result
    }

    override fun getGoods(article: Int): LiveData<Goods> {
        return MutableLiveData<Goods>()
    }

    override fun loadData() {
        TODO("Not yet implemented")
    }


}