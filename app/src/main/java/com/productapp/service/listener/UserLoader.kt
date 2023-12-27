package com.productapp.service.listener

import com.productapp.service.Model.Products
import com.productapp.service.Model.User

interface UserLoader<T> {
    fun onSuccess(result: User)
    fun onFailure(message: String)
}