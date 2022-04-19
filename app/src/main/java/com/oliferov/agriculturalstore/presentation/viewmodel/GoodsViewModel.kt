package com.oliferov.agriculturalstore.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.oliferov.agriculturalstore.data.repository.GoodsRepositoryImpl
import com.oliferov.agriculturalstore.domain.GetGoodsListUseCase

class GoodsViewModel(repository: GoodsRepositoryImpl): ViewModel() {

    var goodsList = GetGoodsListUseCase(repository).invoke()

}