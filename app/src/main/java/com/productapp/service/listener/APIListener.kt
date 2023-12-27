package com.productapp.service.listener

import com.productapp.service.Model.Products

interface APIListener<T> {
    fun onSuccess(result: List<Products>)
    fun onFailure(message: String)
}