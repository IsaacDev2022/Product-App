package com.productapp.service.repository

import android.content.Context
import com.productapp.service.Model.Products
import com.productapp.service.listener.APIListener
import com.productapp.service.listener.APILoader
import com.productapp.service.repository.remote.ProductService
import com.productapp.service.repository.remote.RetrofitClient

class ProductRepository(context: Context): BaseRepository(context) {

    private val remote = RetrofitClient.createService(ProductService::class.java)

    fun list(listener: APIListener<List<Products>>) {
        executeCall(remote.list(), listener)
    }

    fun getCategory(category: String, loader: APIListener<List<Products>>) {
        executeCall(remote.getCategory(category), loader)
    }

    fun listProduct(id: Int, loader: APILoader<Products>) {
        executeCallDetailedProduct(remote.listProduct(id), loader)
    }
}