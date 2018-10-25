package ru.yulaev.currency_test.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Stock(
        @SerializedName("stock") val stock: List<CurrencyModel>
) : Serializable