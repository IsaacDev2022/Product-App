package com.productapp.service.listener

import com.productapp.service.Model.Products

interface APILoader<T> {
    fun onSuccess(result: Products)
    fun onFailure(message: String)
}