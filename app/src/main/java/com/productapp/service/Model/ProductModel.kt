package com.productapp.service.Model

import com.google.gson.annotations.SerializedName

data class ProductModel(
    @SerializedName("products")
    var products: List<Products>,

    @SerializedName("total")
    var total: String = "",

    @SerializedName("skip")
    var skip: Double = 0.00,

    @SerializedName("limit")
    var limit: String = ""
)

/* data class Products(
    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("title")
    var title: String = "",

    @SerializedName("description")
    var description: String = "",

    @SerializedName("price")
    var price: Double = 0.00,

    @SerializedName("rating")
    var rating: Double = 0.00,

    @SerializedName("brand")
    var brand: String = "",

    @SerializedName("category")
    var category: String = "",

    @SerializedName("thumbnail")
    var thumbnail: String = "",

    @SerializedName("images")
    var images: List<String>
) */