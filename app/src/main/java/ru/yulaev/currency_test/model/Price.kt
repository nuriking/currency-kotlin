package ru.yulaev.currency_test.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Price(
        @SerializedName("amount") val amount: Double
) : Serializable