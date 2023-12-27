package com.productapp.service.repository

import android.content.Context
import com.productapp.service.Model.ProductModel
import com.productapp.service.Model.Products
import com.productapp.service.Model.User
import com.productapp.service.listener.APIListener
import com.productapp.service.listener.APILoader
import com.productapp.service.listener.UserLoader
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class BaseRepository(val context: Context) {

    fun <T> executeCall(call: Call<ProductModel>, listener: APIListener<T>) {
        call.enqueue(object : Callback<ProductModel> {
            override fun onResponse(call: Call<ProductModel>, response: Response<ProductModel>) {
                if (response.code() == 200) {
                    response.body()?.let {
                        listener.onSuccess(it.products)
                    }
                }
            }

            override fun onFailure(call: Call<ProductModel>, t: Throwable) {
                listener.onFailure("Deu ruim aí meu bom, tenta de novo que vai!!")
            }
        })
    }

    fun <T> executeCallDetailedProduct(call: Call<Products>, loader: APILoader<T>) {
        call.enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.code() == 200) {
                    response.body()?.let {
                        loader.onSuccess(it)
                    }
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                loader.onFailure("Deu ruim aí meu bom, tenta de novo que vai!!")
            }
        })
    }

    fun <T> executeLogin(call: Call<User>, listener: UserLoader<T>) {
        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.code() == 200) {
                    response.body()?.let {
                        listener.onSuccess(it)
                    }
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                listener.onFailure("Deu ruim aí meu bom, tenta de novo que vai!!")
            }
        })
    }
}