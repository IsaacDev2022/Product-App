package com.productapp.service.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Products(
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
) : Parcelable