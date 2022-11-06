package com.example.api.models

import com.google.gson.annotations.SerializedName

data class ProductDetails (
	@SerializedName("CPU") val cPU : String,
	@SerializedName("camera") val camera : String,
	@SerializedName("capacity") val capacity : List<Int>,
	@SerializedName("color") val color : List<String>,
	@SerializedName("id") val id : Int,
	@SerializedName("images") val images : List<String>,
	@SerializedName("isFavorites") val isFavorites : Boolean,
	@SerializedName("price") val price : Int,
	@SerializedName("rating") val rating : Double,
	@SerializedName("sd") val sd : String,
	@SerializedName("ssd") val ssd : String,
	@SerializedName("title") val title : String
)