package com.oliferov.agriculturalstore.data.network

import com.oliferov.agriculturalstore.data.network.model.GoodsDto
import com.oliferov.agriculturalstore.domain.Goods
import io.reactivex.Single
import retrofit2.http.GET



interface ApiService{

@GET(END_POINT)
fun getAllGoods(): Single<List<GoodsDto>>

companion object{
    private const val END_POINT = ":1457/products?cat_id=869&limit=10&offset=0&base_id=1&sort_type=1"

}
}