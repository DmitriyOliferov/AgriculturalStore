package com.oliferov.agriculturalstore.domain

class LoadDataUseCase(val repository: GoodsRepository) {
    operator fun invoke() = repository.loadData()
}