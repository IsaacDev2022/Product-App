package com.productapp.service.Model

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("products")
    var users: List<Products>,

    @SerializedName("total")
    var total: String = "",

    @SerializedName("skip")
    var skip: Double = 0.00,

    @SerializedName("limit")
    var limit: String = ""
)

data class User(

    @SerializedName("token")
    var token: String = "",

    @SerializedName("firstName")
    var firstName: String = "",

    @SerializedName("lastName")
    var lastName: String = "",

    @SerializedName("email")
    var email: String = "",

    @SerializedName("image")
    var image: String = "",
)