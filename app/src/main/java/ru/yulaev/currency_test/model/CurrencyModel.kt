package ru.yulaev.currency_test.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CurrencyModel(
        @SerializedName("volume") val volume: Int,
        @SerializedName("price") val price: Price,
        @SerializedName("name") val name: String
):Serializable