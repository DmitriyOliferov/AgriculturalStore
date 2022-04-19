package com.oliferov.agriculturalstore.domain

class GetGoodsUseCase(val repository: GoodsRepository){
    operator fun invoke(article: Int) =repository.getGoods(article)
}