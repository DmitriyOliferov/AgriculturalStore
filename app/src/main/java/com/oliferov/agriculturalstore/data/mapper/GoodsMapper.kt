package com.oliferov.agriculturalstore.data.mapper

import com.oliferov.agriculturalstore.data.network.model.GoodsDto
import com.oliferov.agriculturalstore.domain.Goods

object GoodsMapper {

    private fun mapGoodsDtoToGoods(goodsDto: GoodsDto) = Goods(
        name = goodsDto.name,
        price = goodsDto.price,
        article = goodsDto.article,
        image = "$BASE_URL${goodsDto.image}"
    )

    fun mapGoodsDtoListToGoodsList(list: List<GoodsDto>) = list.map {
        mapGoodsDtoToGoods(it)
    }

    private const val BASE_URL = "https://vimos.ru"
}