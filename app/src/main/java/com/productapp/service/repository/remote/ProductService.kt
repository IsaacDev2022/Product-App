package com.productapp.service.repository.remote

import com.productapp.service.Model.ProductModel
import com.productapp.service.Model.Products
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {
    @GET("products")
    fun list(): Call<ProductModel>

    @GET("products/category/{category}")
    fun getCategory(@Path(value = "category", encoded = true) category: String ): Call<ProductModel>

    @GET("products/{id}")
    fun listProduct(@Path(value = "id", encoded = true) id: Int): Call<Products>
}