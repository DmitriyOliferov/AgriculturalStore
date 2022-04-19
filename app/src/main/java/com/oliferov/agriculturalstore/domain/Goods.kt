package com.oliferov.agriculturalstore.domain

import java.io.Serializable

data class Goods (
val name: String,
val price: Int,
val article: Int,
val image: String
) : Serializable