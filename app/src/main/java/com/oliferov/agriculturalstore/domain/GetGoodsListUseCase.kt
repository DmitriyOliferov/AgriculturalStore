package com.oliferov.agriculturalstore.domain

class GetGoodsListUseCase(val repository: GoodsRepository){
    operator fun invoke() = repository.getGoodsList()
}