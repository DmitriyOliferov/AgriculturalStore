package com.oliferov.agriculturalstore.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GoodsDto(
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("price")
    @Expose
    val price: Int,
    @SerializedName("gcode")
    @Expose
    val article: Int,
    @SerializedName("img_preview")
    @Expose
    val image: String
)