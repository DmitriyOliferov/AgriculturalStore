package com.oliferov.agriculturalstore.data.mapper

import com.oliferov.agriculturalstore.data.network.ApiFactory.BASE_URL
import com.oliferov.agriculturalstore.data.network.model.GoodsDto
import com.oliferov.agriculturalstore.domain.Goods

class GoodsMapper {

    fun mapGoodsDtoToGoods(goodsDto: GoodsDto) = Goods(
        name = goodsDto.name,
        price = goodsDto.price,
        article = goodsDto.article,
        image = "$BASE_URL${goodsDto.image}"
    )


}