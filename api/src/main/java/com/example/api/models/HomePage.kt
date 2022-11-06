package com.example.api.models

import com.google.gson.annotations.SerializedName

data class HomePage(
    @SerializedName("home_store")
    val hotSales: List<HotSales>,
    @SerializedName("best_seller")
    val bestSellers: List<BestSellers>
)